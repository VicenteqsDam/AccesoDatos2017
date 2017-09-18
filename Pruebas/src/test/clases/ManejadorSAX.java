package test.clases;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorSAX extends DefaultHandler {
	
	String result = "";
	
	@Override
	public void startDocument() {
		System.out.println("Empieza el documento");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if (qName.equals("div")) {
			System.out.println(atts.getValue(atts.getQName(0)));
		}
	}
}
