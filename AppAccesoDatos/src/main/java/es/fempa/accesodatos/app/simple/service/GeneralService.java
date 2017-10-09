package es.fempa.accesodatos.app.simple.service;

import java.util.ArrayList;
import java.util.Properties;

import org.springframework.stereotype.Service;

import es.fempa.accesodatos.app.simple.model.entity.Alumno;

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
		// TODO Auto-generated method stub
        ArrayList<Properties> list = new ArrayList<Properties>();
        Properties p = new Properties();
        p.put("name", "Vicente");
        p.put("surname", "Quiles");
        p.put("id", new Long(1));
        list.add(p);
        return list;
	}

	public ArrayList<Properties> createDemoListSax() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Alumno> createDemoListJaxb() {
		// TODO Auto-generated method stub
		return null;
	}

	public void createAlumn(Alumno alumno) {
		// TODO Auto-generated method stub
	}

}
