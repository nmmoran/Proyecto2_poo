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
        ArrayList<Producto> usu = new ArrayList<>();
     }   
}
