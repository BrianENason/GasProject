module com.example.gasproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.gasproject to javafx.fxml;
    exports com.example.gasproject;
}