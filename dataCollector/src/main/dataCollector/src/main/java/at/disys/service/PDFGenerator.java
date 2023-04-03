package at.disys.service;

import at.disys.model.Charge;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

/**
 * This class is responsible for generating the PDF report.<br>
 *
 * <i> <br>
 * Generates the invoice from data<br>
 * Saves PDF to the file system
 * </i>
 */
@Service
public class PDFGenerator {
    DataCollectionReceiver dataCollectionReceiver;


    @Autowired
    public PDFGenerator(DataCollectionReceiver dataCollectionReceiver) {
        this.dataCollectionReceiver = dataCollectionReceiver;
    }


    public void createPdfForCharge(Charge charge) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("bill.pdf"));
            document.open();

            document.add(new Paragraph("Rechnungsnummer: " + charge.getId().toString()));
            document.add(new Paragraph("Kunde:" + charge.getCustomer().getFirstName() + " " + charge.getCustomer().getLastName()));
            document.add(new Paragraph("Betrag: " + String.format(" %.2f €", calculateCosts(charge, 0.29175))));

        } catch (Exception e) {
            e.printStackTrace();
        }

        document.close();
    }

    public void createPdf() {
        LinkedList<Charge> data = dataCollectionReceiver.receiveData();

        for (Charge charge : data) {
            createPdfForCharge(charge);
        }
    }

    public Double calculateTotalCosts(LinkedList<Charge> data, double PricePerKwh) {
        double totalCosts = 0.0;
        for (Charge charge : data) {
            totalCosts += charge.getKwh() * PricePerKwh;
        }
        return totalCosts;
    }

    public Double calculateCosts(Charge data, double PricePerKwh) {
        double totalCosts = 0.0;
        totalCosts += data.getKwh() * PricePerKwh;
        return totalCosts;
    }

    @Autowired
    public void setDataCollectionReceiver(DataCollectionReceiver dataCollectionReceiver) {
        this.dataCollectionReceiver = dataCollectionReceiver;
    }


}
