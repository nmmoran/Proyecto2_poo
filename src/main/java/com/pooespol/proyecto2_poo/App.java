package com.pooespol.proyecto2_poo;

import com.pooespol.proyecto2_poo.data.MesaData;
import com.pooespol.proyecto2_poo.modelo.Mesa;
import com.pooespol.proyecto2_poo.modelo.Mesero;
import com.pooespol.proyecto2_poo.modelo.Producto;
import com.pooespol.proyecto2_poo.modelo.Restaurante;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
//Ya pude conectarme amigues att 2tin//
//actualizacion//
//Ya se soluciono amigues//
/***
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("administrador.fxml"));
            ;
            Parent root = fxmlLoader.load();
            //cree el scene y fije como nodo raiz el objeto que cargo con el fxml
            scene = new Scene(root);
        } catch (IOException ex) {
            //si llegamos a este punto es porque no se pudo cargar del archivo
            //reporte.fxml el scenegraph
            //creamos con programacion un nuevo roort y lo fijamos a la scena
            VBox v = new VBox(new Label("No se cargo el archivo "));
            ex.getStackTrace();
            scene = new Scene(v);
            System.out.println(ex);
            
        }
        
        //fije la scena al primary stage
        stage.setScene(scene);
        
        //muestre la aplicacion
        stage.show();
    }
       

        static void setRoot(String fxml)  {
        try{
            scene.setRoot(loadFXML(fxml));
        }catch(IOException ex){
            System.out.println("Algo sucedio");
            System.out.println(ex);
            ex.getStackTrace();
        }
        
    }
    

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
   
    public static void main(String[] args) throws IOException {
        Restaurante r=new Restaurante();
        launch();
    }

    static void  inicializarMesas(Pane pane){
    
            
      try {
            ArrayList<Mesa> mesas = MesaData.leerMesas();
            for(Mesa mesa: mesas){
                System.out.println(mesa);
               if (mesa.getCapacidad()==4){
                   
                   Circle c = new Circle(40,Color.rgb(255, 220, 31));
                   Label l = new Label("M"+String.valueOf(mesa.getNumero()));
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
                            
                            cargarDatosMesas(mesa,pane);
                        }
                );
                   
               }
               else if (mesa.getCapacidad()==6){
                   Circle c = new Circle(55,Color.rgb(255, 220, 31));
                   Label l = new Label("M"+String.valueOf(mesa.getNumero()));
                   StackPane contenedor = new StackPane();
                   contenedor.setPrefHeight(140);
                   contenedor.setPrefWidth(140);
                   contenedor.getChildren().addAll(c,l);
                   contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                   contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                   pane.getChildren().add(contenedor);
                   contenedor.setOnMouseClicked(
                    (MouseEvent ev)->{
                            //para que no se propague
                            ev.consume();
                            
                            cargarDatosMesas(mesa,pane);
                        }
                );
                   
               }
                else if (mesa.getCapacidad()==8){
                   Circle c = new Circle(75,Color.rgb(255, 220, 31));
                   Label l = new Label("M"+String.valueOf(mesa.getNumero()));
                   StackPane contenedor = new StackPane();
                   contenedor.setPrefHeight(180);
                   contenedor.setPrefWidth(180);
                   contenedor.getChildren().addAll(c,l);
                   contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                   contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                   pane.getChildren().add(contenedor);
                   contenedor.setOnMouseClicked(
                    (MouseEvent ev)->{
                            //para que no se propague
                            ev.consume();
                            
                            cargarDatosMesas(mesa,pane);
                        }
                );
               }
               else if (mesa.getCapacidad()==9){
                   Circle c = new Circle(85,Color.rgb(255, 220, 31));
                   Label l = new Label("M"+String.valueOf(mesa.getNumero()));
                   StackPane contenedor = new StackPane();
                   contenedor.setPrefHeight(200);
                   contenedor.setPrefWidth(200);
                   contenedor.getChildren().addAll(c,l);
                   contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                   contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                   pane.getChildren().add(contenedor);
                   contenedor.setOnMouseClicked(
                    (MouseEvent ev)->{
                            //para que no se propague
                            ev.consume();
                            
                            cargarDatosMesas(mesa,pane);
                        }
                );
               }
               else if (mesa.getCapacidad()==2){
                   Circle c = new Circle(30,Color.rgb(255, 220, 31));
                  Label l = new Label("M"+String.valueOf(mesa.getNumero()));
                   StackPane contenedor = new StackPane();
                   contenedor.setPrefHeight(85);
                   contenedor.setPrefWidth(85);
                   contenedor.getChildren().addAll(c,l);
                   contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                   contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                   pane.getChildren().add(contenedor);
                   contenedor.setOnMouseClicked(
                    (MouseEvent ev)->{
                            //para que no se propague
                            ev.consume();
                            
                            cargarDatosMesas(mesa,pane);
                        }
                );
               }
               
            }
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }}
    
    public static void cargarDatosMesas(Mesa mesa , Pane pane){
        //limpiamos el contenido anterior
        
        
        Mesero mesero = mesa.getMesero();
        HBox contenedorMesa = new HBox();
        
        if((mesero.getNombre()!="na")==true){
           Label l1 = new Label(mesero.getNombre()); 
           Label l2 = new Label(String.valueOf(mesa.getNumero()));
        Label l3 = new Label(String.valueOf(mesa.getCapacidad()));
        VBox v = new VBox(l1,l2,l3);
        }else{
        
        Label l2 = new Label(String.valueOf(mesa.getNumero()));
        Label l3 = new Label(String.valueOf(mesa.getCapacidad()));
        VBox v = new VBox(l2,l3);
        contenedorMesa.getChildren().add(v);
        pane.getChildren().add(contenedorMesa);
        }
    }
}