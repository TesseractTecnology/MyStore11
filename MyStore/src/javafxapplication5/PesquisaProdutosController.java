/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author welli
 */
public class PesquisaProdutosController implements Initializable {

    
    @FXML
    public Button btn;
    public Label lblCurrentUser;
    public Label lblDate;
    public TableView table;
    public TableColumn column1;
    public TableColumn column2;
    public TableColumn column3;
    public TableColumn column4;
    public TableColumn column5;
    public TableColumn column6;
    public TableColumn column7;
    public TableColumn column8;
    public TableColumn column9;
    public TableColumn column10;
    private ObservableList<UserData> data;
    private static Statement stat;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     /*   System.out.println("-----------------------------------------------------------------------------");
        String sla = System.getProperty("user.name");
        String txtLabel = "Olá " + sla + ", seja bem-vindo!";
        lblCurrentUser.setText(txtLabel);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblDate.setText(dateFormat.format(date));*/
        buildData();
        table.getSelectionModel().setCellSelectionEnabled(false);
    
    } 
    
    public void voltarMain(ActionEvent event) throws IOException {
        
        Parent home_page_parent1 =  FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        Scene home_page_scene1 = new Scene(home_page_parent1);
        Stage app_stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage1.hide(); //optional
        app_stage1.setScene(home_page_scene1);
        app_stage1.show();  
        
    }
    
    public void adcionar(ActionEvent event) throws IOException {
        
        Parent home_page_parent1 =  FXMLLoader.load(getClass().getResource("CadastroEstoque.fxml"));
        Scene home_page_scene1 = new Scene(home_page_parent1);
        Stage app_stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage1.hide(); //optional
        app_stage1.setScene(home_page_scene1);
        app_stage1.show();  
    
    }
    
    public void buildData(){
    
         try {
        
            ConexaoMySql c = new ConexaoMySql();
            
            stat = c.conexao.createStatement();
            data = FXCollections.observableArrayList();
            ResultSet rs = c.conexao.createStatement().executeQuery("select nomeproduto,fornecedor, codbar, Quantidade, Valor, DataFab, DataVal, DataEnt, Categoria, Descricao from tbl_estoque");
            while (rs.next()) {
                data.add(new UserData(
                        rs.getString("nomeproduto"), 
                        rs.getString("fornecedor"), 
                        rs.getInt("codbar"), 
                        rs.getInt("Quantidade"), 
                        rs.getFloat("Valor"),
                        rs.getString("DataFab"),
                        rs.getString("DataVal"),
                        rs.getString("DataEnt"),
                        rs.getString("Categoria"),
                        rs.getString("Descricao")
                       ));
            }
            column1.setCellValueFactory(new PropertyValueFactory("Name"));
            column2.setCellValueFactory(new PropertyValueFactory("Email"));
            column3.setCellValueFactory(new PropertyValueFactory("Codbar"));
            column4.setCellValueFactory(new PropertyValueFactory("Quantidade"));
            column5.setCellValueFactory(new PropertyValueFactory("Valor"));
            column6.setCellValueFactory(new PropertyValueFactory("DataFab"));
            column7.setCellValueFactory(new PropertyValueFactory("DataVal"));
            column8.setCellValueFactory(new PropertyValueFactory("DataEnt"));
            column9.setCellValueFactory(new PropertyValueFactory("Categoria"));
            column10.setCellValueFactory(new PropertyValueFactory("Descricao"));
            
            table.setItems(null);
            table.setItems(data);
            
        } catch (Exception e) {
        
            e.printStackTrace();
            System.out.println("erorr");
        }
    }
  

   
    public void exclui() {
       
        ObservableList selectedCells = table.getSelectionModel().getSelectedCells();
        
        TablePosition tablePosition = (TablePosition) selectedCells.get(0);
        Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
        System.out.println(column1.getCellData(tablePosition.getRow()));
      //  System.out.println("Valor selecionado:" + val);
     
    }

    public static class UserData {
    
        private StringProperty Name;
        private StringProperty Email;
        private IntegerProperty Codbar;
        private IntegerProperty Quantidade;
        private FloatProperty Valor;
      
        private StringProperty DataFab;
        private StringProperty DataVal;
        private StringProperty DataEnt;
        private StringProperty Categoria;
        private StringProperty Descricao;
                        
        private UserData(String Name, String Email, Integer Codbar, Integer Quantidade, Float Valor, String DataFab, String DataEnt, String DataVal, String Categoria , String Descricao) {

            this.Name = new SimpleStringProperty(Name);
            this.Email = new SimpleStringProperty(Email);
            this.Codbar = new SimpleIntegerProperty(Codbar);
            this.Quantidade = new SimpleIntegerProperty(Quantidade);
            this.Valor =  new SimpleFloatProperty(Valor);
            this.DataFab = new SimpleStringProperty(DataFab);
            this.DataVal = new SimpleStringProperty(DataVal);
            this.DataEnt = new SimpleStringProperty(DataEnt);
            this.Categoria = new SimpleStringProperty(Categoria);
            this.Descricao = new SimpleStringProperty(Descricao);
        }
                
        public StringProperty NameProperty() {
            return Name;
        }
        
        public StringProperty EmailProperty() {
            return Email;
        }
        
        public IntegerProperty CodbarProperty() {
            return Codbar;
        }
        
        public IntegerProperty QuantidadeProperty() {
            return Quantidade;
        }
        
        public FloatProperty ValorProperty() {
            return Valor;
        }
    
        public StringProperty DataFabProperty() {
            return DataFab;
        }
        
        public StringProperty DataValProperty() {
            return DataVal;
        }
        
        public StringProperty DataEntProperty() {
            return DataEnt;
        }
        
        public StringProperty CategoriaProperty() {
            return Categoria;
        }
        
        public StringProperty DescricaoProperty() {
            return Descricao;
        }
        
    }
        
}
