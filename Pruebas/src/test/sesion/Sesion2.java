package test.sesion;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import test.clases.ManejadorSAX;
import test.xml.Body;
import test.xml.Div;
import test.xml.Head;
import test.xml.Html;

public class Sesion2 {

	public void escribirBytesFicheroHTML() throws IOException {
		Html html = this.generarHTMLEjemploSesion2();

		File file = new File("ficheroBinario.bin");
		FileOutputStream fichero = new FileOutputStream(file);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(html);
		os.close();
		fichero.write(out.toByteArray());
		fichero.close();
	}

	private Html generarHTMLEjemploSesion2() {
		Html html = new Html();
		Body body = new Body();
		Head head = new Head();
		Div div = new Div();

		head.setValue("Contenido del head");

		div.setStyle("color:red");
		div.setValue("Contenido de prueba del div.");

		body.setValue("Esto es el body.");
		body.getDivs().add(div);

		html.setHead(head);
		html.setBody(body);
		return html;
	}

	public void leerXMLDom() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringComments(true);
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		File fichero = new File("E:/DAM/familia.xml");
		Document doc = builder.parse(fichero);
		Node raiz = doc.getFirstChild();
		this.procesarXML(raiz);
		this.addNodoDiv(doc);
		this.guardarDOMcomoFILE(doc);
	}

	public void leerSAX() throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		ManejadorSAX manejador = new ManejadorSAX();
		parser.parse(new File("nuevo.xml"), manejador);
	}

	public void leerJAXB() throws ParserConfigurationException, SAXException, IOException, JAXBException {
			File file = new File("nuevo.xml");
			JAXBContext contexto = JAXBContext.newInstance(Html.class);
			Unmarshaller u = contexto.createUnmarshaller();
			Html html = (Html) u.unmarshal(file);
	}

	public void guardarDOMcomoFILE(Document doc) throws TransformerException, IOException {
		DOMSource source = new DOMSource(doc);
		FileWriter writer = new FileWriter(new File("nuevo.xml"));
		StreamResult result = new StreamResult(writer);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.transform(source, result);
	}

	private void addNodoDiv(Document doc) {
		NodeList bodyList = doc.getElementsByTagName("body");
		Node nuevoDiv = doc.createElement("div");
		Node nuevoDiv_value = doc.createTextNode("Contenido del nuevo div");
		nuevoDiv.appendChild(nuevoDiv_value);
		((Element) nuevoDiv).setAttribute("style", "color:blue;");
		bodyList.item(0).appendChild(nuevoDiv);

	}

	private void procesarXML(Node nodo) {
		NodeList nodosHijo = nodo.getChildNodes();
		System.out.print("<" + nodo.getNodeName());
		NamedNodeMap atributos = nodo.getAttributes();
		for (int i = 0; i < atributos.getLength(); i++) {
			System.out.print(" " + atributos.item(i).getNodeName() + "=\"");
			System.out.print(atributos.item(i).getNodeValue() + "\" ");
		}
		System.out.print(">\n");
		String valorNodo = nodo.getFirstChild().getNodeValue();
		if (valorNodo != null) {
			System.out.println(valorNodo);
		}
		for (int i = 0; i < nodosHijo.getLength(); i++) {
			Node nodoHijo = nodosHijo.item(i);
			if (nodoHijo.getChildNodes().getLength() > 0) {
				this.procesarXML(nodoHijo);
			}
		}
		System.out.println("</" + nodo.getNodeName() + ">");
	}
}
