/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author nicol
 */
public class OpcionesController implements Initializable {


    @FXML
    private Button btnEliminarM;
    @FXML
    private Button BtnModificarM;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Button getBtnEliminarM() {
        return btnEliminarM;
    }

    public void setBtnEliminarM(Button btnEliminarM) {
        this.btnEliminarM = btnEliminarM;
    }

    public Button getBtnModificarM() {
        return BtnModificarM;
    }

    public void setBtnModificarM(Button BtnModificarM) {
        this.BtnModificarM = BtnModificarM;
    }
    @FXML
    public void cerrarVentanaEliminar(Event event) {
    Node source = (Node) event.getSource();
    Stage stage = (Stage) source.getScene().getWindow();
    stage.close();
}
}
