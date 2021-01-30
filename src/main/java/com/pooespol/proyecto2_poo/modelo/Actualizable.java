/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.modelo;

import com.pooespol.proyecto2_poo.AdministradorController;
import static com.pooespol.proyecto2_poo.data.VentasData.leerVentas;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author Dustin Pisco
 */
public class Actualizable implements Runnable {
    
    static double totalRestaurante;
    static int totalOcupantes;
    
    public Actualizable() {
    }
    
    public void run() {
        double t = 0;
        int c = 0;
        try {
            FXMLLoader ld = new FXMLLoader(getClass().getResource("administrador.fxml"));
            Parent root = ld.load();
            AdministradorController cont = ld.getController();
            for (Venta v : leerVentas()) {
                t += v.getTotal();
                c += v.getDatosCuenta().getMesa().getCapacidad();
            }
            totalRestaurante = t;
            totalOcupantes = c;
            cont.getLblTF().setText(String.valueOf(totalRestaurante));
            cont.getLblNC().setText(String.valueOf(totalOcupantes));
            System.out.println("Ultima actualizacion de facturado: " + totalRestaurante);
            System.out.println("Ultima actualizacion de comensales: " + totalOcupantes);
            Thread.sleep(15000);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
