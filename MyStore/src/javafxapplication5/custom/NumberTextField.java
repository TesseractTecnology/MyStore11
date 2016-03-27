/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5.custom;

import javafx.scene.control.TextField;

/**
 *
 * @author welli
 */
public class NumberTextField extends TextField {
    
    public NumberTextField() {
        this.setPromptText("enter only numbers");
        
        
    }
    
    @Override
    public void replaceText(int i, int il, String string) {
        if(string.matches("[0-9]") || string.isEmpty()) {
            super.replaceText(il, il, string);
            
            
        }
    }
    @Override 
    public void replaceSelection(String string) {
    
        super.replaceSelection(string);
    }

    public void deleteNextChar(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
