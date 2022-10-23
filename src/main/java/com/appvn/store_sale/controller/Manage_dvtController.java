/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.dao_storeHouse.Manage_dvt_DAO;
import com.appvn.store_sale.model.Manage_dvt;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Manage_dvtController implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    private TableColumn<Manage_dvt, String> col_unitname_primitive;
    @FXML
    private TableColumn<Manage_dvt, String> col_unitma;

    @FXML
    private TextField iptf_unitma;

    @FXML
    private TextField iptf_unitname;

    @FXML
    private TableView<Manage_dvt> tbl_unit;

    //page2
    @FXML
    private ComboBox<String> cbx2_unitpri;

    @FXML
    private TextField iptf2_valueunit;

    @FXML
    private TextField iptf2_unitname_exchange;

    @FXML
    private TableColumn<Manage_dvt, String> coltb2_unitExchange;
    @FXML
    private TableColumn<Manage_dvt, String> coltb2_unitPri;
    @FXML
    private TableColumn<Manage_dvt, Float> coltb2_valueExchange;

    @FXML
    private TableView<Manage_dvt> tbl2_unitExchange;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();
        cbx_getUnit();
        init_tb_dvt();
    }

    @FXML
    void oat_back(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.MANAGER_STORE_HOUSE));
        Parent p = load.load();
        scene = new Scene(p, 1000, 700);
        stage.setScene(scene);
        stage.show();
    }

    public void init() {
        Manage_dvt_DAO dao = new Manage_dvt_DAO();
        col_unitname_primitive.setCellValueFactory(new PropertyValueFactory<Manage_dvt, String>("unit_name"));
        col_unitma.setCellValueFactory(new PropertyValueFactory<Manage_dvt, String>("id_unit"));
        ObservableList<Manage_dvt> list = dao.selectAll();
        tbl_unit.setItems(list);
    }

    @FXML
    void showOnClick1(MouseEvent e) {
        Manage_dvt mu = new Manage_dvt();
        mu = (Manage_dvt) tbl_unit.getSelectionModel().getSelectedItem();
        iptf_unitma.setText(mu.getId_unit());
        iptf_unitname.setText(mu.getUnit_name());
    }

    @FXML
    void oat_add(ActionEvent event) {
        Manage_dvt mu = new Manage_dvt();
        mu.setId_unit(iptf_unitma.getText());
        mu.setUnit_name(iptf_unitname.getText());

        Manage_dvt_DAO dao = new Manage_dvt_DAO();
        dao.add(mu);
        init();
    }

    @FXML
    void oat_delete(ActionEvent event) {

    }

    @FXML
    void oat_update(ActionEvent event) {

    }

    //page2
    public void init_tb_dvt() {
        ObservableList<Manage_dvt> list_dvt = FXCollections.observableArrayList();
        try {
            //        Manage_dvt_DAO dao = new Manage_dvt_DAO();
//            String sql = "SELECT DISTINCT unit_exchange. FROM unit_exchange";
            String sql = "SELECT ex.unitname_exchange, ex.value_exchange, ex.id_unit, u.unit_name"
                    + " FROM unit_exchange as ex FULL JOIN unit as u ON ex.id_unit = u.id_unit";
//                    + "ORDER BY Khachhang.Hoten";
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list_dvt.add(new Manage_dvt(rs.getString("unit_name"), rs.getString("unitname_exchange"), rs.getFloat("value_exchange")) );//Chua code xong
            }
        } catch (Exception ex) {
            Logger.getLogger(Manage_dvtController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return list_dvt;

        coltb2_unitExchange.setCellValueFactory(new PropertyValueFactory<Manage_dvt, String>("unit_namep2"));
        coltb2_valueExchange.setCellValueFactory(new PropertyValueFactory<Manage_dvt, Float>("unit_value2"));
        coltb2_unitPri.setCellValueFactory(new PropertyValueFactory<Manage_dvt, String>("unitname_exchange2"));
        tbl2_unitExchange.setItems(list_dvt);
        //        ObservableList<Manage_dvt> list = dao.selectAll();
        //        tbl_unit.setItems(list);
    }

    public void cbx_getUnit() {
        ObservableList data_unit = FXCollections.observableArrayList();
        String sql = "SELECT DISTINCT unit_name from unit";
        try {
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                data_unit.add(rs.getString("unit_name"));
            }
            cbx2_unitpri.setItems(data_unit);
            rs.close();
            pst.close();
            Connect_SQLSRV_StoreSale.closeConection(conn);
        } catch (Exception ex) {
            Logger.getLogger(Manage_dvtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void oat_add_page2(ActionEvent e) {
        Manage_dvt mu2 = new Manage_dvt();
        mu2.setUnitname_exchange2(iptf2_unitname_exchange.getText());
        mu2.setUnit_value2(Float.valueOf(iptf2_valueunit.getText()));
        mu2.setUnit_namep2(cbx2_unitpri.getValue());
        Manage_dvt_DAO dao = new Manage_dvt_DAO();
        dao.add_page2(mu2);

        System.out.println("in trong controller page2 :" + mu2.getUnitname_exchange2() + " | " + mu2.getUnit_value2() + " | " + mu2.getUnit_namep2());
    }

}
