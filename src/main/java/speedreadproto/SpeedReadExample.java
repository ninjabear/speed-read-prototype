/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speedreadproto;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ed
 */
public class SpeedReadExample extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/fmxl_base.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
    
        stage.setOnCloseRequest((t)->{Platform.exit(); System.exit(0); });
         
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {            
        Platform.setImplicitExit(true);
        launch(args);
    }
    
}
