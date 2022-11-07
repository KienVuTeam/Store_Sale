/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.dao_storeHouse.StoreHouse_DAO;
import com.appvn.store_sale.model.Manage_StoreHouse;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class StoreHouseController implements Initializable {

    private Stage stage;
    private Scene scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        init();
//        btn_login.addEventHandler(ActionEvent.ACTION, eh->{
////            iptf_text.getText();
//            optf_content.setText(iptf_text.getText());
//        });
    }

//    @FXML
//    void atc_back(ActionEvent e) throws IOException {
//        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.MANAGER_STORE_HOUSE));
//        Parent p = load.load();
//        scene = new Scene(p, 1000, 700);
//        stage.setScene(scene);
//        stage.show();
//
//    }
    @FXML
    private Button btn_login;
//    @FXML
//    private TextField optf_content;
    @FXML
    private TextField iptf_maKho;
    @FXML
    private TextField iptf_tenKho;
    @FXML
    private TextArea ipta_address_storeHouse;

    @FXML
    private TextField iptf_type_storeHouse;

    @FXML
    private TableColumn<?, ?> col_no;

    @FXML
    private TableColumn<Manage_StoreHouse, String> col_maKho;
    @FXML
    private TableColumn<Manage_StoreHouse, String> col_nameKho;
    @FXML
    private TableColumn<Manage_StoreHouse, String> col_address;
    @FXML
    private TableColumn<Manage_StoreHouse, String> col_type;
    @FXML
    private TableColumn<Manage_StoreHouse, Date> col_create_at;
    @FXML
    private TableColumn<Manage_StoreHouse, String> col_test;
    @FXML
    private TableView<Manage_StoreHouse> tb_storeHouse;

    public void init() {
        StoreHouse_DAO dao = new StoreHouse_DAO();
//        col_no.setCellValueFactory(new PropertyValueFactory<Manage_StoreHouse, String>("type"));
        col_maKho.setCellValueFactory(new PropertyValueFactory<Manage_StoreHouse, String>("code_storeHouse"));
        col_nameKho.setCellValueFactory(new PropertyValueFactory<Manage_StoreHouse, String>("name_store"));
        col_address.setCellValueFactory(new PropertyValueFactory<Manage_StoreHouse, String>("storeHouse_address"));
        col_type.setCellValueFactory(new PropertyValueFactory<Manage_StoreHouse, String>("type"));
        col_create_at.setCellValueFactory(new PropertyValueFactory<Manage_StoreHouse, Date>("create_at"));

        ObservableList<Manage_StoreHouse> list = dao.selectAll();
//        Manage_StoreHouse temp = new Manage_StoreHouse(btn_login);
//        temp.setDelete(new Button("Khoc"));

//start
        
//        col_test.setCellValueFactory(new PropertyValueFactory<Manage_StoreHouse, Button>("Delete"));
        tb_storeHouse.setItems(list);
//        for (Manage_StoreHouse item : tb_storeHouse.getItems()) {
//            
//        }
        //start

        //end
    }
//
    Manage_StoreHouse msh = new Manage_StoreHouse();

    @FXML
    void showOnClick(MouseEvent event) {
        try {
            msh = (Manage_StoreHouse) tb_storeHouse.getSelectionModel().getSelectedItem();
        ipta_address_storeHouse.setText(msh.getStoreHouse_address());
        iptf_type_storeHouse.setText(msh.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }

    @FXML
    public void oat_add_storeHouse(ActionEvent e) {
        Manage_StoreHouse sh = new Manage_StoreHouse();
        sh.setCode_storeHouse(iptf_maKho.getText());
        sh.setName_store(iptf_tenKho.getText());
        sh.setStoreHouse_address(ipta_address_storeHouse.getText());
        sh.setType(iptf_type_storeHouse.getText());
        StoreHouse_DAO dao = new StoreHouse_DAO();
//        System.out.println("in trong contoller: " + sh.getDate());

        dao.add(sh);
        init();
    }

    @FXML
    public void oat_delete(ActionEvent e) {
        String temp = null;
//        Manage_StoreHouse msh = new Manage_StoreHouse();
//        Manage_StoreHouse msh_tb = (Manage_StoreHouse) tb_storeHouse.getSelectionModel().getSelectedItem();
        StoreHouse_DAO dao = new StoreHouse_DAO();
//        msh_tb.setStoreHouse_address(ipta_address_storeHouse.getText());
        temp = ipta_address_storeHouse.getText();
        //v
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cofirm Delete");
        alert.setHeaderText("Thông báo");
        alert.setContentText("Choose your option");
        //
        ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType btnCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(btnYes, btnCancel);
        Optional<ButtonType> reuslut = alert.showAndWait();
        if (reuslut.get().getButtonData() == ButtonBar.ButtonData.YES) {
            dao.delete(temp);
        } else {
            System.out.println("temp");
        }
        init();
//            String msg= ""
    }

    @FXML
    public void oat_update(ActionEvent e) {
//        Manage_StoreHouse msh_tb =(Manage_StoreHouse) tb_storeHouse.getSelectionModel().getSelectedItem();
//        System.out.println("in ra cai gi?: "+msh_tb.getStoreHouse_address()+"in ra  :"+msh_tb.getType());
        Manage_StoreHouse msh = new Manage_StoreHouse();
        msh.setType(iptf_type_storeHouse.getText());
        msh.setStoreHouse_address(ipta_address_storeHouse.getText());

        StoreHouse_DAO dao = new StoreHouse_DAO();
        dao.update(msh);
        init();
    }
    private ListView list;
    private String list1;

    @FXML
    public void oat_openImage(ActionEvent e) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Workspace"));
        File selectFile = fc.showOpenDialog(null);
        if (selectFile != null) {
            list1 = String.valueOf(list.getItems().add(selectFile.getAbsolutePath()));
            System.out.println("lay trong ổ đĩa: " + list1);
        }
        System.out.println("Dang chay lenh open file");

    }

}