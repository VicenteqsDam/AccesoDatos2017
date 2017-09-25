package test.sesion;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Pruebas {

	public static void main(String[] args)
			throws IOException, ParserConfigurationException, SAXException, TransformerException, JAXBException {
		//Sesion1 sesion1 = new Sesion1();
		Sesion2 sesion2 = new Sesion2();
		sesion2.leerXMLDom();
		sesion2.leerSAX();
		sesion2.leerJAXB();
	}

}
