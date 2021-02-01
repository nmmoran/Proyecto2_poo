/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pooespol.proyecto2_poo;

import java.time.LocalDate;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * 
 * @author Aldo Mendoza
 *  
 */

public class ReporteVentasData {
    private String fecha;
    private int numeroMesa;
    private String mesero;
    private int numeroCuenta;
    private String cliente;
    private double total;
    
    
    /**
     * CONSTRUCTOR
     * @param fecha
     * @param numeroMesa
     * @param mesero
     * @param numeroCuenta
     * @param cliente
     * @param total 
     */
    public ReporteVentasData(String fecha, int numeroMesa, String mesero, int numeroCuenta, String cliente, double total) {
        this.fecha = fecha;
        this.numeroMesa = numeroMesa;
        this.mesero = mesero;
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.total = total;
}
    //Getters 
    
    public String getFecha() {
        return fecha;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public String getMesero() {
        return mesero;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }
    
    //Setters

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public void setMesero(String mesero) {
        this.mesero = mesero;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
