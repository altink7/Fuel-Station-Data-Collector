package at.disys.service;

import at.disys.model.Charge;
import at.disys.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

/**
 * This class is responsible for receiving the data collection from the data
 * collector. <br>
 *
 * <i> <br>
 * Receives all collected data<br>
 * Sort the data to the according gathering job<br>
 * Sends data to the PDF Generator when the data is complete
 * </i>
 */
@Service
public class DataCollectionReceiver {
    StationDataCollector stationDataCollector;

    @Autowired
    public DataCollectionReceiver(StationDataCollector stationDataCollector) {
        this.stationDataCollector = stationDataCollector;
    }


    public LinkedList<Charge> receiveData() {
        //Test Data vorerst kommt dann weg und wird richtig implementiert
        Customer customer = new Customer("Juli", "Hoffi");
        Charge charge = new Charge(1L, 100L, customer);
        return stationDataCollector.getDataForSpecificCustomer(customer, charge);

        //TODO: Implementieren wie die Daten empfangen werden
    }

    @Autowired
    public void setStationDataCollector(StationDataCollector stationDataCollector) {
        this.stationDataCollector = stationDataCollector;
    }
}
