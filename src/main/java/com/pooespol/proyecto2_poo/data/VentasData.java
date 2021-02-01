/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.data;

import com.pooespol.proyecto2_poo.App;
import com.pooespol.proyecto2_poo.modelo.Cuenta;
import com.pooespol.proyecto2_poo.modelo.Mesa;
import com.pooespol.proyecto2_poo.modelo.Mesero;
import com.pooespol.proyecto2_poo.modelo.Venta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Aldo
 */
public class VentasData {
    
    static String ruta="reporteVentas.txt";
    
    /**
     * Metodo que permite la obtencion de un ArrayList 
     * de obtjetos de tipo Venta, apartir de la lectura 
     * de un archivo .txt que se encuentra en el paquete 
     * de recursos 
     * 
     * @return ArrayList<Venta>
     * @throws IOException 
     */
    public static ArrayList<Venta> leerVentas() throws IOException {
        ArrayList<Venta> ventas = new ArrayList<>();
        try{
            URL u = App.class.getResource(ruta);
            File file = new File(u.toURI());
            try(BufferedReader bf = new BufferedReader(new FileReader(file))){
                String linea;
                while((linea = bf.readLine())!=null){
                    String partes[] = linea.split(";");
                    if (partes.length == 6) {
                    //01-01-2021;1;dustin;1;Pamela;210.45
                    String  fecha = partes[0];
                    Mesa mesa = new Mesa(Integer.parseInt(partes[1]));
                    Mesero mesero = new Mesero(null,null,partes[2]);
                    double total = Double.parseDouble(partes[5]);
                    Cuenta datosCuenta = new Cuenta(Integer.parseInt(partes[3]),partes[4],mesa,mesero);
                    ventas.add(new Venta(fecha,datosCuenta,mesero,total));
                   }
                }
            }
        }
        
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
            throw ex;
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            throw ex;
        }
        return ventas;
    } 
}
