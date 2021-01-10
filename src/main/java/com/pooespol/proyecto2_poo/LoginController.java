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
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
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
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void mostrarLogin(MouseEvent event) throws IOException {
        String email;
        String contraseña;
        try{
            
           
            email = txtEmail.getText();
            contraseña =txtContra.getText();
            if(email==null|| contraseña==null){
                throw new NullPointerException(" no puede ser vacio");
            }
            
            
            
            Restaurante r=new Restaurante();
            
            Usuario u = new Usuario(email,contraseña);
            Usuario c = u.usuarioExiste(u, r.getListUsuarios());
            
            
            if(c==null){
                
                
            } else{
                if(c instanceof Mesero){
                App.setRoot("mesero");
                
            }else if(c instanceof Administrador){
                App.setRoot("administrador");
            }        
            }
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Algo paso");
            System.out.println(ex);
        }catch(NullPointerException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex);
        }catch(Exception ex){
            ex.printStackTrace();
    }
}
}

    
