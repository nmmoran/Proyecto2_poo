/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.modelo;

import com.pooespol.proyecto2_poo.AdministradorController;
import static com.pooespol.proyecto2_poo.data.VentasData.leerVentas;
import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 *
 * @author Dustin Pisco
 */
public class Actualizable implements Runnable {

    private Label l1;
    private Label l2;
    static double totalRestaurante;
    static int totalOcupantes;

    public Actualizable(Label l1,Label l2) {
        this.l1=l1;
        this.l2=l2;
    }

    public void run() {

        try {
            FXMLLoader ld = new FXMLLoader(getClass().getResource("administrador.fxml"));
            Parent root = ld.load();
            AdministradorController cont = ld.getController();
            for (Venta v : leerVentas()) {
                 totalRestaurante+= v.getTotal();
                totalOcupantes+= v.getDatosCuenta().getMesa().getCapacidad();
            }

            Platform.runLater(() -> {
                l1.setText(String.valueOf(totalRestaurante));
                l2.setText(String.valueOf(totalOcupantes));
                System.out.println("Ultima actualizacion de facturado: " + totalRestaurante);
                System.out.println("Ultima actualizacion de comensales: " + totalOcupantes);
            });

            Thread.sleep(15000);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
