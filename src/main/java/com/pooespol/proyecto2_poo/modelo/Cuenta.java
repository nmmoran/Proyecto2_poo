/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.modelo;

import com.pooespol.proyecto2_poo.modelo.Mesa;

/**
 *
 * @author nicol
 */
public class Cuenta {
    private int numCuenta;
    private String cliente;
    private Mesa mesa;
    private String[] orden;

    public Cuenta(int numCuenta, String cliente, Mesa mesa, String[] orden) {
        this.numCuenta = numCuenta;
        this.cliente = cliente;
        this.mesa = mesa;
        this.orden = orden;
    }

    public Cuenta(Mesa mesa,String cliente,int numCuenta) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.numCuenta = numCuenta;
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

    public String[] getOrden() {
        return orden;
    }

    public void setOrden(String[] orden) {
        this.orden = orden;
    }
    
}
