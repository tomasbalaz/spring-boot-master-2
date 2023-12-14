package sk.balaz.customer;

import org.springframework.stereotype.Service;
import sk.balaz.exception.NotFoundException;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Customer with id [%s] not found",id)));
    }
}
