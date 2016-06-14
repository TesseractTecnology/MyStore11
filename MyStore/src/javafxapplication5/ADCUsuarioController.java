/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author welli
 */
public class ADCUsuarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private ObservableList<UserData> data;
    private static Statement stat;
    
    @FXML
    public TableView table;
    public TableColumn column1;
    public TableColumn column2;
    
    public TextField idTxt;
    public TextField nomeTxt;
    public PasswordField senhaTxt;
    public PasswordField validarSenhaTxt;
    
    public String senha;
    public String valSenha;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       buildData();
        
    }    
    
    public void voltarMain(ActionEvent event) throws IOException {
        
        Parent home_page_parent1 =  FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        Scene home_page_scene1 = new Scene(home_page_parent1);
        Stage app_stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage1.hide(); //optional
        app_stage1.setScene(home_page_scene1);
        app_stage1.show();  
        
    }
    
    public void adcionarUsuario(ActionEvent event) {
               
       // String varID = idTxt.getText();
       // String varNome = nomeTxt.getText();
        senha = senhaTxt.getText();
        valSenha = validarSenhaTxt.getText();
                
        if(senha.equals(valSenha)){
            try{ 
                ConexaoMySql con = new ConexaoMySql();
                String sql = "INSERT INTO usuarios (id_usuario, nome_usuario, senha_usuario) values (?, ?, ?)";
                PreparedStatement statement = con.conexao.prepareStatement(sql);
                statement.setString(1, idTxt.getText());
                statement.setString(2, nomeTxt.getText());
                statement.setString(3, senhaTxt.getText());
              
                  int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("A contact was inserted with photo image.");
            }
            
              buildData();
                
                
            } catch(Exception e) {
            
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Ooops, houve um erro :(");
                alert.setHeaderText("Não foi possível adicionar o usuário");
                alert.setContentText("Verifique se já existe um usuário com esse ID: " + idTxt.getText() + "\r\n"
                        +  "Por favor tente novamente");
                alert.showAndWait();
            }
            
        } else {
        
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Ooops, as senhas não conferem :(");
            alert.setHeaderText("As senhas informadas não conferem");
            alert.setContentText("Por favor tente novamente :)");
            alert.showAndWait();
        
        }
    }
    
    public void buildData(){
    
         try {
        
            ConexaoMySql c = new ConexaoMySql();
            
            stat = c.conexao.createStatement();
            data = FXCollections.observableArrayList();
            ResultSet rs = c.conexao.createStatement().executeQuery("select id_usuario, nome_usuario from usuarios");
            while (rs.next()) {
                data.add(new UserData(rs.getString("id_usuario"), rs.getString("nome_usuario")));
            }
            column1.setCellValueFactory(new PropertyValueFactory("Name"));
            column2.setCellValueFactory(new PropertyValueFactory("Email"));
            
            table.setItems(null);
            table.setItems(data);
            
        } catch (Exception e) {
        
            e.printStackTrace();
            System.out.println("erorr");
        }
    }
    
    public void excluir(ActionEvent event) throws SQLException {
        
        ObservableList selectedCells = table.getSelectionModel().getSelectedCells();
        TablePosition tablePosition = (TablePosition) selectedCells.get(0);
        Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
        String idNome = (String) column1.getCellData(tablePosition.getRow());
        System.out.println(idNome);
        ConexaoMySql con = new ConexaoMySql();
        String sql = "delete from usuarios where id_usuario = " + "'" + idNome+ "' ";
        PreparedStatement statement = con.conexao.prepareStatement(sql);
        statement.execute(sql);
        buildData();
              
    }
    
    public static class UserData {
    
        private StringProperty Name;
        private StringProperty Email;
        
        private UserData(String Name, String Email) {

            this.Name = new SimpleStringProperty(Name);
            this.Email = new SimpleStringProperty(Email);

        }
        
        public StringProperty NameProperty() {
            return Name;
        }
        
        public StringProperty EmailProperty() {
            return Email;
        }
    }

    private static class MinhaClasse {

        public void mc() {
        }
    }
}
