/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class VistaCuentaMesaController implements Initializable {

    @FXML
    private GridPane GPcuenta;
    @FXML
    private TextField txtFiltro;
    @FXML
    private Button btnBebidasSuaves;
    @FXML
    private Button btnBebidasCalientes;
    @FXML
    private Button btnMilk;
    @FXML
    private Button btnCervezas;
    @FXML
    private Button btnVinos;
    @FXML
    private Button btnBebidasImportadas;
    @FXML
    private Button btnCocteles;
    @FXML
    private FlowPane FPproductos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void finalizarOrden(MouseEvent event) {
    }

    @FXML
    private void mostrarRestaurante(MouseEvent event) {
    }
    
}
