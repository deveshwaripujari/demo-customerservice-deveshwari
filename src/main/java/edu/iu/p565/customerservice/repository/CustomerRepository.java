package edu.iu.p565.customerservice.repository;

import java.util.ArrayList;
import java.util.List;


import edu.iu.p565.customerservice.model.Customer;

public class CustomerRepository {
    private List<Customer> repository = new ArrayList<>();

    public List<Customer> findAll(){
        return repository;
    }
}
