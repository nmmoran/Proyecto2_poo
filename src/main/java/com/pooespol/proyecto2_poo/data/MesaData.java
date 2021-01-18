/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.data;

import com.pooespol.proyecto2_poo.App;
import com.pooespol.proyecto2_poo.modelo.Mesa;
import com.pooespol.proyecto2_poo.modelo.Ubicacion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

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
                    
                    Ubicacion ubi =new Ubicacion(Double.parseDouble(partes[2]),Double.parseDouble(partes[3]));
                    Mesa m = new Mesa(  Integer.parseInt(partes[0]),Integer.parseInt(partes[1]),ubi);
                    mesas.add(m);
                }
            }
        } catch(FileNotFoundException fe){
            fe.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return mesas;
        
    }
}
