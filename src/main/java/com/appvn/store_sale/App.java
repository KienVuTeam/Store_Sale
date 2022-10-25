package com.appvn.store_sale;

import com.appvn.store_sale.res.StringValue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.HOME_PAGE));
        Parent p=load.load();
        scene = new Scene(p, 1273, 773);
        
        stage.setScene(scene);
        stage.show();
    }
    
     
        
     

    

    

    public static void main(String[] args) {
        launch();
    }

}