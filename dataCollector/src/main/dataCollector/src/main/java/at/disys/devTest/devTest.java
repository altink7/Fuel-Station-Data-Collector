package at.disys.devTest;

import at.disys.service.DataCollectionDispatcher;
import at.disys.service.DataCollectionReceiver;
import at.disys.service.PDFGenerator;
import at.disys.service.StationDataCollector;

public class devTest {

    public static void main(String[] args) {
        PDFGenerator PDFGenerator = new PDFGenerator(
                new DataCollectionReceiver(
                        new StationDataCollector(
                                new DataCollectionDispatcher())));
        PDFGenerator.createPdf();
    }
}
