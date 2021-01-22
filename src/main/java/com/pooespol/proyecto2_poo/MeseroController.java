/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import com.pooespol.proyecto2_poo.data.MesaData;
import com.pooespol.proyecto2_poo.modelo.Mesa;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
/**
 * FXML Controller class
 *
 * @author Dustin Pisco
 */
public class MeseroController implements Initializable {


    @FXML
    private Label labelMesero;
    @FXML
    private Pane paneMesas;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int n=1;
      try {
            ArrayList<Mesa> mesas = MesaData.leerMesas();
            for(Mesa mesa: mesas){
                
               if (mesa.getCapacidad()==4){
                   
                   Circle c = new Circle(40,Color.rgb(255, 220, 31));
                   Label l = new Label("M"+mesa.getNumero());
                   StackPane contenedor = new StackPane();
                   contenedor.setPrefHeight(100);
                   contenedor.setPrefWidth(100);
                   contenedor.getChildren().addAll(c,l);
                   contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                   contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                   paneMesas.getChildren().add(contenedor);
                   
                   contenedor.setOnMouseClicked((MouseEvent ev)->{
                       App.setRoot("vistaCuentaMesa");
                       
                       
                   });
                   
               }
               else if (mesa.getCapacidad()==6){
                   Circle c = new Circle(55,Color.rgb(255, 220, 31));
                   Label l = new Label("M"+mesa.getNumero());  
                   StackPane contenedor = new StackPane();
                   contenedor.setPrefHeight(140);
                   contenedor.setPrefWidth(140);
                   contenedor.getChildren().addAll(c,l);
                   contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                   contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                   paneMesas.getChildren().add(contenedor);
                   
               }
                else if (mesa.getCapacidad()==8){
                   Circle c = new Circle(75,Color.rgb(255, 220, 31));
                   Label l = new Label("M"+mesa.getNumero());
                   StackPane contenedor = new StackPane();
                   contenedor.setPrefHeight(180);
                   contenedor.setPrefWidth(180);
                   contenedor.getChildren().addAll(c,l);
                   contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                   contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                   paneMesas.getChildren().add(contenedor);
                   
               }
               else if (mesa.getCapacidad()==9){
                   Circle c = new Circle(85,Color.rgb(255, 220, 31));
                   Label l = new Label("M"+mesa.getNumero());
                   StackPane contenedor = new StackPane();
                   contenedor.setPrefHeight(200);
                   contenedor.setPrefWidth(200);
                   contenedor.getChildren().addAll(c,l);
                   contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                   contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                   paneMesas.getChildren().add(contenedor);
                   
               }
               else if (mesa.getCapacidad()==2){
                   Circle c = new Circle(30,Color.rgb(255, 220, 31));
                   Label l = new Label("M"+mesa.getNumero());
                   StackPane contenedor = new StackPane();
                   contenedor.setPrefHeight(85);
                   contenedor.setPrefWidth(85);
                   contenedor.getChildren().addAll(c,l);
                   contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                   contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                   paneMesas.getChildren().add(contenedor);
                   
               }
               
            }
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }  
        
    }    

    private void abrirCuenta(MouseEvent event) {
        App.setRoot("vistaCuentaMesa");
    }
    
}
