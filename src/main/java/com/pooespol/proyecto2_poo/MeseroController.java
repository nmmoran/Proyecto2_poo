/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import com.pooespol.proyecto2_poo.data.MesaData;
import com.pooespol.proyecto2_poo.modelo.Cuenta;
import com.pooespol.proyecto2_poo.modelo.Mesa;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
        inicializarMesasMesero(paneMesas);
        
    }    

    private void abrirCuenta(MouseEvent event) {
        App.setRoot("vistaCuentaMesa");
    }
    
    private void inicializarMesasMesero(Pane pane){
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
                   pane.getChildren().add(contenedor);
                   contenedor.setOnMouseClicked(
                    (MouseEvent ev)->{
                            //para que no se propague
                            ev.consume();
                            cargarNuevaCuenta(mesa);
                            
                        }
                );
                   
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
                   contenedor.setOnMouseClicked(
                    (MouseEvent ev)->{
                            //para que no se propague
                            ev.consume();
                            cargarNuevaCuenta(mesa);
                            
                        }
                );
                   
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
                   contenedor.setOnMouseClicked(
                    (MouseEvent ev)->{
                            //para que no se propague
                            ev.consume();
                            cargarNuevaCuenta(mesa);
                        }
                );
                   
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
                   contenedor.setOnMouseClicked(
                    (MouseEvent ev)->{
                            //para que no se propague
                            ev.consume();
                            cargarNuevaCuenta(mesa);
                        }
                );
                   
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
                   contenedor.setOnMouseClicked(
                    (MouseEvent ev)->{
                            //para que no se propague
                            ev.consume();
                            cargarNuevaCuenta(mesa);
                        } 
                );
               }
               
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }  
        
    }
    
    public void cargarNuevaCuenta(Mesa m){
        try {
            //obtenemos el FXML de la NuevaCuentaVista:
            FXMLLoader ld = new FXMLLoader(getClass().getResource("nuevaCuentaVista.fxml"));
            Parent root = ld.load();
            // creamos un objeto de tipo controller pra asi obtener los atributos de la
            //ventana emergente
            NuevaCuentaVistaController nc = ld.getController();
            
            //Obtenemos los valores de Mesa para label y extraemos el nombre del TextField
            nc.getLblNroMesa().setText("Mesa nro: "+m.getNumero());
            String cname = nc.getTxtCliente().getText();
             
            //Seteamos el t}root a la escena y la escena al stage de la ventana emergente:
            Scene sc = new Scene(root);
            Stage st = new Stage();
            st.initModality(Modality.APPLICATION_MODAL);
            st.setScene(sc);
            st.show();
            
            //al boton cuando le damos, nos va a manadra a la ventana de Pedido:
            nc.getBtnCrearCuenta().setOnMouseClicked((MouseEvent ev)->{
                            //para que no se propague
                            st.close();
                            ev.consume();
                            App.setRoot("vistaCuentaMesa");
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("vistaCuentaMesa.fxml"));
                            VistaCuentaMesaController vcm = loader.getController();
                            System.out.println(vcm.getProductosCuenta());//lista de productos
                            vcm.getTotal();
                        });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 }
    
    
    

