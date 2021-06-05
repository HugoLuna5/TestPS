/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.User;
import test3.Test3;
import utils.Toaster;
import view.HomeView;
import view.LoginView;
import view.RegisterView;

/**
 *
 * @author Hugo Luna
 */
public class LoginController {
    
    private LoginView loginView;
    private Toaster toaster;
    
    public LoginController(LoginView loginView){
        this.loginView = loginView;
        loginView.setVisible(true);
        toaster = new Toaster(loginView.mainContainer);
        events();
    }

    private void events() {
        loginView.actionRegister.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginView.setVisible(false);
                new RegisterController(new RegisterView());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        loginView.btnLogin.addActionListener((ActionEvent ae) -> {
            String username = loginView.fieldUsername.getText().toString();
            String pass = loginView.passField.getText();
            
            if (!username.trim().isEmpty() && !pass.trim().isEmpty()) {
               User currentUser = login(username, pass);
                if (currentUser != null) {
                    toaster.success("¡Genial!", "Has ingresado correctamente");
                    loginView.setVisible(false);
                    goToHome(currentUser);
                }else{
                    toaster.error("¡Ups ocurrio un error!", "Usuario o contraseña incorrectos");
                }
                
            }else{
                toaster.error("¡Ups ocurrio un error!", "Debes llenar todos los campos");
            }
            
            
        });
                
        
    }
    
    private void goToHome(User user) {
       new HomeController(new HomeView(), user);
    }
    private User login(String username, String pass) {
       
        User current = null;
        ArrayList<User> list =  Test3.listUsers;
        
          for (int i = 0; i < list.size(); i++) {
            if (username.equals(list.get(i).getUsername()) && pass.equals(list.get(i).getPassword()) ) {
                current = list.get(i);
               
            }
            
        }
        
        return current;
    }
    
}
