package com.dersler.new_play_sales.Services.concrete;

import com.dersler.new_play_sales.Entities.Customer;
import com.dersler.new_play_sales.Repository.CustomerRepository;
import com.dersler.new_play_sales.Services.abstracts.ICustomerCheckService;
import com.dersler.new_play_sales.Services.abstracts.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerManager implements ICustomerService {

    private final CustomerRepository customerRepository;

    /*public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }*/

    private final ICustomerCheckService customerCheckService;


    public CustomerManager(CustomerRepository customerRepository, ICustomerCheckService customerCheckService) {
        this.customerRepository = customerRepository;
        this.customerCheckService = customerCheckService;
    }



    @Override
    public ResponseEntity<String> add(Customer customer) {
        try {
            if(customerCheckService.CheckIfRealPerson(customer)){
               customerRepository.save(customer);
               return ResponseEntity.ok("Hesabınız başarılı bir şekilde oluşturuldu");
            }else{
                System.out.println("Not a valid person");
                return ResponseEntity.badRequest().body("Girilen bilgiler yanlıştır");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getOneCustomer(int Id) {
        return customerRepository.findById(Id);
    }

    @Override
    public Customer updateCustomer(int Id, Customer customer) {
        Optional<Customer> customer1 = customerRepository.findById(Id);
        if(customer1.isPresent()){
            Customer toupdateCustomer = customer1.get();
            if(customer.getFirstName() != toupdateCustomer.getFirstName() && customer.getFirstName().length()>0)
                toupdateCustomer.setFirstName(customer.getFirstName());
            if(customer.getLastName() != toupdateCustomer.getLastName() && customer.getLastName().length()>0)
                toupdateCustomer.setLastName(customer.getLastName());
            if(customer.getNationalityId() != toupdateCustomer.getNationalityId() && customer.getNationalityId().length()>10 && customer.getNationalityId().length()<12)
                toupdateCustomer.setNationalityId(customer.getNationalityId());
            if(customer.getYearOfBirth() != toupdateCustomer.getYearOfBirth())
                toupdateCustomer.setYearOfBirth(customer.getYearOfBirth());

            try {
                if(customerCheckService.CheckIfRealPerson(toupdateCustomer)){
                    return customerRepository.save(toupdateCustomer);
                }else{
                    System.out.println("Not a valid person");
                    return null;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }else{
            System.out.println("Not a valid person");
            return null;
        }

    }

    @Override
    public void deleteCustomer(int customerId) {
        System.out.println("Customer Manager params " + customerId);
        customerRepository.deleteById(customerId);

    }


}
