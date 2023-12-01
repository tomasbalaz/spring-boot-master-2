package sk.balaz.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

   // private final CustomerService customerService = new CustomerService();
    private CustomerService customerService;

    public CustomerController() {
        this.customerService = new CustomerService();
    }

    @GetMapping
    public Customer getCustomer() {
        return customerService.getCustomer();
    }
}
