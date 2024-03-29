/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.modelo;

import com.pooespol.proyecto2_poo.modelo.Mesa;
import com.pooespol.proyecto2_poo.modelo.Mesero;
import java.util.List;

/**
 *
 * @author nicol
 */
public class Cuenta {

    private static int numCuenta;
    private String cliente;
    private Mesa mesa;
    private Mesero mesero;
    private List<Producto> orden;
    
    /**
     * CONSTRUCTOR 
     * @param cliente
     * @param mesa
     * @param mesero
     * @param orden 
     */
    public Cuenta(String cliente, Mesa mesa, Mesero mesero, List<Producto> orden) {
        this.numCuenta += 1;
        this.cliente = cliente;
        this.mesa = mesa;
        this.mesero = mesero;
        this.orden = orden;
    }
    public Cuenta(String cliente, Mesa mesa, Mesero mesero) {
        this.numCuenta += 1;
        this.cliente = cliente;
        this.mesa = mesa;
        this.mesero = mesero;
        
    }
    public Cuenta(int numCuenta, String cliente, Mesa mesa,Mesero mesero) {
        this.numCuenta = numCuenta;
        this.cliente = cliente;
        this.mesa = mesa;
        this.mesero= mesero;
        
    }
    
    //Getters & Setters
    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Producto> getOrden() {
        return orden;
    }

    public void setOrden(List<Producto> orden) {
        this.orden = orden;
    }

   

}
