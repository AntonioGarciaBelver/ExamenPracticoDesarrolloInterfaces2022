package models;

/**
 *
 * @author anton
 */
public class Usuario {
    
    private String nombre;
    private String sexo;
    private int edad;
    private double peso;
    private int estatura;
    private String actividad;
    private Double ger;
    private Double get;

    public Double getGer() {
        return ger;
    }

    public void setGer(Double ger) {
        this.ger = ger;
    }

    public Double getGet() {
        return get;
    }

    public void setGet(Double get) {
        this.get = get;
    }
    
    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Integer getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + ", peso=" + peso + ", estatura=" + estatura + '}';
    }
    
}
