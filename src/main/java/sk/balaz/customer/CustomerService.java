package sk.balaz.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sk.balaz.exception.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException(
                            "customer with id '" + id + "' not found");

                    log.error(notFoundException.toString());
                    log.error("error in getCustomer {}", id);
                    log.error("error in getCustomer {}", id, notFoundException);

                    return notFoundException;
                });
    }
}
