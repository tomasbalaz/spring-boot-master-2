package sk.balaz.customer;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class CustomerRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        //TODO connect to real DB
        return Collections.emptyList();
    }
}
