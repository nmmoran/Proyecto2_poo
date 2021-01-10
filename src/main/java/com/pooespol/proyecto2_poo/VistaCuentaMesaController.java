/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import com.pooespol.proyecto2_poo.data.ProductosData;
import com.pooespol.proyecto2_poo.modelo.Producto;
import com.pooespol.proyecto2_poo.modelo.Restaurante;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    Restaurante r;
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
         App.inicializarProductos(FPproductos);
        
         
    }    

    @FXML
    private void finalizarOrden(MouseEvent event) {
    }

    @FXML
    private void mostrarRestaurante(MouseEvent event) {
    }

    @FXML
    private void mostrarBebidasSuaves(MouseEvent event) throws IOException {
        FPproductos.getChildren().clear();
        List<Producto> productos;
        try {
            productos = ProductosData.leerProducto();
            for (Producto p :productos){
                VBox vboxproducto = new VBox();
                //se añade la imagen
                InputStream inputImg = App.class.getResource(p.getImagen()).openStream();
                ImageView imgv = new ImageView(new Image(inputImg));
                vboxproducto.getChildren().add(imgv);
                //se añade el nombre         
                Label lnombre = new Label(p.getNombre());
                vboxproducto.getChildren().add(lnombre);
                //se añade el precio
                Label lpercio = new Label(String.valueOf(p.getPrecio()));
                vboxproducto.getChildren().add(lpercio);
                vboxproducto.setPadding(new Insets(2,3,3,4));  
                
                FPproductos.getChildren().add(vboxproducto);
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
    }

    @FXML
    private void mostrarBebidasCalientes(MouseEvent event) {
        //prueba
        FPproductos.getChildren().clear();
        Label l = new Label("hola");
        FPproductos.getChildren().add(l);
        //
    }

    @FXML
    private void mosrtarMilkshakes(MouseEvent event) {
        FPproductos.getChildren().clear();
        Label l = new Label("como ");
        FPproductos.getChildren().add(l);
    }

    @FXML
    private void mostrarCervezas(MouseEvent event) {
        FPproductos.getChildren().clear();
        Label l = new Label("estas");
        FPproductos.getChildren().add(l);
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
