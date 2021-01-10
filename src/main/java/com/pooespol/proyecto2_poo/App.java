package com.pooespol.proyecto2_poo;

import com.pooespol.proyecto2_poo.modelo.Producto;
import com.pooespol.proyecto2_poo.modelo.Restaurante;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
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
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
            //FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("vistaCuentaMesa.fxml"));
            Parent root = fxmlLoader.load();
            //cree el scene y fije como nodo raiz el objeto que cargo con el fxml
            scene = new Scene(root);
        } catch (IOException ex) {
            //si llegamos a este punto es porque no se pudo cargar del archivo
            //reporte.fxml el scenegraph
            //creamos con programacion un nuevo roort y lo fijamos a la scena
            VBox v = new VBox(new Label("No se cargo el archivo "));
            
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
        }
        
    }
    

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void inicializarProductos(FlowPane FPanel){
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
                FPanel.getChildren().add(vboxproducto);
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        launch();
    }

}
// aldo