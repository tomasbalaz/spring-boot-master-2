package sk.balaz.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

// Jackson Fasterxml annotations
// https://www.geeksforgeeks.org/jackson-annotations-for-java-application/
public record Customer(
        @JsonProperty("customer_id")
        long id,
        String name,
        @JsonIgnore
        String password) {
}
