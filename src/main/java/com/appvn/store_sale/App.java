package com.appvn.store_sale;

//import com.appvn.store_sale.controller.HomeController;
import com.appvn.store_sale.controller.Login_systemController;
import com.appvn.store_sale.res.StringValue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Stage loginStage = new Stage();
        loginStage.initModality(Modality.APPLICATION_MODAL);
        loginStage.initStyle(StageStyle.UNDECORATED);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(StringValue.LOGIN_SYSTEM));
        AnchorPane LoginFormUI;
        LoginFormUI = loader.load();
        scene = new Scene(LoginFormUI, 700, 450);
        loginStage.setScene(scene);
        Login_systemController controll = (Login_systemController) loader.getController();
        controll.inithomecontroller();
        //

        loginStage.showAndWait();
//        loginStage.setOnCloseRequest(eh -> {
//            try {
////                loginStage = new Stage();
//
////                Stage stage1 = new Stage();
////                FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.MANAGER_STORE_HOUSE));
////                Parent p = load.load();
////                scene = new Scene(p, 1100, 700);
////                stage.setScene(scene);
////                stage.show();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });

    }

    public static void main(String[] args) {
        launch();
    }

}
