package com.br.project.atomic.repository;

import com.br.project.atomic.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtomicRepository extends JpaRepository<Customer, String> {
}
