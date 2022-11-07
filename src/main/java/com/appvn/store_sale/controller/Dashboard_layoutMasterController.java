/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.res.StringValue;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Dashboard_layoutMasterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
        @FXML
    void image_logout(MouseEvent event) {
//image_logout.addEventHandler(ActionEvent.ACTION, eh -> {
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
            thisStage.close();
            System.out.println("err");
//        });
    }
//    @FXML
//    private MenuItem MI_manage_dvt;
//
//    @FXML
//    private MenuItem MI_storeHouse;

    @FXML
    private ScrollPane pane_master;

    @FXML
    private BorderPane bp;

    @FXML
    private ScrollPane sp_layout;

    @FXML
    private AnchorPane ap_after_sp;

    public void controll_init() {
//        System.out.println("run in controll_init");
//        MI_storeHouse.addEventHandler(ActionEvent.ACTION, eh -> {
//            System.out.println("co run");
////             Parent fxml = FXMLLoader.load(getClass().getResource(StringValue.SWITCH_STORE_HOUSE));
//
//            try {
//                Stage stage = (Stage) ((Node) eh.getSource()).getScene().getWindow();
//                FXMLLoader loader = new FXMLLoader(getClass().getResource(StringValue.PANE_TEMP));
//                ap_neo = loader.load();
//                Scene scene = new Scene(ap_neo);
//                stage.setScene(scene);
//                stage.show();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });

    }

//    @FXML
//    void click_ok1(MouseEvent e) {
//        System.out.println("run mouse click: ");
//        loadpage(test, "manage_XNT_storeHouse");
//    }
//
//    //
//    @FXML
//    void ok2(ActionEvent e) throws IOException {
//        System.out.println("run btn2");
//        sp_layout.setContent(ap_after_sp);
//    }
    //
    String test = "/com/appvn/store_sale/view/";

    private void loadpage(String test, String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(test + page + ".fxml"));
            Scene scene = new Scene(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        sp_layout.setContent(root);
    }

    //
    //
    @FXML
    void oat_switch_manageAccount(ActionEvent event) {
        loadpage(test, "manage_account_loginSys");
    }
//

    @FXML
    void oat_MIswitch_storeHouse(ActionEvent event) {
        loadpage(test, "storeHouse");
    }

    @FXML
    void oat_switch_manageUnit(ActionEvent event) {
        loadpage(test, "manage_dvt");
    }

    @FXML
    void oat_switch_manage_groupProduct(ActionEvent event) {
        loadpage(test, "group_product");
    }

    @FXML
    void oat_switch_product(ActionEvent event) {
        loadpage(test, "manage_product");
    }

    @FXML
    void oat_switch_manageSale(ActionEvent event) {
        loadpage(test, "manage_sale_productPrice");
    }

    @FXML
    void oat_switch_nhap(ActionEvent event) {
        loadpage(test, "manage_XNT_storeHouse");
    }

    @FXML
    void oat_switch_ton(ActionEvent event) {

    }

    @FXML
    void oat_switch_xuat(ActionEvent event) {

    }

    // controll exit sys
    @FXML
    void oat_exitSys(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    //logouy
    @FXML
    private ImageView image_logout;

    @FXML
    void oat_logout(ActionEvent e) throws IOException {
        //
//        Stage loginStage = new Stage();
//        loginStage.initModality(Modality.APPLICATION_MODAL);
//        loginStage.initStyle(StageStyle.UNDECORATED);
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(StringValue.LOGIN_SYSTEM));
//        AnchorPane LoginFormUI;
//        LoginFormUI = loader.load();
//        Scene scene = new Scene(LoginFormUI, 700, 450);
//        loginStage.setScene(scene);
//        Login_systemController controll = (Login_systemController) loader.getController();
//        controll.inithomecontroller();
//        //
//
//        loginStage.showAndWait();
    }
   //trong code
    public void load_customer(ActionEvent e){
        loadpage(test, "MgrCustomer");
    }
     public void load_CKTM(ActionEvent e){
        loadpage(test, "CKTM_Customer");
    }
     public void load_qlhoadon(ActionEvent e){
        loadpage(test, "QLHoaDOn");
    }public void load_hoadon(ActionEvent e){
        loadpage(test, "HoaDon");
    }
    ///khoa code
     public void load_page(ActionEvent e){
        loadpage(test, "DoanhThu");
    }
     public void page_phieuthu(ActionEvent e){
        loadpage(test, "PhieuThu3");
    }
     public void page_banhang(ActionEvent e){
        loadpage(test, "ThongKeBanHang");
    }
     public void page_khachhang(ActionEvent e){
        loadpage(test, "ThongKeKhachHang");
    }
     public void page_nghanhang(ActionEvent e){
        loadpage(test, "ThongKeNghanhHang");
    }
}
