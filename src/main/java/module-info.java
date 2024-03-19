module com.example.toadsmeal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.toadsmeal to javafx.fxml;
    exports com.example.toadsmeal;
}