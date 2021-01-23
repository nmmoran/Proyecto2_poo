/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class CrearMesasController implements Initializable {

    @FXML
    private Button btnCrear;
    @FXML
    private TextField txtnum;
    @FXML
    private TextField txtcapMesas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Button getBtnCrear() {
        return btnCrear;
    }

    public void setBtnCrear(Button btnCrear) {
        this.btnCrear = btnCrear;
    }

    public TextField getTxtnum() {
        return txtnum;
    }

    public void setTxtnum(TextField txtnum) {
        this.txtnum = txtnum;
    }

    public TextField getTxtcapMesas() {
        return txtcapMesas;
    }

    public void setTxtcapMesas(TextField txtcapMesas) {
        this.txtcapMesas = txtcapMesas;
    }
    @FXML
    public void cerrarVentana(Event event) {
 
    Node source = (Node) event.getSource();
    Stage stage = (Stage) source.getScene().getWindow();
    stage.close();
}
}
