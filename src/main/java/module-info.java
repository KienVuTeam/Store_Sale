module com.appvn.store_sale {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.appvn.store_sale to javafx.fxml;
    exports com.appvn.store_sale;
    //
//    opens com.appvn.store_sale to c
    opens com.appvn.store_sale.controller;
    exports com.appvn.store_sale.controller;
    opens com.appvn.store_sale.model;
    exports com.appvn.store_sale.model;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
}
