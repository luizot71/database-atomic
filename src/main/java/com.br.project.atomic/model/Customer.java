package com.br.project.atomic.model;

import com.br.project.atomic.domain.request.AtomicRequestDTO;
import com.br.project.atomic.domain.response.AtomicResponseDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER_REGISTRATION")
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(
        name = "SEQ_CUSTOMER",
        sequenceName = "SEQ_CUSTOMER",
        allocationSize = 1)
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUSTOMER")
    @Column(name = "id", insertable = false, nullable = false, updatable = false, unique = true)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "address", nullable = false)
    private String address;

    public Customer() {}

    public Customer(
            long id,
            String name,
            String cpf,
            String address) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
    }

    public Customer(String name, String cpf, String address) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
    }

    public static List<Customer> fromDTO(Iterable<AtomicRequestDTO> request) {
        final List<Customer> response = new ArrayList<>();

        for (final var operation : request) {
            final var customer = new Customer();

            customer.setId(operation.getId());
            customer.setName(operation.getName());
            customer.setCpf(operation.getCpf());
            customer.setAddress(operation.getAddress());

            response.add(customer);
        }
        return response;
    }

    public static List<AtomicResponseDTO> toDTO(Iterable<Customer> request) {
        final List<AtomicResponseDTO> response = new ArrayList<>();

        for (final var operation : request) {
            final var atomic = new AtomicResponseDTO();
            atomic.setId(operation.getId());
            atomic.setName(operation.getName());
            atomic.setCpf(operation.getCpf());
            atomic.setAddress(operation.getAddress());

            response.add(atomic);
        }
        return response;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
