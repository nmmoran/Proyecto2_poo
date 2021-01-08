/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.modelo;

import com.pooespol.proyecto2_poo.data.UsuarioData;
import com.pooespol.proyecto2_poo.modelo.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class Restaurante {
    
    private List<Usuario> listUsuarios;
    
    public Restaurante() throws IOException{
        //cargar la informacion de generos
        //llamar a leerGeneros() de la clase GeneroData
        listUsuarios = UsuarioData.leerUsuarios();
       
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }
            
   
}
