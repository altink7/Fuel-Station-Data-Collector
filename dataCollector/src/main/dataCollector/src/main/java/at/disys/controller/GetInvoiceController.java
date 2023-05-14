package at.disys.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class GetInvoiceController {

    public TextField fieldCustomerId;

    public void onClickBtnConfirm(ActionEvent actionEvent) {
        String inputCustomerId = fieldCustomerId.getText();
    }

    public void onClickBtnDelete(ActionEvent actionEvent) {
        fieldCustomerId.clear();
    }

    public void onClickBtnClose(ActionEvent actionEvent) {
        System.exit(-1);
    }
}
