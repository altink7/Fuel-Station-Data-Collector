package at.disys.controller;

import org.springframework.stereotype.Controller;

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
public class DataCollectionController {
}
