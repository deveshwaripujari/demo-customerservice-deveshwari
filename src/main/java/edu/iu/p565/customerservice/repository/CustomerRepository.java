package edu.iu.p565.customerservice.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



import edu.iu.p565.customerservice.model.Customer;
@Repository
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll(){

        return customers;
    }

    public int create(Customer customer){
        int id = customers.size() + 1;
        customer.setId(id);
        customers.add(customer);
        return id;

    }

    public void update(Customer customer, int id){
        Customer x = getCustomerById(id);
        if(x!=null){
            x.setName(customer.getName());
            x.setEmail(customer.getEmail());
        } else {
            throw new IllegalStateException("customer w/ this id was not found/invalid");
        }
    }

    private Customer getCustomerById(int id) {
        return customers.stream().filter(x -> x.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void delete(int id){
        Customer x = getCustomerById(id);
        if(x!=null){
            customers.remove(x);
        }else {
            throw new IllegalStateException("customer w/ this id was not found/invalid");
        }
    }
}