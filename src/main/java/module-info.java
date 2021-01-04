module com.pooespol.proyecto2_poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pooespol.proyecto2_poo to javafx.fxml;
    exports com.pooespol.proyecto2_poo;
}
