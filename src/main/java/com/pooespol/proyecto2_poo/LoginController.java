/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import com.pooespol.proyecto2_poo.modelo.Administrador;
import com.pooespol.proyecto2_poo.modelo.Mesero;
import com.pooespol.proyecto2_poo.modelo.Restaurante;
import com.pooespol.proyecto2_poo.modelo.Usuario;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtContra;
    @FXML
    private Button btLogin;
    Restaurante r;
    static Mesero mesero;
    

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(TextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public TextField getTxtContra() {
        return txtContra;
    }

    public void setTxtContra(TextField txtContra) {
        this.txtContra = txtContra;
    }

    public Button getBtLogin() {
        return btLogin;
    }

    public void setBtLogin(Button btLogin) {
        this.btLogin = btLogin;
    }

    public Restaurante getR() {
        return r;
    }

    public void setR(Restaurante r) {
        this.r = r;
    }
    private static Scene scene;
    @FXML
    private void mostrarLogin(MouseEvent event) throws IOException {
            String email = txtEmail.getText();
            String contraseña = txtContra.getText();
            email=email.replaceAll(" ", "");
            contraseña=contraseña.replaceAll(" ","");
        try{
            
            if ((contraseña.length()) == 0 &&(email.length() == 0)) {
                throw new NullPointerException("no puede dejar campos vacios");
                
            }else{
                if (contraseña.length() == 0) {
                    throw new NullPointerException("Contraseña no puede er vacio");
                }
                else{
                if (email.length() == 0) {
                    throw new NullPointerException("Email no puede er vacio");
                }
            }}}catch(NullPointerException e){
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
            
                Parent root = fxmlLoader.load();
            //cree el scene y fije como nodo raiz el objeto que cargo con el fxml
                scene = new Scene(root);
                VBox v = new VBox(new Label(e.getMessage()));
                e.getStackTrace();
                scene = new Scene(v);
                Stage stage = new Stage();
                stage.setScene(scene);

                 //muestre la aplicacion
                stage.show();
            }
            
            Usuario u = new Usuario(email, contraseña);
            Usuario c = u.usuarioExiste(u, App.r.getListUsuarios());
            Label lb = new Label();
            if (c == null) {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
            
                Parent root = fxmlLoader.load();
            //cree el scene y fije como nodo raiz el objeto que cargo con el fxml
                scene = new Scene(root);
                VBox v = new VBox(new Label("Credenciales incorrectas"));
                scene = new Scene(v);
                Stage stage = new Stage();
                stage.setScene(scene);

                 //muestre la aplicacion
                stage.show();
            } else {
                if (c instanceof Mesero) {
                    App.setRoot("mesero");
                    mesero=(Mesero)c;
                    System.out.println(mesero);        
                } else if (c instanceof Administrador) {
                    App.setRoot("administrador");
                }
            }

    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

}
