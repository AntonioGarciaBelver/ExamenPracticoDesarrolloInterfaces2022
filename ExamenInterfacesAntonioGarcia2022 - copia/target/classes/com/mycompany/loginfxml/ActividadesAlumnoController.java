
package com.mycompany.loginfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author anton
 */
public class ActividadesAlumnoController implements Initializable {

    @FXML
    private MenuItem mCerrar;
    @FXML
    private TextField txtNombre;
    @FXML
    private ComboBox<?> comboSexo;
    @FXML
    private ComboBox<?> comboActividad;
    @FXML
    private Spinner<?> spEdad;
    @FXML
    private Spinner<?> spPeso;
    @FXML
    private Spinner<?> spAltura;
    @FXML
    private TableView<?> tabla;
    @FXML
    private TableColumn<?, ?> cNombre;
    @FXML
    private TableColumn<?, ?> cSexo;
    @FXML
    private TableColumn<?, ?> cEdad;
    @FXML
    private TableColumn<?, ?> cPeso;
    @FXML
    private TableColumn<?, ?> cAltura;
    @FXML
    private TableColumn<?, ?> cActividad;
    @FXML
    private TableColumn<?, ?> cGER;
    @FXML
    private TableColumn<?, ?> cGET;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cerrarAplicacion(ActionEvent event) {
    }

    @FXML
    private void mostrarActividad(MouseEvent event) {
    }
    
}
