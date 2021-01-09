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

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
/**
 * FXML Controller class
 *
 * @author nicol
 */
public class MeseroController implements Initializable {


    @FXML
    private Label lblInfoMesa;
    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;
    @FXML
    private Circle c4;
    @FXML
    private Circle c5;
    @FXML
    private Circle c7;
    @FXML
    private Circle c6;
    @FXML
    private Circle c8;
    @FXML
    private Circle c9;
    @FXML
    private Circle c10;
    @FXML
    private Circle c11;
    @FXML
    private Circle c12;
    @FXML
    private Circle c13;
    @FXML
    private Circle c14;
    @FXML
    private Circle c15;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void abrirCuenta(MouseEvent event) {
        App.setRoot("vistaCuentaMesa");
    }

}
