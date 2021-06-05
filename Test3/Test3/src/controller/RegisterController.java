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
public class RegisterController {
    
    private RegisterView registerView;
    private Toaster toaster;
    
    public RegisterController(RegisterView registerView){
        this.registerView = registerView;
        registerView.setVisible(true);
        toaster = new Toaster(registerView.mainContainer);
        events();
    }

    private void events() {
        registerView.btnRegister.addActionListener((ActionEvent ae) -> {
            
            String username = registerView.fieldName.getText().toString();
            String pass = registerView.passField.getText();
            
            
            if (!username.trim().isEmpty() && !pass.trim().isEmpty()) {
                if(checkUsername(username)){
                    toaster.success("¡Genial!", "Te has registrado correctamente");
                    Test3.listUsers.add(new User(username, pass));
                    registerView.setVisible(false);
                    goToHome(new User(username, pass));
                }else{
                    toaster.error("¡Ups ocurrio un error!", "El nombre de usuario ya se encuentra en uso");
                }
            }else{
                toaster.error("¡Ups ocurrio un error!", "Debes llenar todos los campos");
            }
            
           
            
            
            
        });
        
        registerView.actionLogin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                registerView.setVisible(false);
                new LoginController(new LoginView());
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        
    }
    
    
    
    private boolean checkUsername(String currentUsername){
        boolean status = true;
        ArrayList<User> list =  Test3.listUsers;
        
        for (int i = 0; i < list.size(); i++) {
            if (currentUsername.equalsIgnoreCase(list.get(i).getUsername())) {
                status = false;
            }
            
        }
        
        return status;
    }

  
    private void goToHome(User user) {
       new HomeController(new HomeView(), user);
    }
    
}
