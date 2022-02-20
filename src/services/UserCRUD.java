/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyConnection;




/**
 *
 * @author klod
 */
public class UserCRUD {
    
    Connection cnx2;
    public UserCRUD(){
     cnx2 = MyConnection.getInstance().getcnx() ;
    }
    
    
    /*
    public void ajouterUser(){
        try {
            String requete = "INSERT INTO user(nom,prenom)" + " VALUES ('khaled' , 'majdoub')";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("utilisateur  ajoutee avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
}
   */
    
    // methode ajouter user dynamique
    
   public void ajouterUser2(User u){
        try {
            String requete2 = "INSERT INTO user (nom,prenom)" + "VALUES (?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.executeUpdate();
            System.out.println("  utilisateur est ajoutee avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
   }
   
   
   
   
   
    public void supprimerUser(User u){
        try {
            String requete4 = "DELETE FROM user  WHERE nom= 'mootez' ";
            PreparedStatement pst = cnx2.prepareStatement(requete4);
            pst.executeUpdate();
            System.out.println("  utilisateur est supprimee  avec succes ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
   }


   
   public  List<User> afficherUsers(){
       List<User> myList = new ArrayList<>();
        try {
            
            String requete3 = "SELECT * FROM user";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
            User u = new User();
            u.setId(rs.getInt(1));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            myList.add(u);
                    }
            
        } catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
        return myList;
   }
   
   
  
   
     public void modifierUser(User u){
        try {
            String requete2 = "UPDATE user SET nom = 'mootez', prenom= 'abbas' WHERE nom= 'majdoub';";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.executeUpdate();
            System.out.println(" utilisateur est modifiee avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
   }
}


