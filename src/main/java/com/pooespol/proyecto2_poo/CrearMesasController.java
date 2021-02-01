/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import com.pooespol.proyecto2_poo.data.MesaData;
import com.pooespol.proyecto2_poo.modelo.ArchivosExceptions;
import com.pooespol.proyecto2_poo.modelo.Mesa;
import com.pooespol.proyecto2_poo.modelo.Ubicacion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class CrearMesasController implements Initializable {

    @FXML
    private Button btnCrear;
    @FXML
    private TextField txtnum;
    @FXML
    private TextField txtcapMesas;

    private Mesa mesa;
    private Pane pane;

    public void setMesaUbi(Ubicacion u) {
        this.mesa.setUbicacion(u);
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mesa = new Mesa(0, 0, new Ubicacion(0, 0));
        btnCrear.setOnMouseClicked((e) -> {
            try {
                agregarMesa();
                cerrarVentana(e);
            } catch (ArchivosExceptions ex) {
                ex.printStackTrace();
            }
        });
    }
    // getters & setters
    public Button getBtnCrear() {
        return btnCrear;
    }

    public void setBtnCrear(Button btnCrear) {
        this.btnCrear = btnCrear;
    }

    public TextField getTxtnum() {
        return txtnum;
    }

    public void setTxtnum(TextField txtnum) {
        this.txtnum = txtnum;
    }

    public TextField getTxtcapMesas() {
        return txtcapMesas;
    }

    public void setTxtcapMesas(TextField txtcapMesas) {
        this.txtcapMesas = txtcapMesas;
    }

    public void cerrarVentana(Event event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Metodo que permite agregar una mesa setando 
     * numero y capacidad de la mesa, agregando la nueva mesa
     * a la lista de mesas del restaurante 
     * 
     * @throws ArchivosExceptions 
     */
    public void agregarMesa() throws ArchivosExceptions {
        int numMesa = Integer.parseInt(getTxtnum().getText());
        int capacidad = Integer.parseInt(getTxtcapMesas().getText());
        Ubicacion u = mesa.getUbicacion();
        mesa = new Mesa(numMesa, capacidad, u);
        AdministradorController.r.getListMesas().add(mesa);
        MesaData.escribirMesa(mesa);
    }

}
