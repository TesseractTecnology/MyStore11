/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    public void adcionarUsuario(ActionEvent event) {
               
        String varID = idTxt.getText();
        String varNome = nomeTxt.getText();
        senha = senhaTxt.getText();
        valSenha = validarSenhaTxt.getText();
                
        if(senha.equals(valSenha)){
            try{ 
                ConexaoMySql con = new ConexaoMySql();
                Statement st = con.conexao.createStatement();
                String sql = "insert into usuarios values('" + varID + "'," 
                        + "'" + varNome + "'," 
                        + "'" + senha + "')";
                st.execute(sql);
                buildData();
                
                
            } catch(Exception e) {
            
                System.out.println("erro");
            }
            
        } else {
        
            System.out.println("não igual");
        
        }
    }
    
    public void buildData(){
    
         try {
        
            ConexaoMySql c = new ConexaoMySql();
            
            stat = c.conexao.createStatement();
            data = FXCollections.observableArrayList();
            ResultSet rs = c.conexao.createStatement().executeQuery("select usuarios,nome from usuarios");
            while (rs.next()) {
                data.add(new UserData(rs.getString("usuarios"), rs.getString("nome")));
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
}
