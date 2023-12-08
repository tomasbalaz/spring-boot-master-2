package sk.balaz.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomers() {
        return customerRepo.getCustomers();
    }

    public Customer getCustomer(Long id) {
        return customerRepo.getCustomers()
                .stream()
                .filter(customer -> customer.id() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Customer with id [%s] not found",id)));
    }
}
