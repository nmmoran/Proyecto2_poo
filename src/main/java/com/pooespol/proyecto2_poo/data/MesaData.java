/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.data;

import com.pooespol.proyecto2_poo.App;
import com.pooespol.proyecto2_poo.modelo.Mesa;
import com.pooespol.proyecto2_poo.modelo.Mesero;
import com.pooespol.proyecto2_poo.modelo.Restaurante;
import com.pooespol.proyecto2_poo.modelo.Ubicacion;
import com.pooespol.proyecto2_poo.modelo.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Dustin Pisco
 */
public class MesaData {
    static String ruta = "mesas.txt";
    
    public static ArrayList<Mesa> leerMesas() throws URISyntaxException, FileNotFoundException, IOException{
        ArrayList<Mesa> mesas = new ArrayList<>();
        try{
            URL u = App.class.getResource(ruta);
            File file = new File(u.toURI());
            try(BufferedReader bf = new BufferedReader(new FileReader(file))){
                String linea;
                while ((linea=bf.readLine())!=null){
                    String[] partes= linea.split(",");
                    
                    
                    Restaurante r=new Restaurante();
                    for (Usuario usu: r.getListUsuarios()){
                        if (usu instanceof Mesero){
                            Mesero me=(Mesero)usu;
                            if (partes[4].equals(me.getNombre())){
                                Ubicacion ubi =new Ubicacion(Double.parseDouble(partes[2]),Double.parseDouble(partes[3]));
                                Mesa m = new Mesa(Integer.parseInt(partes[0]),Integer.parseInt(partes[1]),me,ubi);
                                mesas.add(m);
            
                            }else{
                                Ubicacion ubi =new Ubicacion(Double.parseDouble(partes[2]),Double.parseDouble(partes[3]));
                                Mesa m = new Mesa(Integer.parseInt(partes[0]),Integer.parseInt(partes[1]),ubi);
                                mesas.add(m);
                            }
                        }
                    }
                }
            }
        } catch(FileNotFoundException fe){
            fe.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return mesas;
        
    }

    public static void cargarDatosMesas(Mesa mesa , Pane pane){
        //limpiamos el contenido anterior
        pane.getChildren().clear();
        
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
