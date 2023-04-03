package at.disys.service;

import at.disys.model.Charge;
import at.disys.model.Customer;
import at.disys.repo.ChargeRepo;
import at.disys.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is responsible for dispatching the data collection to the correct
 * data collector. <br>
 *
 * <i><br>
 *     Starts the data gathering job<br>
 *     Has knowledge about the available stations<br>
 *     Sends a message for every charging station to the Station Data Collector<br>
 *     Sends a message to the Data Collection Receiver, that a new job started
 * </i>
 */

@Service
public class DataCollectionDispatcher {
    ChargeRepo chargeRepo;
    CustomerRepo customerRepo;

    @Autowired
    public DataCollectionDispatcher(ChargeRepo chargeRepo, CustomerRepo customerRepo) {
        this.chargeRepo = chargeRepo;
        this.customerRepo = customerRepo;
    }

    public  DataCollectionDispatcher() {
    }

    public LinkedList<Charge> dispatchData() {
            return null;
            //TODO: Implementieren wie die Daten empfangen werden
    }

    @Autowired
    public void setChargeRepo(ChargeRepo chargeRepo) {
        this.chargeRepo = chargeRepo;
    }

    @Autowired
    public void setCustomerRepo(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

}
