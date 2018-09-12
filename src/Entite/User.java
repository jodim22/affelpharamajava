/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.awt.Image;
import java.sql.Blob;

/**
 *
 * @author Josué Dik
 */
public class User {
    int IdUser;
    String NomUser;
    String PostnomUser;
    String TypeUser;
    String Emailuser;
    String LoginUser;
    String PassUser;

    public User() {
    }

    public User(String NomUser, String PostnomUser,String TypeUser, String Emailuser, String LoginUser, String PassUser) {
        this.NomUser = NomUser;
        this.PostnomUser = PostnomUser;
        this.TypeUser= TypeUser;
        this.Emailuser = Emailuser;
        this.LoginUser = LoginUser;
        this.PassUser = PassUser;
    }

    public User(int IdUser, String NomUser, String PostnomUser, String TypeUser, String Emailuser, String LoginUser, String PassUser) {
        this.IdUser = IdUser;
        this.NomUser = NomUser;
        this.PostnomUser = PostnomUser;
        this.TypeUser= TypeUser;
        this.Emailuser = Emailuser;
        this.LoginUser = LoginUser;
        this.PassUser = PassUser;
    }

    public String getTypeUser() {
        return TypeUser;
    }

    public void setTypeUser(String TypeUser) {
        this.TypeUser = TypeUser;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public String getNomUser() {
        return NomUser;
    }

    public void setNomUser(String NomUser) {
        this.NomUser = NomUser;
    }

    public String getPostnomUser() {
        return PostnomUser;
    }

    public void setPostnomUser(String PostnomUser) {
        this.PostnomUser = PostnomUser;
    }

    public String getEmailuser() {
        return Emailuser;
    }

    public void setEmailuser(String Emailuser) {
        this.Emailuser = Emailuser;
    }

    public String getLoginUser() {
        return LoginUser;
    }

    public void setLoginUser(String LoginUser) {
        this.LoginUser = LoginUser;
    }

    public String getPassUser() {
        return PassUser;
    }

    public void setPassUser(String PassUser) {
        this.PassUser = PassUser;
    }
    
}
