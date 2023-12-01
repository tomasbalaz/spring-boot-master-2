package sk.balaz.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.balaz.Application;

@RestController
public class CustomerController {

    @GetMapping
    public Customer getCustomer() {
        return new Customer(1l, "James Bond");
    }
}
