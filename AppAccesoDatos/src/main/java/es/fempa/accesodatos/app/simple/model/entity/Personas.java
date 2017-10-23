package es.fempa.accesodatos.app.simple.model.entity;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ROWSET")
public class Personas {

    List<Persona> personas;

    @XmlElement(name = "ROW")
    public List<Persona> getPersonas() {
        return this.personas;
    }

    public void setPersonas(List<Persona> _personas) {
        this.personas = _personas;
    }
}
