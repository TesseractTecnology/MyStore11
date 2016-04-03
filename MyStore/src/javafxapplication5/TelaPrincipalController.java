/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author welli
 */



public class TelaPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public Pane pn;
    public ColorPicker colorPi;
    public TitledPane tp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void handleButtonAction1(ActionEvent event) throws IOException, SQLException {

        Parent cadastroEstoque =  FXMLLoader.load(getClass().getResource("CadastroEstoque.fxml"));
        Scene cadastro_estoque = new Scene(cadastroEstoque);
        Stage stage_cadastro = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        //Westage_cadastro.hide(); //optional
        stage_cadastro.setScene(cadastro_estoque);
        stage_cadastro.show();  
    }
    
}
