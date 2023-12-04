package sk.balaz.customer;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "fake")
public class CustomerFakeRepo implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(1l, "James Bond"),
                new Customer(2l, "Tomas Tomas")
        );
    }
}
