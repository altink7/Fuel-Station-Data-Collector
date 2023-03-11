package at.disys.repo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * This class represents a charge of a customer.
 * <i> <br>
 *    id SERIAL PRIMARY KEY, <br>
 *    kwh REAL NOT NULL,     <br>
 *    customer_id INTEGER NOT_NULL</i>
 */

@Entity(name = "charge")
public class charge {
    @Id
    private Long id;

    @Column(name = "kwh",
            nullable = false,
            columnDefinition = "REAL")
    private Long kwh;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private customer customer;

    public Long getKwh() {
        return kwh;
    }

    public void setKwh(Long kwh) {
        this.kwh = kwh;
    }

    public customer getCustomer() {
        return customer;
    }

    public void setCustomer(customer customer) {
        this.customer = customer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
