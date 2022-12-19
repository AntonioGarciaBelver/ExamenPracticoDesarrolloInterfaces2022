package com.mycompany.exameninterfacesantoniogarcia2022;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Usuario;

public class PrimaryController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private ComboBox<String> comboSexo;
    @FXML
    private ComboBox<String> comboActividad;
    @FXML
    private Spinner<Integer> spEdad;
    @FXML
    private Spinner<Double> spPeso;
    @FXML
    private Spinner<Integer> spAltura;
    @FXML
    private TableView<Usuario> tabla;
    @FXML
    private TableColumn<Usuario, String> cNombre;
    @FXML
    private TableColumn<Usuario, String> cSexo;
    @FXML
    private TableColumn<Usuario, String> cEdad;
    @FXML
    private TableColumn<Usuario, String> cPeso;
    @FXML
    private TableColumn<Usuario, String> cAltura;
    @FXML
    private TableColumn<Usuario, String> cActividad;
    @FXML
    private TableColumn<Usuario, String> cGER;
    @FXML
    private TableColumn<Usuario, String> cGET;
    
    List<Usuario> usuarios1 = new ArrayList();
    Usuario usuarioActual = new Usuario();
    @FXML
    private Label info;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        inicializarTabla();
        cargarCombosYSpinners();
        actualizarTabla();
    }

    private void actualizarTabla() {
        
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
        usuarios.addAll(usuarios1);

        tabla.getItems().clear();
        tabla.getItems().addAll(usuarios);

    }

    @FXML
    private void añadirUsuario(ActionEvent event) {

        Usuario nuevoUsuario = new Usuario();
        
        nuevoUsuario.setNombre(txtNombre.getText());
        nuevoUsuario.setSexo(comboSexo.getValue());
        nuevoUsuario.setEdad(spEdad.getValue());
        nuevoUsuario.setPeso(spPeso.getValue());
        nuevoUsuario.setEstatura(spAltura.getValue());
        nuevoUsuario.setActividad(comboActividad.getValue());
        nuevoUsuario.setGer(calcularGER(nuevoUsuario.getSexo(), nuevoUsuario.getPeso(),
                nuevoUsuario.getEstatura(), nuevoUsuario.getEdad()));
        nuevoUsuario.setGet(calcularGET(nuevoUsuario));
        
        usuarios1.add(nuevoUsuario);
        actualizarTabla();
        vaciarFormulario();
        
        info.setText("Usuario  " + nuevoUsuario.getNombre() + " añadido con éxito!");
        info.setStyle("-fx-background-color:#00FF00; -fx-text-fill:white; -fx-font-weight: bold");
    }

    private void cargarCombosYSpinners() {
        cargarComboSexo();
        cargarComboActividad();
        cargarSpinnerEdad();
        cargarSpinnerPeso();
        cargarSpinnerAltura();
    }
    
    private void cargarComboSexo(){
        ObservableList<String> sexo1 = FXCollections.observableArrayList();
        String[] sexo = {"Hombre", "Mujer"};
        sexo1.addAll(sexo);
        comboSexo.setItems(sexo1);
    }

    private void cargarComboActividad() {
        ObservableList<String> actividades1 = FXCollections.observableArrayList();
        String[] actividades = {"Muy ligera", "Ligera", "Moderada", "Intensa"};
        actividades1.addAll(actividades);
        comboActividad.setItems(actividades1);
    }

    private void cargarSpinnerEdad() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.
                IntegerSpinnerValueFactory(0, 100, 0, 1);
        spEdad.setValueFactory(valueFactory);
    }

    private void cargarSpinnerPeso() {
        SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.
                DoubleSpinnerValueFactory(0.0, 300.0, 75.0, 0.25);
        spPeso.setValueFactory(valueFactory);
    }

    private void cargarSpinnerAltura() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.
                IntegerSpinnerValueFactory(100, 220, 165, 1);
        spAltura.setValueFactory(valueFactory);
    }

    private void vaciarFormulario() {
        txtNombre.setText("");
        comboSexo.getEditor().clear();
        spEdad.getEditor().clear();
        spPeso.getEditor().clear();
        spAltura.getEditor().clear();
        comboActividad.getEditor().clear();
        
    }

    private void inicializarTabla() {
        cNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        cSexo.setCellValueFactory(new PropertyValueFactory("sexo"));
        cEdad.setCellValueFactory(new PropertyValueFactory("edad"));
        cPeso.setCellValueFactory(new PropertyValueFactory("peso"));
        cAltura.setCellValueFactory(new PropertyValueFactory("estatura"));
        cActividad.setCellValueFactory(new PropertyValueFactory("actividad"));
        cGER.setCellValueFactory(new PropertyValueFactory("ger"));
        cGET.setCellValueFactory(new PropertyValueFactory("get"));
        
    }
    
    private Double calcularGER(String sexo, Double peso, Integer estatura, Integer edad){
        Double GER = 0.0;
        if(sexo.equals("Hombre")){
            return GER = (66.473+13.751*peso+5.0033*estatura-6.755*edad);
        }else{
            return GER = (655.0955+9.463*peso+1.8496*estatura-4.6756*edad);
        }
    }
    
    private Double calcularGET(Usuario usuarioActual){
        Double ger = usuarioActual.getGer();
        Double get = 0.0;
        if(usuarioActual.getSexo().equals("Hombre")){
            switch (usuarioActual.getActividad()) {
                case "Muy ligera":
                get = ger * 1.3;
                break;
            case "Ligera":
                get = ger * 1.6;
                break;
            case "Moderada":
                get = ger * 1.7;
                break;
            case "Intensa":
                get = ger * 2.1;
                break;
            }
            return get;
        }else{
            switch (usuarioActual.getActividad()) {
                case "Muy ligera":
                get = ger * 1.3;
                break;
            case "Ligera":
                get = ger * 1.6;
                break;
            case "Moderada":
                get = ger * 1.7;
                break;
            case "Intensa":
                get = ger * 2.1;
                break;
            }
            return get;
        }
        
        
    }
}
