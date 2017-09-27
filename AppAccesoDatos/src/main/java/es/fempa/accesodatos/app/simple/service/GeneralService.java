/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.fempa.accesodatos.app.simple.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Service
public class GeneralService {

	public String getHelloMessage() {
		return "Hello ";
	}

	public ArrayList<Properties> createDemoList() {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringComments(true);
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		File file = new File("src\\main\\resources\\files\\alumnos.xml");
		Document doc = null;
		try {
			doc = builder.parse(file);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Node raiz = doc.getFirstChild();
		System.out.println("todo correcto");

		NodeList nl = raiz.getChildNodes();

		for (int i = 0; i < nl.getLength(); i++) {
			System.out.println(nl.item(i).getNodeName());
			if (nl.item(i).getNodeName().equals("ROW")) {
				if (nl.item(i).hasChildNodes()) {
					NodeList aux = nl.item(i).getChildNodes();
					
					for (int j = 0; j < aux.getLength(); j++) {
						if(!aux.item(j).getNodeName().equals("#text")){
						System.out.print(aux.item(j).getNodeName()+": ");

						
						if (aux.item(j).hasChildNodes()) {
							if(!aux.item(j).getNodeName().equals("#text")){
							System.out.println(aux.item(j).getFirstChild().getNodeValue());
						}
						}
					}
				}
			}

		}

		ArrayList<Properties> list = new ArrayList<Properties>();
		Properties p = new Properties();
		p.put("name", "Vicente");
		p.put("surname", "Quiles");
		p.put("id", new Long(1));
		list.add(p);
		return list;
	}

}
