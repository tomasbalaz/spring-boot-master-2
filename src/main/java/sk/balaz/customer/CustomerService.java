package sk.balaz.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer getCustomer() {
        return new Customer(1l, "James Bond");
    }
}
