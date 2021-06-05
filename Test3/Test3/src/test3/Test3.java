/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test3;

import controller.LoginController;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mdlaf.MaterialLookAndFeel;
import model.User;
import view.LoginView;

/**
 * 3.-Utilizando Programación Orientada a Objetos (POO), realizar un programa que en
 * principio tenga un menu con 2 opciones:
 *  • Login
 *  • Registro
 * Al seleccionar registrarse deberá solicitar un nombre de usuario y contraseña para
 * registrarlo en memoria.
 *  • Validar nombre de usuario único.
 * Al seleccionar login solicitar usuario y contraseña;
 *  • Si se encuentra registrado y es su primer login (nombre completo y edad no
 * registrado), solicitara ahora el nombre completo y edad del usuario para
 * guardarlos en el objeto;
 *  • Si ya tiene guardado su nombre completo y edad deberá imprimir “Bienvenido
 * [nombre completo]”
 */
/**
 *
 * @author Hugo Luna
 */
public class Test3 {

    public static ArrayList<User> listUsers;
    
    public Test3(){
        initMaterial();
        launchScreen();
        listUsers = new ArrayList<>();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new Test3();
    }
    
    
    public void initMaterial() {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
    
    public void launchScreen() {
        
     new LoginController(new LoginView());
      
    }


  
    
}
