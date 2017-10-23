package es.fempa.accesodatos.app.simple.model.entity;
import javax.xml.bind.annotation.XmlElement;

public class Persona {
    String id;
    String nombre;
    @XmlElement(name = "apellidos")
    String apellido;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String _nombre) {
        this.nombre = _nombre;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String _apellido) {
        this.apellido = _apellido;
    }
}
