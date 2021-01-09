/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import com.pooespol.proyecto2_poo.data.ProductosData;
import com.pooespol.proyecto2_poo.modelo.Producto;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

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

    @FXML
    private void mostrarBebidasSuaves(MouseEvent event) {
        
        FPproductos.getChildren().clear();
            List<Producto> productos = ProductosData.parsearProductos("softdrinks");
            for (Producto p :productos){
                VBox vboxproducto = new VBox();

                Label lnombre = new Label(p.getNombre());
                vboxproducto.getChildren().add(lnombre);

                Label lanio = new Label(String.valueOf(p.getPrecio()));
                vboxproducto.getChildren().add(lanio);

                FPproductos.getChildren().add(FPproductos);
            }
    }

    @FXML
    private void mostrarBebidasCalientes(MouseEvent event) {
        //prueba
        FPproductos.getChildren().clear();
        Label l = new Label("");
        FPproductos.getChildren().add(l);
        //
    }

    @FXML
    private void mosrtarMilkshakes(MouseEvent event) {
    }

    @FXML
    private void mostrarCervezas(MouseEvent event) {
    }

    @FXML
    private void mostrarVinos(MouseEvent event) {
    }

    @FXML
    private void mostrarBebidasImportadas(MouseEvent event) {
    }

    @FXML
    private void mostrarCocteles(MouseEvent event) {
    }
    
}
