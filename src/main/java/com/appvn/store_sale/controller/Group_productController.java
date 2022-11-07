/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.dao_storeHouse.Group_product_DAO;
import com.appvn.store_sale.model.Group_product;
import com.appvn.store_sale.res.StringValue;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Group_productController implements Initializable {

    private Stage stage;
    private Scene scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init_tableGP();
    }

    @FXML
    private TextArea iptf_describe;

    @FXML
    private TextField iptf_name_gproduct;

    @FXML
    private TableColumn<Group_product, String> col_describe;

    @FXML
    private TableColumn<Group_product, String> col_name_gproduct;

    @FXML
    private TableView<Group_product> tbl_gproduct;

//    @FXML
//    void oat_back(ActionEvent e) throws IOException {
//        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.MANAGER_STORE_HOUSE));
//        Parent layout = load.load();
//        scene = new Scene(layout, 1000, 700);
//        stage.setScene(scene);
//        stage.show();
//    }

    @FXML
    void oat_add(ActionEvent e) {
        Group_product gp = new Group_product();
        gp.setName_groupProduct(iptf_name_gproduct.getText());
        gp.setDescribe(iptf_describe.getText());

        Group_product_DAO dao = new Group_product_DAO();
        dao.add(gp);
        init_tableGP();
    }

    void init_tableGP() {
        ObservableList data = FXCollections.observableArrayList();
        String sql = "SELECT * FROM group_product";
        try {
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                data.add(new Group_product(rs.getString("name_gproduct"), rs.getString("describe")));
            }

        } catch (Exception ex) {
            Logger.getLogger(Group_productController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //col trong table
        col_name_gproduct.setCellValueFactory(new PropertyValueFactory<Group_product, String>("name_groupProduct"));
        col_describe.setCellValueFactory(new PropertyValueFactory<Group_product, String>("describe"));
        tbl_gproduct.setItems(data);

    }
}
