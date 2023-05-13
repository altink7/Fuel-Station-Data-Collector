package at.disys.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * This class represents a customer.
 * <i> <br>
 *    id SERIAL PRIMARY KEY, <br>
 *    first_name VARCHAR(255) NOT NULL, <br>
 *    last_name VARCHAR(255) NOT NULL</i>
 */

@Entity(name = "customer")
public class Customer {
    @Id
    private Long id;

    @Column(name = "first_name",
            nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String firstName;

    @Column(name = "last_name",
            nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String lastName;

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
