/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.data;

import com.pooespol.proyecto2_poo.App;
import com.pooespol.proyecto2_poo.modelo.ArchivosExceptions;
import com.pooespol.proyecto2_poo.modelo.Producto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nicol
 */
public class ProductosData {
    static String ruta = "Productos.txt";
    
    
    /**
     * Esta funcion lee el archivo productos.txt que se encuentra en 
     * el paquete recursos y retorna un ArrayList con los generos descritos 
     * en el archivo
     * FORMATO ARCHIVO
     *  tipo;producto;precio;imagen
     * @return ArrayList<Producto>
     */
    public static  ArrayList<Producto>leerProducto() 
            throws ArchivosExceptions{
        ArrayList<Producto> products = new ArrayList<>();
        
        try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            String linea;
             while((linea = bf.readLine())!=null){
                    String partes[] = linea.split(";");
                    if(partes.length == 4){
                        products.add(new Producto(partes[1],Double.parseDouble(partes[2]),partes[3],partes[0])); 
                    }
                    //String nombre, double precio, String imagen,String tipo
                    //tipo 0 ; nombre_producto1 , precio 2 ,imagen 3
                     
                    
                }         
        }  catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw new ArchivosExceptions(ruta,ex.getMessage());
        }
        return products;
    }
    
    public static ArrayList<Producto> parsearProductos(String tipo) {
        ArrayList<Producto> listaResultado = new ArrayList<>();
        ArrayList<Producto> x = App.r.getListproductos();
        for(Producto p : x){
            if(p.getTipo().equals(tipo)){
                listaResultado.add(p);
            }
        }
        return listaResultado;
    }
    
    public static ArrayList<Producto> parsearProductosNombre(String nombre) {
        ArrayList<Producto> listaResultado = new ArrayList<>();
        ArrayList<Producto> x = App.r.getListproductos();
        for(Producto p : x){
            if(p.getNombre().equals(nombre)){
                listaResultado.add(p);
            }
        }
        return listaResultado;
        
    }
    
      public static ArrayList<String> obtenerTipos() {
        ArrayList<String> listaResultado = new ArrayList<>();
        
        ArrayList<Producto> x = App.r.getListproductos();
        try{ 
           for(Producto p :x){
               if(listaResultado.contains(p.getTipo())==false){
                   listaResultado.add(p.getTipo());
               }
           } 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaResultado;
    }
      
      
      
     public static ArrayList<Producto> escribirProducto(Producto producto) 
            throws ArchivosExceptions{
        //softdrinks;Coca-cola;1.50;coca.jpeg
       
        ArrayList<Producto> productos = new ArrayList<>();
        File file = new File(App.class.getResource(ruta).getFile());
        try(BufferedWriter bw = new BufferedWriter(
                                    new FileWriter(file,true))){
            bw.newLine();
            String linea = producto.getTipo()+","+producto.getNombre()+","+String.valueOf(producto.getPrecio())+","+
                    producto.getImagen()
                    ;
            bw.write(linea);
            bw.close();
        }  catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw new ArchivosExceptions(ruta,ex.getMessage());
        }
        return productos;
        
}
     public static void sobreescribirProducto(ArrayList<Producto> productos) 
            throws ArchivosExceptions{
        File file = new File(App.class.getResource(ruta).getFile());
        try(BufferedWriter bw = new BufferedWriter(
                                    new FileWriter(file))){ 
            for(Producto p: productos){
                String linea = p.getTipo()+","+p.getNombre()+","+String.valueOf(p.getPrecio())+","+
                    p.getImagen()
                    ;
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
