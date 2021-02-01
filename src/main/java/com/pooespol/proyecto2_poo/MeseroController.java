/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import com.pooespol.proyecto2_poo.data.MesaData;
import com.pooespol.proyecto2_poo.data.UsuarioData;
import com.pooespol.proyecto2_poo.modelo.ArchivosExceptions;
import com.pooespol.proyecto2_poo.modelo.Cuenta;
import com.pooespol.proyecto2_poo.modelo.Mesa;
import com.pooespol.proyecto2_poo.modelo.Mesero;
import com.pooespol.proyecto2_poo.modelo.Producto;
import com.pooespol.proyecto2_poo.modelo.Restaurante;
import com.pooespol.proyecto2_poo.modelo.Venta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
    static boolean finMesasM;
    private int tiempo2;
    /**
     * Initializes the controller class.
     * Cargando de manera visual las mesas 
     * para la pantalla del mesero.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarMesero(paneMesas, App.r.getListMesas());
        
    }
    public void inicializarMesero(Pane pane, ArrayList<Mesa> mesas){
        for (Mesa mesa : mesas) {
            //mesa.setCuenta(cu);
            if(mesa.getCuenta()!= null){
                if(mesa.getCuenta().getMesero().getNombre().equals(LoginController.mesero.getNombre())){
                    Circle c = new Circle(mesa.getCapacidad()*10, Color.GREEN);
                    Label l = new Label("M" + mesa.getNumero());
                    StackPane contenedor = new StackPane();
                    contenedor.setPrefHeight(100);
                    contenedor.setPrefWidth(100);
                    contenedor.getChildren().addAll(c, l);
                    contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                    contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                    paneMesas.getChildren().add(contenedor);
                    contenedor.setOnMouseClicked(
                            (MouseEvent ev) -> {
                                //para que no se propague
                                ev.consume();
                                App.setRoot("vistaCuentaMesa");
                                
                            }
                    );

                }else{
                    if((mesa.getCuenta().getMesero().getNombre().equals(LoginController.mesero.getNombre()))==false){
                        Circle c = new Circle(mesa.getCapacidad()*10, Color.RED);
                        Label l = new Label("M" + mesa.getNumero());
                        StackPane contenedor = new StackPane();
                        contenedor.setPrefHeight(100);
                        contenedor.setPrefWidth(100);
                        contenedor.getChildren().addAll(c, l);
                        contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                        contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                        paneMesas.getChildren().add(contenedor);
                    }
                    
                }        
                
            }else{
                Circle c = new Circle(mesa.getCapacidad()*10, Color.rgb(255, 220, 31));
                Label l = new Label("M" + mesa.getNumero());
                StackPane contenedor = new StackPane();
                contenedor.setPrefHeight(100);
                contenedor.setPrefWidth(100);
                contenedor.getChildren().addAll(c, l);
                contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                paneMesas.getChildren().add(contenedor);
                
                contenedor.setOnMouseClicked(
                        (MouseEvent ev) -> {
                            //para que no se propague
                            ev.consume();
                            cargarNuevaCuenta(mesa);
                            
                        }
                );
            }
            
        }

    }
    
    /**
     * Metodo que permite cargar una ventana enemrgente 
     * en la cual se establece el nombre del cliente,
     * esto permitira acceder a la ventan de pedidos de productos
     * 
     * @param m 
     */
    public void cargarNuevaCuenta(Mesa m) {
        try {
            finMesasM=false;
            tiempo2=2;
            //obtenemos el FXML de la NuevaCuentaVista:
            FXMLLoader ld = new FXMLLoader(getClass().getResource("nuevaCuentaVista.fxml"));
            Parent root = ld.load();
            // creamos un objeto de tipo controller pra asi obtener los atributos de la
            //ventana emergente
            NuevaCuentaVistaController nc = ld.getController();
            //obtenemos todos lo sdatoa para una cuenta String cliente, Mesa mesa, Mesero mesero, List<Producto> orden
            
            //Obtenemos los valores de Mesa para label y extraemos el nombre del TextField
            nc.getLblNroMesa().setText("Mesa nro: " + m.getNumero());
            //String cname = nc.getTxtCliente().getText();

            //Seteamos el root a la escena y la escena al stage de la ventana emergente:
            Scene sc = new Scene(root);
            Stage st = new Stage();
            st.initModality(Modality.APPLICATION_MODAL);
            st.setScene(sc);
            st.show();
            nc.getBtnCrearCuenta().setOnMouseClicked((MouseEvent ev) -> {
                ev.consume();
                Mesa mesa=m;
            Mesero mesero=LoginController.mesero;
            Cuenta c=new Cuenta(nc.getTxtCliente().getText(),m,mesero);
            
            for(Mesa me: App.r.getListMesas()){
                if(me.getNumero()==m.getNumero()){
                    me.setCuenta(c);
                    st.close();
                    
                }
                }
            finalizarOrden(nc.getTxtCliente().getText(), m);
              Thread t10= new Thread(new ActualizarMesaMesero());
                t10.start();   
              Thread t11= new Thread(new TiempoRunnable2());
                t11.start();   
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
     
    }

    /**
     * Metodo que permite cargar la ventana vistaCuentaMesa
     * donde se encuentran las opciones para realizar pedidos 
     * regresar a la ventan de mesas y finalizar el consumo
     * @param event 
     */
    private void abrirCuenta(MouseEvent event) {
        App.setRoot("vistaCuentaMesa");
    }

   

    /**
     * Metodo que permite concluir las operacionesde de la cuenta
     * de un cliente, obteniendo la suma total de lo consumido 
     * finalizando la generacion de un archivo .txt con la informacion
     * del orden
     * 
     * @param cliente
     * @param mesa 
     */
    public void finalizarOrden(String cliente, Mesa mesa) {

        Parent root1 = null;
        Parent root2 = null;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vistaCuentaMesa.fxml"));
            root1 = loader.load();
            VistaCuentaMesaController vcm = loader.getController();

            //Obtencion del mesero tanto para cuenta como para Venta:
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("login.fxml"));
            root2 = loader1.load();
            LoginController lc = loader1.getController();

            //Obtenemos los campos y por ultimo el mesero:
            Mesero mesero = lc.getMesero();
            vcm.getBtnFinalizarOrden().setOnAction((ActionEvent em) -> {

                //creamos la cuenta;
                Cuenta cuenta = new Cuenta(cliente, mesa, mesero, vcm.getProductosCuenta());
                mesa.setCuenta(cuenta);
                DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fecha = LocalDate.now();
                String fechaStr = fecha.format(form).replace("/", "-");
                //creamos la venta:
                Venta v = new Venta(fechaStr, cuenta, mesero, vcm.getTotal());
                System.out.println("Imprimiendo Venta");
                System.out.println(v);
                App.r.getListVentas().add(v);
                //hilo

                //limpiamos los contenedores de la cuenta anterior
                vcm.getFpProductos().getChildren().clear();
                vcm.getFpPrecios().getChildren().clear();
                vcm.getLblTotal().setText("Total: ");
                vcm.getLblIVA().setText("IVA: ");

                //sobreescribir en el txtVentas:
                File file = new File(App.class.getResource("reporteVentas.txt").getFile());
                try ( BufferedWriter bw = new BufferedWriter(
                        new FileWriter(file, true))) {
                    String linea = fechaStr + ";" + mesa.getNumero() + ";" + mesero.getNombre() + ";"
                            + String.valueOf(cuenta.getNumCuenta()) + ";" + cuenta.getCliente() + ";" + v.getTotal();
                    bw.write(linea);
                    bw.newLine();

                } catch (IOException ex) {
                    try {
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                        throw new ArchivosExceptions("reporteVentas.txt", ex.getMessage());
                    } catch (ArchivosExceptions ex1) {
                        ex1.printStackTrace();
                    }
                }
                App.setRoot("mesero");
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        App.setRoot(root1);
    }
    
   class ActualizarMesaMesero implements Runnable {
    
    public void run() {
        
        try {
             while(!finMesasM){
                 Platform.runLater(() -> {
                paneMesas.getChildren().clear();
                 });
                Platform.runLater(() -> {  
                inicializarMesero(paneMesas,App.r.getListMesas());
                 });
                 Thread.sleep(2000);
                 
                } 
                
               
         } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    
}
 }
    class TiempoRunnable2 implements Runnable{
        public void run(){
            try {
                while(tiempo2>0 && !finMesasM){
                    
                    Thread.sleep(2000);
                    tiempo2-=1;
                   
                }
                finMesasM= true;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
           } 
        }
}
