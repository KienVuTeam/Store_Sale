module com.appvn.store_sale {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    opens com.appvn.store_sale.model;
    exports com.appvn.store_sale.model;
    
    opens com.appvn.store_sale to javafx.fxml;
    exports com.appvn.store_sale;
    //
    opens com.appvn.store_sale.controller;
    exports com.appvn.store_sale.controller;
   
    requires com.microsoft.sqlserver.jdbc;
}
