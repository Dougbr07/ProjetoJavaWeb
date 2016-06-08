/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Douglas
 */
public class MySingleton {

    private static Connection connection = null;
    private MySingleton(){}
    
    public static Connection getConnection(){
        if(!(connection instanceof Connection)){
            try{
            
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
                
            
            }catch(SQLException | ClassNotFoundException e){
                e.printStackTrace();
                 System.out.println("Oops! Ocorreu um erro inesperado!");
            }
          
        }
    return connection;
    }
    
    public static void closeConnection() throws SQLException{
        if(connection instanceof Connection){
            
                connection.close();
                
        }
    
    
    }
    
}
