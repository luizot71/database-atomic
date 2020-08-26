package com.br.project.atomic.service.impl;

import com.br.project.atomic.domain.request.AtomicRequestDTO;
import com.br.project.atomic.domain.response.AtomicResponseDTO;
import com.br.project.atomic.model.Customer;
import com.br.project.atomic.repository.AtomicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtomicDatabaseServiceImpl implements AtomicDatabaseService {

    @Autowired private AtomicRepository atomicRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(AtomicDatabaseServiceImpl.class);

    @Override
    public List<AtomicResponseDTO> saveCustomerService(List<AtomicRequestDTO> request) {
        atomicRepository.deleteAll();
        atomicRepository.flush();
        final var customerList = Customer.fromDTO(request);
        return Customer.toDTO(atomicRepository.saveAll(customerList));
    }
}
