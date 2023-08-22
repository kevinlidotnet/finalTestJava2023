module com.example.finaltestjava2023 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.finaltestjava2023 to javafx.fxml, com.google.gson;
    exports com.example.finaltestjava2023;
}