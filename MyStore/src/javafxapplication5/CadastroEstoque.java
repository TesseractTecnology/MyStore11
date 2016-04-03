/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafxapplication5.custom.NumberTextField;

/**
 *
 * @author welli
 */
public class CadastroEstoque implements Initializable {
    
       
    @FXML
    public TextField nomeProduto;
    public DatePicker dataEnt;
    public TextField fornecedor;
    public TextField codBar;
    public Label lblCurrentUser;
    public Label lblDate;
    @FXML
    ComboBox<String> categoria;
    public NumberTextField quantidade;
    public DatePicker dataFab;
    public DatePicker dataVal;
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
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException {
        
        //Teste 
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println(LoginController.loginGlobal);
        System.out.println(LoginController.senhaGlobal);
        
        
        Parent home_page_parent1 =  FXMLLoader.load(getClass().getResource("PesquisaProdutos.fxml"));
        Scene home_page_scene1 = new Scene(home_page_parent1);
        Stage app_stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage1.hide(); //optional
        app_stage1.setScene(home_page_scene1);
        app_stage1.show();  
        
      
        //até aqui
                
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
    
    public void limpar() {
    
        nomeProduto.clear();
        fornecedor.clear();
        codBar.clear();
       // quantidade.clear();
        valor.clear();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        String sla = System.getProperty("user.name");
        String txtLabel = "Ola " + sla + ", seja bem-vindo!";
        lblCurrentUser.setText(txtLabel);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblDate.setText(dateFormat.format(date)); //2014/08/06 15:59:48
  
        System.out.println("Olá");
        try {
        buildData();
        
        /*
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Bem vindo :)");
            System.out.println(alert.getButtonTypes());
            alert.setHeaderText("Olá " + sla + ", como vai?");
            alert.setContentText("Hoje é: " + dateFormat.format(date));
            alert.showAndWait();*/
        
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
