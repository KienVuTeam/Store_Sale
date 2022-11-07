/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.res.StringValue;
import com.appvn.store_sale.res.StringValue_CSS;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class HomeController implements Initializable {

//    private Stage stage;
//    private Scene scene;
//    //
//
////    public Button btn_temp;
//    @Override
    public void initialize(URL url, ResourceBundle rb) {
//         TODO  

    }
//
//    public void inithomecontroller() {
//        btn_login.addEventHandler(ActionEvent.ACTION, eh -> {
//
//            String b = iptf_username.getText();
//            System.out.println("in ra: " + b);
//            if ("admin".equals(b)) {
//                try {
//                    System.out.println("run: ");
//
//                    Stage stage = (Stage) ((Node) eh.getSource()).getScene().getWindow();
//                    stage.close();
//                    stage = new Stage();
//                    FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.MANAGER_STORE_HOUSE));
//                    Parent p = load.load();
//                    scene = new Scene(p, 1100, 700);
//                    stage.setScene(scene);
//                    stage.show();
//
//                } catch (IOException ex) {
//                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            } else {
//                System.out.println("lỗi");
//            }
//        }
//        );
//    }
//
//    //
//    @FXML
//    public void atc_manager_storeHouse(ActionEvent event) throws IOException {
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.MANAGER_STORE_HOUSE));
//        Parent p = load.load();
//        scene = new Scene(p, 1100, 700);
//        stage.setScene(scene);
//        stage.show();
//
//    }
//    //
//    @FXML
//    private TextField iptf_username;
//
//    @FXML
//    private TextField iptf_userpass;
//
//    @FXML
//    private Button btn_login;
//
//    @FXML
//    void oat_clear(ActionEvent event) {
//
//    }
//
//    @FXML
//    void oat_loginSys(ActionEvent e) throws IOException {
////        String b = iptf_username.getText();
////        if ("admin".equals(b)) {
////            try {
////                System.out.println("run: ");
////                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
////                stage.close();
////                stage = new Stage();
////                FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.MANAGER_STORE_HOUSE));
////                Parent p = load.load();
////                scene = new Scene(p, 1100, 700);
////                stage.setScene(scene);
////                stage.show();
////
////            } catch (IOException ex) {
////                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
////            }
////
////        } else {
////            System.out.println("lỗi");
////        }
//    }
//
//
//
//@FXML
//    void oat_test(ActionEvent e) throws IOException {
//        stage = new Stage();
//        stage.getIcons().add(new Image("/com/appvn/store_sale/asset/icon_system/programmer.png"));
//        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.LOGIN_SYSTEM));
//        Parent p = load.load();
//        p.getStylesheets().add(getClass().getResource(StringValue_CSS.TEMP).toExternalForm());
//        scene = new Scene(p, 650, 500);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    @FXML
//    void oat_paneMaster(ActionEvent e) throws IOException {
////        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
////        stage.close();
//        stage = new Stage();
//        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.PANE_MASTER));
//        Parent p = load.load();
//        scene = new Scene(p); //, 1530, 790
//        stage.setScene(scene);
//        stage.setFullScreen(true);
//        stage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("K"));
//        stage.show();
//    }
}
