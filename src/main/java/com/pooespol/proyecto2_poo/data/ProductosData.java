/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.data;

import com.pooespol.proyecto2_poo.App;
import com.pooespol.proyecto2_poo.modelo.Producto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
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
    public static ArrayList<Producto>leerProducto() throws IOException {
        ArrayList<Producto> products = new ArrayList<>();
        try{
            URL u = App.class.getResource(ruta);
            File file = new File(u.toURI());
            try(BufferedReader bf = new BufferedReader(new FileReader(file))){
                String linea;
                while((linea = bf.readLine())!=null){
                    String partes[] = linea.split(";");
                    if(partes.length == 4){
                        products.add(new Producto(partes[1],Double.parseDouble(partes[2]),partes[3],partes[0])); 
                    }
                    //String nombre, double precio, String imagen,String tipo
                    //tipo 0 ; nombre_producto1 , precio 2 ,imagen 3
                     
                    
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
        return products;
    } 
    
    public static ArrayList<Producto> parsearProductos(String tipo) {
        ArrayList<Producto> listaResultado = new ArrayList<>();
        try{ 
           for(Producto p :leerProducto()){
               if(p.getTipo()==tipo){
                   listaResultado.add(p);
               }
           } 
        }catch(IOException ex){
            System.out.println("Ocurrio un error al parsear los productos por tipo");
            ex.printStackTrace();
        }
        return listaResultado;
    }
    
    
      public static ArrayList<String> obtenerTipos() {
        ArrayList<String> listaResultado = new ArrayList<>();
        try{ 
           for(Producto p :leerProducto()){
               if(listaResultado.contains(p.getTipo())==false){
                   listaResultado.add(p.getTipo());
               }
           } 
        }catch(IOException ex){
            System.out.println("Ocurrio un error al parsear los tipos de producto");
            ex.printStackTrace();
        }
        return listaResultado;
    }
      public static void escribirProducto(Producto p) 
            throws IOException, URISyntaxException {
                 
         try(BufferedWriter outputStream =
                 new BufferedWriter(new FileWriter(ruta,true)))
        {
            Scanner keyboard = new Scanner(System.in);
            String linea;
            linea = p.getTipo()+";"+p.getNombre()+";"+p.getPrecio()+";"+p.getImagen();
            outputStream.write(linea);
            outputStream.newLine();
            outputStream.flush();
            outputStream.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file out.txt."+ e.getMessage());
        }
        catch(IOException e){
            System.out.println("IOException."+ e.getMessage());
        }catch(Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
    }
    }
        
        
      
}
