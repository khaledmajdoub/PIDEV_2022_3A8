/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author klod
 */
public class MyConnection {
    private final String url ="jdbc:mysql://localhost:3306/3a8" ;
    private final String user = "root" ;
    private final String password = "" ;
    Connection cnx ;
    public static MyConnection instance ;

    
    private  MyConnection(){
       
        try {
          cnx =  DriverManager.getConnection(url, user, password);
          System.out.println("connexion etablie");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
            
        
    }
    
    public Connection getcnx(){
    return cnx;
    }
    
    public static MyConnection getInstance() {
    
    if ( instance == null) {
        instance = new MyConnection();
        
    }
    return instance;
    
    
    }
    
    }

