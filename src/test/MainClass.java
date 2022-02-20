/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;



import entities.User;
import services.UserCRUD;
import util.MyConnection;



/**
 *
 * @author klod
 */
public class MainClass {
    public static void main(String[] args) {        
       
          MyConnection mc =  MyConnection.getInstance();
          //   MyConnection mc2 = MyConnection.getInstance();
          //  System.out.println(mc.hashCode()+ " - " + mc2.hashCode());
      
             UserCRUD ucd = new UserCRUD();
             User u2 = new User("Majdoub ", "khaled");
               //ucd.ajouterUser2(u2);
                //ucd.supprimerUser(u2); 
                //ucd.modifierUser(u2);
                   
                   
                     System.out.println(ucd.afficherUsers());
       
        }
       }


