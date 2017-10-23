package es.fempa.accesodatos.app.simple.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import es.fempa.accesodatos.app.simple.model.entity.Alumno;
import es.fempa.accesodatos.app.simple.model.entity.Persona;
import es.fempa.accesodatos.app.simple.model.entity.Personas;
import es.fempa.accesodatos.app.simple.model.pojo.FilterForm;

@Service
public class GeneralService {

	public Properties getDataAlumn(Long id) {
        Properties p = new Properties();
        p.put("name", "Vicente");
        p.put("surname", "Quiles");
        p.put("id", new Long(1));
        p.put("email", "email@mail.com");
        p.put("phone", 232323);
        p.put("birthdate", "01-01-2017");
		return p;
	}

	public ArrayList<Properties> createDemoListDom() {
        ArrayList<Properties> list = new ArrayList<Properties>();
        Properties p = new Properties();
        p.put("name", "Vicente");
        p.put("surname", "Quiles");
        p.put("id", new Long(1));
        list.add(p);
        return list;
	}

	public void createAlumn(Alumno alumno) throws JAXBException {
        File file = new File("alumnos.xml");
        JAXBContext contexto = JAXBContext.newInstance(Personas.class);
        Unmarshaller u = contexto.createUnmarshaller();
        Personas xmlCompleto = (Personas) u.unmarshal(file);
        Persona per = new Persona();
        per.setId("1");
	}

    public ArrayList<Properties> createDemoListFiltered(FilterForm filter) {
        ArrayList<Properties> list = new ArrayList<Properties>();
        Properties p = new Properties();
        p.put("name", "Vicente");
        p.put("surname", "Quiles");
        p.put("id", new Long(1));
        list.add(p);
        p = new Properties();
        p.put("name", filter.getText());
        p.put("surname", "Quiles2");
        p.put("id", new Long(12));
        list.add(p);
        return list;
    }

}
