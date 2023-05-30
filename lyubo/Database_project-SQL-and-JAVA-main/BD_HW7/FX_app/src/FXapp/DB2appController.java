package FXapp;

import db2.DB2Test;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class DB2appController {


    @FXML
    private Button btnExit;

    @FXML
    private Button btnProceed;
    @FXML
    private Label lblInformation;
    @FXML
    private TextField txtInput;
    private final DB2Test db2Object = new DB2Test();

    private final Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    void btnExitOnAction() {


        System.exit(0);
        db2Object.closeConnection();
    }

    @FXML
    void btnProceedOnAction() {
        String statement = txtInput.getText();
        if (statement.toUpperCase().contains("INSERT")) {

            if (db2Object.insert(statement)) {

                lblInformation.setTextFill(Color.GREEN);
                lblInformation.setText("Successfully inserted!");
            } else {

                lblInformation.setTextFill(Color.RED);
                lblInformation.setText("INSERT ERROR OCCURRED");
            }

        } else if (statement.toUpperCase().contains("DELETE")) {

            if (db2Object.delete(statement)) {

                lblInformation.setTextFill(Color.GREEN);
                lblInformation.setText("Successfully deleted!");
            } else {

                lblInformation.setTextFill(Color.RED);
                lblInformation.setText("DELETE ERROR OCCURRED");
            }

        } else if (statement.toUpperCase().contains("SELECT")) {

            String s = db2Object.select(statement);
            alertDialog.setHeaderText(s);
            alertDialog.showAndWait();
        } else {

            lblInformation.setTextFill(Color.RED);
            lblInformation.setText("INVALID COMMAND");
        }
        txtInput.setText("");
    }

    @FXML
    void initialize() {
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'app_view.fxml'.";
        assert btnProceed != null : "fx:id=\"btnProceed\" was not injected: check your FXML file 'app_view.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'app_view.fxml'.";
        assert lblInformation != null : "fx:id=\"lblInformation\" was not injected: check your FXML file 'app_view.fxml'.";
        db2Object.openConnection();
    }

}
