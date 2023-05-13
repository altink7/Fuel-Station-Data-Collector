package at.disys.model;

import jakarta.persistence.*;

/**
 * This class represents a charge of a customer.
 * <i> <br>
 *    id SERIAL PRIMARY KEY, <br>
 *    kwh REAL NOT NULL,     <br>
 *    customer_id INTEGER NOT_NULL</i>
 */

@Entity(name = "charge")
public class Charge {
    @Id
    private Long id;

    @Column(name = "kwh",
            nullable = false,
            columnDefinition = "REAL")
    private Long kwh;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Charge() {
    }

    public Long getKwh() {
        return kwh;
    }

    public void setKwh(Long kwh) {
        this.kwh = kwh;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
