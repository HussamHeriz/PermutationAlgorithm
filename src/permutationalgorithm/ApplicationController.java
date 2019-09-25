/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutationalgorithm;

import algorithm.PermutationImplementation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ApplicationController implements Initializable {
    

    @FXML
    private TextArea cipher;

    @FXML
    private TextField key_string;

    @FXML
    private TextField padding_char;

    @FXML
    private TextArea cipher2;

    @FXML
    private TextArea message;

    @FXML
    private Button decrypt;

    @FXML
    private TextField key_string2;

    @FXML
    private TextArea message2;

    
    @FXML
    private void encrypt(ActionEvent event) {
        
        try {
            int[] key = stringToInt(key_string.getText().split(","));
            PermutationImplementation permutationAlg = new PermutationImplementation(key, padding_char.getText().charAt(0));
            String cipherText = permutationAlg.encrypt(message.getText());
            cipher.setText(cipherText);   
        }catch(Exception e){
            cipher.setText("ERROR! Please check your inputs");
        }
    }
    
    @FXML
    private void decrypt(ActionEvent event) {
        
        try {
            int[] key = stringToInt(key_string2.getText().split(","));
            PermutationImplementation permutationAlg = new PermutationImplementation(key);
            String message = permutationAlg.decrypt(cipher2.getText());
            message2.setText(message);   
        }catch(Exception e){
            message2.setText("ERROR! Please check your inputs");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public int[] stringToInt(String[] key){
        
        int[] output = new int[key.length];
        for(int i=0;i<key.length;i++){
            output[i] = Integer.parseInt(key[i]);
        }
        
        return output;
    }
    
}
