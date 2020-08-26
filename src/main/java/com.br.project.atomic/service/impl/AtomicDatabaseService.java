package com.br.project.atomic.service.impl;

import com.br.project.atomic.domain.request.AtomicRequestDTO;
import com.br.project.atomic.domain.response.AtomicResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AtomicDatabaseService {

    List<AtomicResponseDTO> saveCustomerService(@RequestBody List<AtomicRequestDTO> request);
}
