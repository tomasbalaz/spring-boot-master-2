package sk.balaz.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// Jackson Fasterxml annotations
// https://www.geeksforgeeks.org/jackson-annotations-for-java-application/
public record Customer(
        @JsonProperty("customer_id")
        long id,
        @NotBlank(message = "name must be not empty")
        String name,
        @NotBlank(message = "password must be not empty")
        String password,
        @NotBlank(message = "email must be not empty")
        @Email
        String email) {
}
