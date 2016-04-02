/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author welli
 */
public class PesquisaProdutosController implements Initializable {

    
    @FXML
    public Button btn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     System.out.println("-----------------------------------------------------------------------------");
    }    
    
    public void execAlguma() {
    
        System.out.println("PRessiaonado");
    
    }
    
}
