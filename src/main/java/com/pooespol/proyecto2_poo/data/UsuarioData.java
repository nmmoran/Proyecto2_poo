/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo.data;

import com.pooespol.proyecto2_poo.App;
import com.pooespol.proyecto2_poo.modelo.Administrador;
import com.pooespol.proyecto2_poo.modelo.Administrador;
import com.pooespol.proyecto2_poo.modelo.Mesero;
import com.pooespol.proyecto2_poo.modelo.Mesero;
import com.pooespol.proyecto2_poo.modelo.Usuario;
import com.pooespol.proyecto2_poo.modelo.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class UsuarioData {

    static String ruta = "usuarios.txt";

    /**
     * 
     * Metodo que permite la obtencion de un ArrayList 
     * de obtjetos de tipo Usuario, apartir de la lectura 
     * de un archivo .txt que se encuentra en el paquete 
     * de recursos 
     *
     * @return ArrayList<Usuario>
     * @throws IOException 
     */
    public static ArrayList<Usuario> leerUsuarios() throws IOException {
        ArrayList<Usuario> usu = new ArrayList<>();
        //Usamos la clase BufferedReader para leer archivos de texto
        try {
            URL u = App.class.getResource(ruta);
            File file = new File(u.toURI());
            try ( BufferedReader bf = new BufferedReader(new FileReader(file))) {
                String linea;
                //leemos linea a linea hasta llegar la final del archivo
                while ((linea = bf.readLine()) != null) {
                    //System.out.println("tets");
                    //System.out.println(linea);
                    //dividir la en partes 
                    String[] partes = linea.split(";");
                    if (partes.length == 4) {
                        if (partes[2].equals("administrador")) {
                            usu.add(new Administrador(partes[0], partes[1]));
                        } else {
                            if (partes[2].equals("mesero")) {
                                usu.add(new Mesero(partes[0], partes[1], partes[3]));
                            }
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
                throw ex;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                throw ex;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return usu;
    }
    
    /**
     * Metodo que permite obtener un objeto de tipo mesero 
     * segun el usuario y la contraseña, datos enviados como parametros
     * los cuales se buscaran en la lisata de meseros del restuarante 
     * 
     * @param usuario
     * @param contraseña
     * @return Mesero
     */
    public static Mesero devolverEmpleado(String usuario, String contraseña){
        
        try {
            ArrayList<Usuario> l = leerUsuarios();
            for (Usuario u : l){
                if (u instanceof Mesero){
                    if((usuario.equals(u.getEmail())) && (contraseña.equals(u.getPassword()))){
                        Mesero mesero = (Mesero)u;
                        return mesero;
                    }
                }
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

}
