package com.br.project.atomic.controller;

import com.br.project.atomic.domain.request.AtomicRequestDTO;
import com.br.project.atomic.domain.response.AtomicResponseDTO;
import com.br.project.atomic.service.impl.AtomicDatabaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
@Api(value = "Api for Atomic Database")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired private AtomicDatabaseService service;

    public CustomerController(AtomicDatabaseService service) {
        this.service = service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save values on Atomic database")
    public List<AtomicResponseDTO> saveCustomer(@RequestBody List<AtomicRequestDTO> request) {
        final var saveCustomer = service.saveCustomerService(request);

        return saveCustomer;
    }
}
