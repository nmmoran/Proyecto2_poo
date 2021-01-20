/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.modelo;

import com.pooespol.proyecto2_poo.modelo.Mesero;
import com.pooespol.proyecto2_poo.modelo.Ubicacion;

/**
 *
 * @author nicol
 */
public class Mesa {
    private int numero;
    private int capacidad;
    private Mesero mesero;
    private Ubicacion ubicacion;
  

    public Mesa(int numero, int capacidad, Mesero mesero, Ubicacion ubicacion) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.mesero = mesero;
        this.ubicacion = ubicacion;
        
    }
       

    public Mesa(int numero) {
        this.numero = numero;
        
    }
    public Mesa(int numero, int capacidad,Ubicacion ubi){
        this.numero = numero;
        this.capacidad = capacidad;
        this.ubicacion= ubi;
        this.mesero=null;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

   

    @Override
    public String toString() {
        return "Mesa numero=" + numero + ", capacidad=" + capacidad + ", mesero=" + mesero + ", ubicacion=" + ubicacion ;
    }
}
