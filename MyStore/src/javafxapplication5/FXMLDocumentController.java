/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.EnumSet.range;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafxapplication5.custom.NumberTextField;

/**
 *
 * @author welli
 */
public class FXMLDocumentController implements Initializable {
    
       
    @FXML
    public TextField nomeProduto;
    public TextField dataEnt;
    public TextField fornecedor;
    public TextField codBar;
    @FXML
    public NumberTextField quantidade;
    public TextField dataFab;
    public TextField dataVal;
    public TextField valor;
    
    public ChoiceBox categoria;
    
    @FXML
    public TextArea desc;
    
    @FXML
    public Button btnAdicionar;
    public Button btnPesquisar;
    public Button btnLimpar;
    
    public String np, frn, cat, barcode;
    public int  qntd;
    public float preço;
    
   
        
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        
        
                
        /*   ConexaoMySql con = new ConexaoMySql();
        np = nomeProduto.getText();
        frn = fornecedor.getText();
        cat = "Lacticinios";
        barcode = codBar.getText();
        Statement st = con.conexao.createStatement();
        /* String sql = ("INSERT INTO usuarios (USUARIOS,NOME,SENHA) VALUES" +  "(" + "'" + var1 + "'," + "'" + var2 + "'," + "'" + var3 + "')");
        st.execute(sql);
        execTerminada(); */
        /**
         * I annotated your custom NumberTextField with @FXML
         * and also give it an id in the fxml file, which needs to
         * be the same "name" you have choosen as member name for this 
         * NumberTextField within your FX Controller.
         */
        // try to get the Text
        String text = quantidade.getText();
        // check if the input is not null or empty
        if(text != null && !text.trim().isEmpty()) {
            // try to get a Number
            try {
                int numberValue = Integer.parseInt(text);
                // here goes your logic
                System.out.println("You have entered following Number: " + numberValue);
            } catch (NumberFormatException ex) {
                System.err.println("Something went wrong. " + text + " could not be converted as a number.");
            }
        }
    /*   ConexaoMySql con = new ConexaoMySql();
        
       
        
        np = nomeProduto.getText();
        frn = fornecedor.getText();
        cat = "Lacticinios";
        
        barcode = codBar.getText();
        
        
        Statement st = con.conexao.createStatement();
       /* String sql = ("INSERT INTO usuarios (USUARIOS,NOME,SENHA) VALUES" +  "(" + "'" + var1 + "'," + "'" + var2 + "'," + "'" + var3 + "')");
        st.execute(sql);
        execTerminada(); */
                
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void execTerminada() {
       
           
          
    }
    
    private void tetse(ActionEvent event) {
    
       
    
    }
    
}
