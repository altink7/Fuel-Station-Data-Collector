package at.disys.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * This class represents a station central database.
 * <i> <br>
 * CREATE TABLE IF NOT EXISTS station (<br>
 *    id SERIAL PRIMARY KEY,<br>
 *    db_url VARCHAR(255) NOT NULL,<br>
 *    lat REAL NOT NULL,<br>
 *    lng REAL NOT NULL<br>
 * ); </i>
 */

@Entity
public class Station {
    @Id
    private Long id;

    @Column(name = "db_url",
            nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String dbUrl;

    @Column(name = "lat",
            nullable = false,
            columnDefinition = "REAL")
    private Double lat;

    @Column(name = "lng",
            nullable = false,
            columnDefinition = "REAL")
    private Double lng;

    public Station() {
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
