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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static java.util.EnumSet.range;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
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
    public Label lblCurrentUser;
    public Label lblDate;
    @FXML
    ComboBox<String> categoria;
    public NumberTextField quantidade;
    public TextField dataFab;
    public TextField dataVal;
    public TextField valor;
    
    
    
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
        
        String sla = System.getProperty("user.name");
        String txtLabel = "Ola " + sla + ", seja bem-vindo!";
        lblCurrentUser.setText(txtLabel);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        lblDate.setText(dateFormat.format(date)); //2014/08/06 15:59:48
  
        System.out.println("Olá");
        try {
        buildData();
        } catch (SQLException e) {
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Um erro ocorreu");
            alert.setHeaderText("Não foi possivel conectar-se ao banco de dados");
            alert.setContentText(e.toString());
            alert.showAndWait();
            
        }
        
        /*    while (PoG = true) { 
        
      } */
    }    
    
    public void execTerminada() {
       
           
          
    }
    
    private void tetse(ActionEvent event) {
    
       
    
    }
    
    public void buildData() throws SQLException{        
    ObservableList<String>  data = FXCollections.observableArrayList(); //List of String

    ConexaoMySql con = new ConexaoMySql();
    try{      
        String SQL = "Select nome from usuarios";            
        ResultSet rs = con.conexao.createStatement().executeQuery(SQL);  
        while(rs.next()){
            data.add(rs.getString("nome")); //add the String to the list                                     
        }
        categoria.setItems(data); //Set the list of String as the data for your combo box
    }
    catch(Exception e){
          e.printStackTrace();
          System.out.println("Error on Building Data");            
    }
}
    
}