/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assystem_app;

/**
 *
 * @author julie
 */
public class ConnectionResult {
    private String BDD;
    private String User;
    private String Password;

    public ConnectionResult(String BDD, String User, String Password) {
        this.BDD = BDD;
        this.User = User;
        this.Password = Password;
        
    }

    public String getBDD() {
        return BDD;
    }

    public String getUser() {
        return User;
    }
    
    public String getPassword() {
        return Password;
    }
}

