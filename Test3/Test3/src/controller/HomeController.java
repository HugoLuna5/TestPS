/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.User;
import test3.Test3;
import utils.Toaster;
import view.HomeView;
import view.LoginView;

/**
 *
 * @author Hugo Luna
 */
public class HomeController {
    
    private HomeView homeView;
    private User user;
    private Toaster toaster;
    
    public HomeController(HomeView homeView, User user){
        this.homeView = homeView;
        this.user = user;
        homeView.setVisible(true);
        toaster = new Toaster(homeView.container);
        checkData();
        events();
    }
    
    private void checkData(){

        if (user.getFullname() != null && user.getAge() != 0) {
            homeView.fieldFullname.setVisible(false);
            homeView.fieldAge.setVisible(false);
            homeView.welcomeTxt.setText("Bienvenido "+user.getFullname());
            homeView.btnAction.setLabel("Cerrar sesion");
        }else{
            homeView.welcomeTxt.setText("Actualizar información");
            homeView.btnAction.setLabel("Guardar datos");
        }
    }
    
    private void events(){
        
        homeView.btnAction.addActionListener((ActionEvent ae) -> {
            
            if (user.getFullname() != null && user.getAge() != 0) {
               homeView.setVisible(false);
               goToLogin();
            }else{
                String fullname = homeView.fieldFullname.getText().toString();
                String age = homeView.fieldAge.getText().toString();
                
                if (!fullname.trim().isEmpty() && !age.trim().isEmpty()) {
                    
                    try{
                        ArrayList<User> list =  Test3.listUsers;
                        user.setFullname(fullname);
                        user.setAge(Integer.parseInt(age));

                        for (int i = 0; i < list.size(); i++) {
                            if (user.getUsername().equals(list.get(i).getUsername())) {
                                list.set(i, user);
                            }

                        }
                        toaster.success("¡Genial!", "Información actualizada correctamente");
                        checkData();
                    }catch(NumberFormatException nFE){
                        toaster.error("¡Ups ocurrio un error!", "Debes ingresar un valor valido");
                    }
                    
                    
                }else{
                    toaster.error("¡Ups ocurrio un error!", "Debes llenar todos los campos");
                }
                
                
                
            }
            
            
        });
        
    }
        
    private void goToLogin(){
        new LoginController(new LoginView());
    }
}
