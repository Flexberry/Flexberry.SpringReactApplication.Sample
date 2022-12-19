package net.flexberry.flexberrySampleSpring.repository;

import net.flexberry.flexberrySampleSpring.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends RevisionRepository<Customer, Integer, Integer>, JpaRepository<Customer, Integer> {
}
