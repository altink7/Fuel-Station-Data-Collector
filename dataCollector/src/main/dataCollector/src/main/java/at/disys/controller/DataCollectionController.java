package at.disys.controller;

import at.disys.service.DataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * This class is responsible for the REST API. <br>
 * There are two API routes: <br>
 *
 *  <li>Description:</li> <br>
 *  <b>/invoices/<customer-id> [POST] </b><br>
 *  <li>Starts data gathering job</li><br>
 *  <b>/invoices/<customer-id> [GET]</b> <br>
 *  <li>Returns invoice PDF with download link and creation time</li>
 *  <li>Returns 404 Not Found, if it’s not available</li>
 *
 */
@Controller
@RequestMapping("/api")
public class DataCollectionController {
    DataCollectionService dataCollectionService;

    /**
     * Returns invoice PDF with download link and creation time
     * Returns 404 Not Found, if it’s not available
     * @param customerId customer id
     * @return invoice PDF with download link and creation time
     */
    @GetMapping("/invoices/{customer-id}")
    public String getInvoice(@PathVariable("customer-id") String customerId) {

        return "invoice";
    }

    /**
     * Starts data gathering job
     * Returns 202 Accepted
     * Returns 404 Not Found, if the customer is not found
     * @param customerId customer id
     * @return 202 Accepted
     */
    @PostMapping("/invoices/{customer-id}")
    public ResponseEntity<Void> startDataGathering(@PathVariable("customer-id") String customerId) {
        boolean customerExists = dataCollectionService.checkCustomerExists(customerId);

        if (customerExists) {
            dataCollectionService.publishDataGatheringJob(customerId);
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Autowired
    public void setDataCollectionService(DataCollectionService dataCollectionService) {
        this.dataCollectionService = dataCollectionService;
    }
}
