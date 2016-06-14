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
import java.time.LocalDate;
import java.time.ZoneId;
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
    public NumberTextField codBar;
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
    public Button voltarMain;
    
    public String np, frn, cat, barcode;
    public int  qntd;
    public float preço;
    
    
        
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException {
        
        LocalDate date1 = dataFab.getValue();
        LocalDate date2 = dataVal.getValue();
        LocalDate date3 = dataEnt.getValue();
   
        try{ 
                ConexaoMySql con = new ConexaoMySql();
                String sql = "INSERT INTO tbl_estoque (NOMEPRODUTO, FORNECEDOR, CODBAR, QUANTIDADE, VALOR, DATAFAB, DATAVAL, DATAENT, CATEGORIA, DESCRICAO) "
                        + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = con.conexao.prepareStatement(sql);
                statement.setString(1, nomeProduto.getText());
                statement.setString(2, fornecedor.getText());
                statement.setInt(3, Integer.parseInt(codBar.getText()));
                statement.setInt(4, Integer.parseInt(quantidade.getText()));
                statement.setFloat(5, Float.parseFloat(valor.getText()));
                statement.setString(6, date1.toString());
                statement.setString(7, date2.toString());
                statement.setString(8, date3.toString());
                statement.setString(9, categoria.getSelectionModel().getSelectedItem());
                statement.setString(10, desc.getText());
              
                  int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("A contact was inserted with photo image.");
            }
            
              buildData();
                
                
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("erro");
            }
            
        
    }
    
    public void voltarMain(ActionEvent event) throws IOException {
        
        Parent home_page_parent1 =  FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        Scene home_page_scene1 = new Scene(home_page_parent1);
        Stage app_stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage1.hide(); //optional
        app_stage1.setScene(home_page_scene1);
        app_stage1.show();  
        
    }
    
    public void limpar() {
    
        nomeProduto.clear();
        fornecedor.clear();
        codBar.clear();
       // quantidade.clear();
        valor.clear();
    }
    
    public void pesquisar(ActionEvent event) throws IOException{
        Parent home_page_parent1 =  FXMLLoader.load(getClass().getResource("PesquisaProdutos.fxml"));
        Scene home_page_scene1 = new Scene(home_page_parent1);
        Stage app_stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage1.hide(); //optional
        app_stage1.setScene(home_page_scene1);
        app_stage1.show();  
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        String sla = System.getProperty("user.name");
        String txtLabel = "Olá " + sla + ", seja bem-vindo!";
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
            alert.setTitle("Um erro aocorreu");
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