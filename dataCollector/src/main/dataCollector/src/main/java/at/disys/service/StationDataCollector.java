package at.disys.service;

import at.disys.model.Charge;
import at.disys.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

/**
 * This class is responsible for collecting the data from the station. <br>
 *
 * <i> <br>
 *     Gathers data for a specific customer from a specific charging station<br>
 *     Sends data to the Data Collection Reciever
 *</i>
 */

@Service
public class StationDataCollector {

    DataCollectionDispatcher dataCollectionDispatcher;

    @Autowired
    public StationDataCollector(DataCollectionDispatcher dataCollectionDispatcher) {
        this.dataCollectionDispatcher = dataCollectionDispatcher;
    }

    public LinkedList<Charge> getDataForSpecificCustomer(Customer customer, Charge charge) {
        LinkedList<Charge> charges = dataCollectionDispatcher.dispatchData();
            if (charge.getCustomer().equals(customer)) {
                if(charges == null) {
                    charges = new LinkedList<Charge>();
                }
                charges.add(charge);
                }
            return charges;
    }

    @Autowired
    public void setDataCollectionDispatcher(DataCollectionDispatcher dataCollectionDispatcher) {
        this.dataCollectionDispatcher = dataCollectionDispatcher;
    }
}
