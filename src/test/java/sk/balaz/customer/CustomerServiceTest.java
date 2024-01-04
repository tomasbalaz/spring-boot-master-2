package sk.balaz.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerServiceTest {

    private CustomerService underTest;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer tomas = new Customer(
                1L,
                "tomas",
                "password",
                "tomas@gamil.com"
        );

        Customer jane = new Customer(
                2L,
                "jane",
                "password",
                "jane@gamil.com"
        );

        customerRepository.saveAll(List.of(tomas,jane));

        List<Customer> customers = underTest.getCustomers();

        assertThat(customers).hasSize(2);
    }

    @Test
    void getCustomer() {

        // given
        Customer tomas = new Customer(
                1L,
                "tomas",
                "password",
                "tomas@gamil.com"
        );

        customerRepository.save(tomas);

        // when
        Customer customer = underTest.getCustomer(1L);

        // then
        assertThat(customer.getId()).isEqualTo(1L);
        assertThat(customer.getName()).isEqualTo("tomas");
        assertThat(customer.getPassword()).isEqualTo("password");
        assertThat(customer.getEmail()).isEqualTo("tomas@gamil.com");
    }
}