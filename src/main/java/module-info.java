module com.example.toadsmeal {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires java.sql;


    opens com.example.toadsmeal to javafx.fxml;
    exports com.example.toadsmeal;
}