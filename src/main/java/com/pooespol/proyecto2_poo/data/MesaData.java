/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.data;

import com.pooespol.proyecto2_poo.App;
import com.pooespol.proyecto2_poo.modelo.ArchivosExceptions;
import com.pooespol.proyecto2_poo.modelo.Mesa;
import com.pooespol.proyecto2_poo.modelo.Mesero;
import com.pooespol.proyecto2_poo.modelo.Restaurante;
import com.pooespol.proyecto2_poo.modelo.Ubicacion;
import com.pooespol.proyecto2_poo.modelo.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    
    /**
     * 
     * Metodo que permite la obtencion de un ArrayList 
     * de obtjetos de tipo mesas, apartir de la lectura 
     * de un archivo .txt que se encuentra en el paquete 
     * de recursos 
     * @return ArrayList<Mesa>
     * @throws IOException 
     */
    public static ArrayList<Mesa> leerMesas() throws IOException{
        ArrayList<Mesa> mesas = new ArrayList<>();
        try{
            URL u = App.class.getResource(ruta);
            File file = new File(u.toURI());
            try(BufferedReader bf = new BufferedReader(new FileReader(file))){
                String linea;
                while ((linea=bf.readLine())!=null){
                    String[] partes= linea.split(",");
                    if (partes.length == 4) {
                    Ubicacion ubi =new Ubicacion(Double.parseDouble(partes[2]),Double.parseDouble(partes[3]));
                    Mesa m = new Mesa(Integer.parseInt(partes[0]),Integer.parseInt(partes[1]),ubi);
                    mesas.add(m);
                }}
            }
        
        } catch (IOException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            
        }
        return mesas;
        
    }
    
    /**
     * Metodo que permite la escritura en un archivo .txt
     * de un objeto de tipo Mesa pasado como parametro 
     * 
     * @param m
     * @throws ArchivosExceptions 
     */
    public static void escribirMesa(Mesa m) 
            throws ArchivosExceptions{
        
        File file = new File(App.class.getResource(ruta).getFile());
        try(BufferedWriter bw = new BufferedWriter(
                                    new FileWriter(file,true))){
            bw.newLine();
            //1,4,29,30
            String linea = String.valueOf(m.getNumero())+","+String.valueOf(m.getCapacidad())+","
                    +String.valueOf(m.getUbicacion().getCoordenadaX())+","+String.valueOf(m.getUbicacion().getCoordenadaY());
            bw.write(linea);
            bw.close();
        }  catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw new ArchivosExceptions(ruta,ex.getMessage());
        }
        }
    /**
     * 
     * Metodo que permite la sobrescritura en un archivo .txt
     * de un objeto de tipo Mesa pasado como parametro 
     * @param mesas
     * @throws ArchivosExceptions 
     */
    public static void sobreescribirMesa(ArrayList<Mesa> mesas) 
            throws ArchivosExceptions{
        File file = new File(App.class.getResource(ruta).getFile());
        try(BufferedWriter bw = new BufferedWriter(
                                    new FileWriter(file))){ 
            for(Mesa mesa: mesas){
                String linea = String.valueOf(mesa.getNumero())+","+String.valueOf(mesa.getCapacidad())+","
                        +String.valueOf(mesa.getUbicacion().getCoordenadaX())+","+String.valueOf(mesa.getUbicacion().getCoordenadaY());
                bw.write(linea);
                bw.newLine();
            }
            
        }  catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw new ArchivosExceptions(ruta,ex.getMessage());
        }
        
        

}
    
}
