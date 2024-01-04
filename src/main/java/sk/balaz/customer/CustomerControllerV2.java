package sk.balaz.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sk.balaz.exception.ApiRequestException;

import java.util.List;

@RestController
@RequestMapping("api/v2/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerControllerV2 {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomer() {
        return List.of(
                new Customer(0L, "v2", "v2", "email@email.com")
        );
    }
    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }


    @PostMapping
    public void createCustomer(@Valid @RequestBody Customer customer) {
        log.info("POST REQUEST...");
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) {
        log.info("UPDATE REQUEST...");
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id) {
        log.info("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
    }

    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException(
                "ApiRequestException for id : " + id
        );
    }
}
