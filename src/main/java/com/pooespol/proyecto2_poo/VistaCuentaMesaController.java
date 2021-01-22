 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import com.pooespol.proyecto2_poo.data.MesaData;
import com.pooespol.proyecto2_poo.data.ProductosData;
import com.pooespol.proyecto2_poo.modelo.Mesa;
import com.pooespol.proyecto2_poo.modelo.Producto;
import com.pooespol.proyecto2_poo.modelo.Restaurante;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
    @FXML
    private Button btnFinalizarOrden;
    @FXML
    private Button btnBack;
    @FXML
    private ScrollPane scPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             Restaurante r=new Restaurante();
            //obtengo la lista de productos d
            List<Producto> listp = r.getListproductos() ;
            for(Producto p: listp){
                VBox vboxproducto = new VBox();
                //crear la imagen
                try{
                    InputStream inputImg= App.class.getResource(p.getImagen()).openStream();
                    ImageView imgv = new ImageView(new Image(inputImg));
                    vboxproducto.getChildren().add(imgv);
                }catch (Exception ex){
                    
                    ex.printStackTrace();
                }
                
                //crea el label del nombre y lo agrego al VBox
                Label lnombre = new Label(p.getNombre());
                vboxproducto.getChildren().add(lnombre);
                //el anio de la pelicula
                Label lprecio = new Label(String.valueOf(p.getPrecio()));
                vboxproducto.getChildren().add(lprecio);
                
                vboxproducto.setPadding(new Insets(2,3,3,4));
                
                //agregamos el VBox al FlowPane
                FPproductos.getChildren().add(vboxproducto);
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
         
    }    

    @FXML
    private void finalizarOrden(MouseEvent event) {
    }

    @FXML
    private void mostrarRestaurante(MouseEvent event) {
        App.setRoot("mesero");
    }

    @FXML
    private void mostrarBebidasSuaves(MouseEvent event) throws IOException {
        FPproductos.getChildren().clear();
        try {
            //obtengo la lista de productos d
            List<Producto> lpt = ProductosData.parsearProductos("softdrinks");
            for(Producto p: lpt){
                VBox vboxproducto = new VBox();
                //crear la imagen
                try{
                    InputStream inputImg= App.class.getResource(p.getImagen()).openStream();
                    ImageView imgv = new ImageView(new Image(inputImg));
                    vboxproducto.getChildren().add(imgv);
                }catch (Exception ex){
                    
                    ex.printStackTrace();
                }
                
                //crea el label del nombre y lo agrego al VBox
                Label lnombre = new Label(p.getNombre());
                vboxproducto.getChildren().add(lnombre);
                // precio 
                Label lprecio = new Label(String.valueOf(p.getPrecio()));
                vboxproducto.getChildren().add(lprecio);
                
                vboxproducto.setPadding(new Insets(2,3,3,4));
                
                //agregamos el VBox al FlowPane
                FPproductos.getChildren().add(vboxproducto);
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
       
    }

    @FXML
    private void mostrarBebidasCalientes(MouseEvent event) {
       FPproductos.getChildren().clear();
        try {
            //obtengo la lista de productos d
            List<Producto> lpt = ProductosData.parsearProductos("hotdrinks");
            for(Producto p: lpt){
                VBox vboxproducto = new VBox();
                //crear la imagen
                try{
                    InputStream inputImg= App.class.getResource(p.getImagen()).openStream();
                    ImageView imgv = new ImageView(new Image(inputImg));
                    vboxproducto.getChildren().add(imgv);
                }catch (Exception ex){
                    
                    ex.printStackTrace();
                }
                
                //crea el label del nombre y lo agrego al VBox
                Label lnombre = new Label(p.getNombre());
                vboxproducto.getChildren().add(lnombre);
                // precio 
                Label lprecio = new Label(String.valueOf(p.getPrecio()));
                vboxproducto.getChildren().add(lprecio);
                
                vboxproducto.setPadding(new Insets(2,3,3,4));
                
                //agregamos el VBox al FlowPane
                FPproductos.getChildren().add(vboxproducto);
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void mosrtarMilkshakes(MouseEvent event) {
        FPproductos.getChildren().clear();
        try {
            //obtengo la lista de productos d
            List<Producto> lpt = ProductosData.parsearProductos("milkshakes");
            for(Producto p: lpt){
                VBox vboxproducto = new VBox();
                //crear la imagen
                try{
                    InputStream inputImg= App.class.getResource(p.getImagen()).openStream();
                    ImageView imgv = new ImageView(new Image(inputImg));
                    vboxproducto.getChildren().add(imgv);
                }catch (Exception ex){
                    
                    ex.printStackTrace();
                }
                
                //crea el label del nombre y lo agrego al VBox
                Label lnombre = new Label(p.getNombre());
                vboxproducto.getChildren().add(lnombre);
                // precio 
                Label lprecio = new Label(String.valueOf(p.getPrecio()));
                vboxproducto.getChildren().add(lprecio);
                
                vboxproducto.setPadding(new Insets(2,3,3,4));
                
                //agregamos el VBox al FlowPane
                FPproductos.getChildren().add(vboxproducto);
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void mostrarCervezas(MouseEvent event) {
        FPproductos.getChildren().clear();
        try {
            //obtengo la lista de productos d
            List<Producto> lpt = ProductosData.parsearProductos("beers");
            for(Producto p: lpt){
                VBox vboxproducto = new VBox();
                //crear la imagen
                try{
                    InputStream inputImg= App.class.getResource(p.getImagen()).openStream();
                    ImageView imgv = new ImageView(new Image(inputImg));
                    vboxproducto.getChildren().add(imgv);
                }catch (Exception ex){
                    
                    ex.printStackTrace();
                }
                
                //crea el label del nombre y lo agrego al VBox
                Label lnombre = new Label(p.getNombre());
                vboxproducto.getChildren().add(lnombre);
                // precio 
                Label lprecio = new Label(String.valueOf(p.getPrecio()));
                vboxproducto.getChildren().add(lprecio);
                
                vboxproducto.setPadding(new Insets(2,3,3,4));
                
                //agregamos el VBox al FlowPane
                FPproductos.getChildren().add(vboxproducto);
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void mostrarVinos(MouseEvent event) {
        FPproductos.getChildren().clear();
        try {
            //obtengo la lista de productos d
            List<Producto> lpt = ProductosData.parsearProductos("wine");
            for(Producto p: lpt){
                VBox vboxproducto = new VBox();
                //crear la imagen
                try{
                    InputStream inputImg= App.class.getResource(p.getImagen()).openStream();
                    ImageView imgv = new ImageView(new Image(inputImg));
                    vboxproducto.getChildren().add(imgv);
                }catch (Exception ex){
                    
                    ex.printStackTrace();
                }
                
                //crea el label del nombre y lo agrego al VBox
                Label lnombre = new Label(p.getNombre());
                vboxproducto.getChildren().add(lnombre);
                // precio 
                Label lprecio = new Label(String.valueOf(p.getPrecio()));
                vboxproducto.getChildren().add(lprecio);
                
                vboxproducto.setPadding(new Insets(2,3,3,4));
                
                //agregamos el VBox al FlowPane
                FPproductos.getChildren().add(vboxproducto);
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void mostrarBebidasImportadas(MouseEvent event) {
        FPproductos.getChildren().clear();
        try {
            //obtengo la lista de productos d
            List<Producto> lpt = ProductosData.parsearProductos("importedDrinks");
            for(Producto p: lpt){
                VBox vboxproducto = new VBox();
                //crear la imagen
                try{
                    InputStream inputImg= App.class.getResource(p.getImagen()).openStream();
                    ImageView imgv = new ImageView(new Image(inputImg));
                    vboxproducto.getChildren().add(imgv);
                }catch (Exception ex){
                    
                    ex.printStackTrace();
                }
                
                //crea el label del nombre y lo agrego al VBox
                Label lnombre = new Label(p.getNombre());
                vboxproducto.getChildren().add(lnombre);
                // precio 
                Label lprecio = new Label(String.valueOf(p.getPrecio()));
                vboxproducto.getChildren().add(lprecio);
                
                vboxproducto.setPadding(new Insets(2,3,3,4));
                
                //agregamos el VBox al FlowPane
                FPproductos.getChildren().add(vboxproducto);
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void mostrarCocteles(MouseEvent event) {
        FPproductos.getChildren().clear();
        try {
            //obtengo la lista de productos d
            List<Producto> lpt = ProductosData.parsearProductos("Cocktails");
            for(Producto p: lpt){
                VBox vboxproducto = new VBox();
                //crear la imagen
                try{
                    InputStream inputImg= App.class.getResource(p.getImagen()).openStream();
                    ImageView imgv = new ImageView(new Image(inputImg));
                    vboxproducto.getChildren().add(imgv);
                }catch (Exception ex){
                    
                    ex.printStackTrace();
                }
                
                //crea el label del nombre y lo agrego al VBox
                Label lnombre = new Label(p.getNombre());
                vboxproducto.getChildren().add(lnombre);
                // precio 
                Label lprecio = new Label(String.valueOf(p.getPrecio()));
                vboxproducto.getChildren().add(lprecio);
                
                vboxproducto.setPadding(new Insets(2,3,3,4));
                
                //agregamos el VBox al FlowPane
                FPproductos.getChildren().add(vboxproducto);
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void añadirProducto(Producto p){
        
    }
}
