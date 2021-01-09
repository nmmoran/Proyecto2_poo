/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import com.pooespol.proyecto2_poo.data.ProductosData;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class AdministradorController implements Initializable {

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
    @FXML
    private TextField txtFechaInicial;
    @FXML
    private TextField txtFechaFinal;
    @FXML
    private Button btBuscar;
    @FXML
    private FlowPane fpMuestraMenu;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtRuta;
    @FXML
    private ComboBox<String> cbOpTipo1;
    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnCancel1;
    @FXML
    private TextField txtNewName;
    @FXML
    private TextField txtNewPrecio;
    @FXML
    private TextField txtNewRuta;
    @FXML
    private Button btnModify;
    @FXML
    private Button btnCancel2;
    @FXML
    private Circle C1;
    @FXML
    private Circle C2;
    @FXML
    private Circle C4;
    @FXML
    private Circle C3;
    @FXML
    private Circle C5;
    @FXML
    private Circle C7;
    @FXML
    private Circle C6;
    @FXML
    private Circle C8;
    @FXML
    private Circle C9;
    @FXML
    private Circle C10;
    @FXML
    private Circle C11;
    @FXML
    private Circle C12;
    @FXML
    private Circle C13;
    @FXML
    private Circle C14;
    @FXML
    private Circle C15;
    @FXML
    private TextField txtNewNa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            ArrayList<String> tipos= ProductosData.obtenerTipos();
            cbOpTipo1.setItems(FXCollections.observableArrayList(tipos));
        
    }   
    


    @FXML
    private void buscarFechas(MouseEvent event) {
    }

    @FXML
    private void añadirNuevoProducto(MouseEvent event) {
    }

    @FXML
    private void limpiarFields(MouseEvent event) {
    }

    @FXML
    private void modificarProducto(MouseEvent event) {
    }
    
}
