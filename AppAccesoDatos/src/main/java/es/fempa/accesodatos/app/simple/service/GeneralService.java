package es.fempa.accesodatos.app.simple.service;

import java.util.ArrayList;
import java.util.Properties;

import org.springframework.stereotype.Service;

import es.fempa.accesodatos.app.simple.model.entity.Alumno;

@Service
public class GeneralService {

	public ArrayList<Properties> createDemoList() {
		ArrayList<Properties> list = new ArrayList<Properties>();
		Properties p = new Properties();
		p.put("name", "Vicente");
		p.put("surname", "Quiles");
		p.put("id", new Long(1));
		list.add(p);
		return list;
	}

	public Properties getDataAlumn(Long id) {
		// TODO Auto-generated method stub
		return null;
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
