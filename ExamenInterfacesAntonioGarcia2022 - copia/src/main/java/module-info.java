module com.mycompany.exameninterfacesantoniogarcia2022 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.exameninterfacesantoniogarcia2022 to javafx.fxml;
    opens models;
    exports com.mycompany.exameninterfacesantoniogarcia2022;
}
