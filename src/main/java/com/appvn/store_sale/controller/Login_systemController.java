/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.dao_storeHouse.Account_loginSys_DAO;
import com.appvn.store_sale.model.Account_loginSystem;
import com.appvn.store_sale.res.StringValue;
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Login_systemController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField iptf_username;

    @FXML
    private TextField iptf_userpass;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }
    private Stage stage;
    private Scene scene;

    public void inithomecontroller() {

    }

    //
    @FXML
    void oat_clear(ActionEvent event) {

    }

    @FXML
    void oat_loginSys(ActionEvent e) throws IOException {
        try {
            Account_loginSys_DAO dao = new Account_loginSys_DAO();
            Account_loginSystem check_user = dao.checkLogin(iptf_username.getText(), iptf_userpass.getText());
            System.out.println("pass and username: " + iptf_username.getText() + " | " + iptf_userpass.getText());
            if (check_user != null) {
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.close();
                stage = new Stage();
                FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.DASHBOARD_SYS));
                Parent p = load.load();
                scene = new Scene(p); //, 1530, 790
                stage.setScene(scene);
                stage.setFullScreen(true);
                stage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("K"));
                stage.show();
            } else {
                System.out.println("Tên đăng nhập or mật khẩu sai !!!");

            }
        } catch (Exception ex) {
            Logger.getLogger(Login_systemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
