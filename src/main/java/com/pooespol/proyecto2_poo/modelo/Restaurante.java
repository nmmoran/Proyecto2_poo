/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.modelo;

import com.pooespol.proyecto2_poo.data.ProductosData;
import com.pooespol.proyecto2_poo.data.UsuarioData;
import com.pooespol.proyecto2_poo.modelo.Producto;
import com.pooespol.proyecto2_poo.modelo.Usuario;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class Restaurante {
    
    private List<Usuario> listUsuarios;
    private ArrayList<Producto> listproductos;
    
    public Restaurante() throws IOException{
        //cargar la informacion de generos
        //llamar a leerGeneros() de la clase GeneroData
        
        listUsuarios = UsuarioData.leerUsuarios();
        listproductos= ProductosData.leerProducto();
       
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public ArrayList<Producto> getListproductos() {
        return listproductos;
    }
    
    
     public void registrarProducto(String nombre, double precio, String ruta ,String tipo) throws IOException, URISyntaxException {
        
        
            Producto pro = new Producto(nombre,precio,ruta,tipo);
            listproductos.add(pro);
            ProductosData.registrarProducto(pro);
       
        }
            
   
}
