package at.disys.db;

/**
 * This class is responsible for the database access of the station entity.
 */
public enum ConnectionURL {
    STATION1("jdbc:postgresql://localhost:30011/stationdb"),
    STATION2("jdbc:postgresql://localhost:30012/stationdb"),
    STATION3("jdbc:postgresql://localhost:30013/stationdb"),
    CUSTOMER("jdbc:postgresql://localhost:30001/customerdb");
    private final String url;
    ConnectionURL(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
}
