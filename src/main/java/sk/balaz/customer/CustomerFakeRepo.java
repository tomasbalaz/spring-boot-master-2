package sk.balaz.customer;

import java.util.List;

public class CustomerFakeRepo implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(1l, "James Bond","1234"),
                new Customer(2l, "Tomas Tomas", "1234")
        );
    }
}
