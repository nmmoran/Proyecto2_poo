/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.data;

import com.pooespol.proyecto2_poo.App;
import com.pooespol.proyecto2_poo.modelo.Producto;
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
 * @author nicol
 */
public class ProductosData {
    static String ruta = "productos.txt";
    
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
                    String[] partes = linea.split(";");
                    //String nombre, double precio, String imagen,String tipo
                    //tipo 0 ; nombre_producto1 , precio 2 ,imagen 3
                    products.add(new Producto(partes[1],Double.parseDouble(partes[2]),partes[3],partes[0]));        
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
    
    /**
     *
     * Metodo segun los parametros de la profesora
     * @param p
     * @return 
     * @throws java.io.IOException
     */
    
    public static ArrayList<Producto> leerProducto(Producto p) 
        throws IOException{
    ArrayList<Producto> productos = new ArrayList<>();
    //usamos BufferedReader para leer archivos
    try{
        //System.out.println("Primera partes");
        URL u = App.class.getResource(ruta);
        File file = new File(u.toURI());
        //System.out.println("Segunda partes");
        try(BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String linea;
            //leemos el archivo liena a linea con la funcion readline
            while((linea=bf.readLine())!=null){
                //llamamos a la funcion procesarRegistro para  crear una nueva
                //pelicula con la informacion de la linea
                Producto producto = procesarRegistro(p,linea);
                if(p!=null)
                    productos.add(p);

            }
        } 

        }catch(Exception ex){
            System.out.println(ex);
            }return productos;
    }
    
    public static Producto procesarRegistro(Producto producto, String linea) {
        //Formato de cada linea del archivo
        //softdrinks;Coca-cola;1.50;coca.jpeg
        //tipo; nombre_producto, precio,imagen
        try{
            //dividimos la linea en partes
            String partes[]=linea.split(";");
            if(partes[1].equals(producto.getNombre())){
                //String nombre, double precio, String imagen,String tipo
                //tipo 0 ; nombre_producto1 , precio 2 ,imagen 3
                Producto p = new Producto(partes[1],
                        Double.parseDouble(partes[2]),partes[3],partes[0]);
                
                return p;
            }else{
                return null;
            }
        }catch(Exception ex){
            //usamos contructor que recibe mensaje y la linea que produjo el error
            //throw new RegistroMalFormadaException("Error al parser la linea",linea);
            System.out.println("Error");
        }return null;
    }

    
    
}
