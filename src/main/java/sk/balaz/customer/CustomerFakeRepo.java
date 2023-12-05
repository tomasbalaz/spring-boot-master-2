package sk.balaz.customer;

import java.util.List;

public class CustomerFakeRepo implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(1l, "James Bond"),
                new Customer(2l, "Tomas Tomas")
        );
    }
}
