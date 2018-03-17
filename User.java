/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;

/**
 *
 * @author 729347
 */
public class User implements Serializable {

    private String username;
    private String password;
    private String email;
    private boolean active;
    private String firstname;
    private String lastname;
    private int role;
    private int company;

    public User() {

    }
    
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public User(int company, String arg){
        this.company = company;
    }

    public User(int role) {
        this.role = role;
    }
    
    public User(String password) {
        this.password = password;
    }

    public User(String username, String password, boolean active) {
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public User(String username, String password, String email, boolean active, String firstname, String lastname, int role, int company) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.active = active;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.company = company;
    }
    
    public User(String password, String email, boolean active, String firstname, String lastname, int role, int company) {
        this.password = password;
        this.email = email;
        this.active = active;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.company = company;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public boolean getActive() {
        return active;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getCompany() {
        return company;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }
}
