package com.rev.cat.catservice.service;

import com.rev.cat.catservice.domain.Customer;
import com.rev.cat.catservice.dto.CustomerRequestDTO;
import com.rev.cat.catservice.repository.CustomerRepository;
import com.rev.cat.catservice.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService extends GenericService<Customer, CustomerRequestDTO> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer delete(String id) {
        Customer customer = findById(id);

        customerRepository.delete(customer);

        return customer;
    }

    @Override
    public Customer insert(CustomerRequestDTO dto) {
        Customer customer = buildCreateEmployee(dto);

        customerRepository.insert(customer);

        return customer;
    }

    @Override
    public Customer update(String id, CustomerRequestDTO dto) {
        Customer customer = findById(id);

        buildUpdateEmployee(customer, dto);
        customerRepository.save(customer);

        return customer;
    }

    private Customer buildCreateEmployee(CustomerRequestDTO dto) {
        Customer customer = new Customer();

        setEmployeeInformation(dto, customer);

        return customer;
    }

    private void buildUpdateEmployee(Customer customer, CustomerRequestDTO dto) {

        setEmployeeInformation(dto, customer);
    }

    private static void setEmployeeInformation(CustomerRequestDTO dto, Customer employee) {
        employee.setCI(dto.getCI());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAddress(dto.getAddress());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
    }
}
