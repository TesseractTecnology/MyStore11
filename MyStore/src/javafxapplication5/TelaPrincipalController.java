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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    public Button btnEstoque;
    public Button btnUsuarios;
    public Button btnCaixa;
 //   public ImageView imgCaixa, imgEstoque, imgUsuarios;
  //  private EventHandler<MouseEvent> oneClickHandler;
  //  private final Image image = new Image("http://icons.iconarchive.com/icons/sicons/basic-round-social/256/ember-js-icon.png");
  //  private final Image fodeu = new Image(".../imgs/1459706968_Package-Download.png");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void chamaEstoqueForm(ActionEvent event) throws IOException, SQLException {
    
         Parent cadastroEstoque1 =  FXMLLoader.load(getClass().getResource("CadastroEstoque.fxml"));
        Scene cadastro_estoque1 = new Scene(cadastroEstoque1);
        Stage stage_cadastro1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        //Westage_cadastro.hide(); //optional
        stage_cadastro1.setScene(cadastro_estoque1);
        stage_cadastro1.show();  
        
    }
    
    public void chamaUsuarios(ActionEvent event) throws IOException, SQLException {
    
    /*     Parent formUser =  FXMLLoader.load(getClass().getResource("ADDUSER.fxml"));
         Scene addUser = new Scene(formUser);
         Stage formAddUSer = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        //Westage_cadastro.hide(); //optional
        formAddUSer.setScene(addUser);
        formAddUSer.show();  */
        
    }
    
     public void handleButtonAction1(ActionEvent event) throws IOException, SQLException {

       
    }
     
   // btn.setOnMousePressed(new EventHandler<MouseEvent>() {
     
    @FXML
    private void handleMouseRelease(MouseEvent event) throws InterruptedException {
        // code in this method is executed when the mouse is released
        // on a node with onMousePressed="#handleMouseRelease
     
       
   
    }
    
 
}
