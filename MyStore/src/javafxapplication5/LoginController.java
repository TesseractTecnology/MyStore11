/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author welli
 */
public class LoginController implements Initializable {

    @FXML
    public TextField loginTxt;
    public TextField senhaTxt;
    public Label invalid_label;
    public Button btnLogin;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    public static String loginGlobal; 
    public static String senhaGlobal; 
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {
                
        loginGlobal = loginTxt.getText();
        senhaGlobal = senhaTxt.getText();
        
        System.out.println("DO IT");
        Parent home_page_parent1 =  FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        Scene home_page_scene1 = new Scene(home_page_parent1);
        Stage app_stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            
        if (isValidCredentials())
        {
            app_stage1.hide(); //optional
            app_stage1.setScene(home_page_scene1);
            app_stage1.show();  
        }
        else
        {
                
            loginTxt.clear();
            senhaTxt.clear();
            invalid_label.setText("Sorry, invalid credentials"); 
        }
    }    
    
       private boolean isValidCredentials() throws SQLException
    {
        boolean let_in = false;
        System.out.println( "SELECT * FROM Usuarios WHERE Usuarios= " + "'" + loginTxt.getText() + "'" 
            + " AND Senha= " + "'" + senhaTxt.getText() + "'" );
    
        ConexaoMySql con = new ConexaoMySql();
        Statement stmt = con.conexao.createStatement();
        try {
          
            
            System.out.println("Opened database successfully");
            
            
            ResultSet rs = stmt.executeQuery( "SELECT * FROM usuarios WHERE USUARIOS= " + "'" + loginTxt.getText() + "'"  + " AND SENHA= " + "'" + senhaTxt.getText() + "'");
            
            
            while ( rs.next() ) {
                 if (rs.getString("USUARIOS") != null && rs.getString("SENHA") != null) { 
                     String  username = rs.getString("USUARIOS");
                     System.out.println( "USUARIOS = " + username );
                     String password = rs.getString("SENHA");
                     System.out.println("SENHA = " + password);
                     let_in = true;
                 }  
            }
            rs.close();
            stmt.close();
            con.conexao.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Operation done successfully");
            return let_in;
        
    }

    
}
