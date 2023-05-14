package at.disys.service;

import at.disys.data.ChargeDao;
import at.disys.data.CustomerDao;
import at.disys.data.StationDao;
import at.disys.queue.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Business logic for the data collection.
 */

@Service
public class DataCollectionService {
    CustomerDao customerDao;
    ChargeDao chargeDao;
    StationDao stationDao;
    DataCollectionDispatcher dataCollectionDispatcher;

    /**
     * this method checks if the customer exists
     * @param customerId customer Id
     */
    public boolean checkCustomerExists(String customerId) {
        return customerDao.existsById(Long.parseLong(customerId));
    }

    public void publishDataGatheringJob(String customerId) {
        MessagePublisher messagePublisher = new MessagePublisher("data-collection-queue");

        try {
            messagePublisher.connect();
            messagePublisher.sendMessage(customerId);
            messagePublisher.close();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
    //test Main method

    public static void main(String[] args) {
    	DataCollectionService dcs = new DataCollectionService();
    	dcs.publishDataGatheringJob("1");
    }
    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setChargeDao(ChargeDao chargeDao) {
        this.chargeDao = chargeDao;
    }

    @Autowired
    public void setStationDao(StationDao stationDao) {
        this.stationDao = stationDao;
    }

    @Autowired
    public void setDataCollectionDispatcher(DataCollectionDispatcher dataCollectionDispatcher) {
        this.dataCollectionDispatcher = dataCollectionDispatcher;
    }
}
