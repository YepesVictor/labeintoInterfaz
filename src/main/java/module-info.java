module scene.practicafinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens scene.practicafinal to javafx.fxml;
    exports scene.practicafinal;
}
