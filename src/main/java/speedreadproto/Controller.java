/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speedreadproto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Ed
 */
public class Controller implements Initializable {
    
    @FXML
    private Label label;
    
    private int currentword = 0;
    private List<String> words;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadWords();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Timer t = new Timer();
        t.schedule(new TimerTask(){ 

            @Override
            public void run() {
                Platform.runLater( () -> { setNextWord(); } );
            }
        }, 0, 100);
    }   
    
    private void setNextWord()
    {
        setWord(words.get(currentword++));
    }
        
    private void setWord(String word)
    {
        label.setText(word);
    }
    
    private void loadWords() throws IOException
    {
        InputStream stream = this.getClass().getResourceAsStream("/text/sample_text.txt");
        
        if (stream==null)
            throw new IllegalStateException("couldn't load resource");
        
        BufferedReader r = new BufferedReader( new InputStreamReader( stream ) );
        String l;
        words = new ArrayList<>();
        
        while ((l=r.readLine())!=null)
        {
            words.addAll( Arrays.asList(l.split("\\s+")) );
        }
        
    }
    
    
}
