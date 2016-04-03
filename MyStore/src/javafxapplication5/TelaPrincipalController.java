/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;

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
    
    public void pegarCor() {

        System.out.println("It works");
    }
    
}
