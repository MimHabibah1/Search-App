/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.website;
import java.sql.*;
import static java.time.Clock.system;
import java.util.Scanner;


/**
 *
 * @author Umme Habiba
 */
public class SearchWebsite {

    
    
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String CONN_STRING = "jdbc:mysql://localhost/phpmyadmin";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Connection conn = null;
        
        try{
        conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
        System.out.println("Connected");
        Statement stmt = (Statement) conn.createStatement();
                
                Scanner sc = new Scanner(System.in);
                String search, find;
                search = sc.next();
                
                if(search=="ruby"){
            find = "SELECT developers.email , programming_languages.name, languages.code"
                    + "FROM developers, programming_languages, languages" + "WHERE developers.developer_id=programming_languages.developer_id , developers.developer_id=languages.developer_id and programming_languages.name='ruby' ORDER BY developers.email";
            
        stmt.executeQuery(find);
        }
        
        else if(search=="japanese"|| search == "ruby"){
                find = "SELECT developers.email , programming_languages.name, languages.code"
                    + "FROM developers, programming_languages, languages" + "WHERE developers.developer_id=programming_languages.developer_id , developers.developer_id=languages.developer_id and programming_languages.name='ruby' and languages.code='ja' ORDER BY developers.email";
            
        stmt.executeQuery(find);
        
                }
    else
        {          find = "SELECT developers.email , programming_languages.name, languages.code"
                    + "FROM developers, programming_languages, languages" + "WHERE developers.developer_id=programming_languages.developer_id , developers.developer_id=languages.developer_id and programming_languages.name='ruby' programming_languages.name='javascript' and languages.code='ja' ORDER BY developers.email";
            
        stmt.executeQuery(find);
}}
        catch(SQLException e){
        System.err.println(e);
        }
        
        
    }
    
}
