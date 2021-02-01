/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.modelo;

import com.pooespol.proyecto2_poo.data.MesaData;
import com.pooespol.proyecto2_poo.data.ProductosData;
import com.pooespol.proyecto2_poo.data.UsuarioData;
import com.pooespol.proyecto2_poo.data.VentasData;
import com.pooespol.proyecto2_poo.modelo.ArchivosExceptions;
import com.pooespol.proyecto2_poo.modelo.Mesa;
import com.pooespol.proyecto2_poo.modelo.Producto;
import com.pooespol.proyecto2_poo.modelo.Usuario;
import com.pooespol.proyecto2_poo.modelo.Venta;
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
    private ArrayList<Mesa> listMesas;
    private ArrayList<Venta> listVentas;
    
    /**
     * Inicializa las varaibles utilizando metodos de otras clases
     * cuyos metodos devuelven en cada variable un ArrayList<>
     * 
     * @throws IOException
     * @throws ArchivosExceptions 
     */
    public Restaurante() throws IOException, ArchivosExceptions{
        //cargar la informacion de generos
        //llamar a leerGeneros() de la clase GeneroData
        
        listUsuarios = UsuarioData.leerUsuarios();
        listproductos= ProductosData.leerProducto();
        listMesas= MesaData.leerMesas();
        listVentas=VentasData.leerVentas();
    }
   
    
    // Metodo que permite el registro de un nuevo producto a la lsit de productos
    public void registrarProducto(String nombre, double precio, String ruta ,String tipo) {

            Producto pro = new Producto(nombre,precio,ruta,tipo);
            listproductos.add(pro);
    }

    //Getters & Setters
    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public ArrayList<Producto> getListproductos() {
        return listproductos;
    }

    public ArrayList<Mesa> getListMesas() {
        return listMesas;
    }
    public void setListMesas(ArrayList<Mesa> listMesas) {
        this.listMesas = listMesas;
    }

    public ArrayList<Venta> getListVentas() {
        return listVentas;
    }

    public void setListVentas(ArrayList<Venta> listVentas) {
        this.listVentas = listVentas;
    }
    
    // Metodo que permite la eliminacion de un objeto tipo mesa
    // de la lista de mesas del restaurante
    public  void borrarMesa(Mesa m)  {
        try {
            
            listMesas.remove(m);
            System.out.println(m);
            System.out.println(listMesas);
            MesaData.sobreescribirMesa(listMesas);
            
            
            MesaData.sobreescribirMesa(listMesas);
        } catch (ArchivosExceptions ex) {
            ex.printStackTrace();
        }
               
           }
}
