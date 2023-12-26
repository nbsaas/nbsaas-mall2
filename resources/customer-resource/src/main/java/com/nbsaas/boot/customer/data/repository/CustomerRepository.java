package com.nbsaas.boot.customer.data.repository;

import com.nbsaas.boot.customer.data.entity.Customer;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface CustomerRepository  extends  JpaRepositoryImplementation<Customer, Serializable>{

}