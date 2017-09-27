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

import es.fempa.accesodatos.app.simple.model.entity.Alumno;

@Service
public class GeneralService {

	public String getHelloMessage() {
		return "Hello ";
	}

	public ArrayList<Properties> createDemoList() throws ParserConfigurationException, SAXException, IOException {
		ArrayList<Properties> list = new ArrayList<Properties>();
		Properties p;
		Alumno miAlumno;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringComments(true);
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		File fichero = new File("C:/Users/Antonio/Desktop/DAM/CURSO 2º/ACCESO A DATOS/CarpetaKraken/AccesoDatos2017/AppAccesoDatos/src/main/resources/files/alumnos.xml");
		Document doc = builder.parse(fichero);
		Node raiz = doc.getFirstChild();
		//System.out.println(raiz.getNodeName());
		NodeList hijos = raiz.getChildNodes();
		for(int i=0; i<hijos.getLength(); i++)
		{
			if(hijos.item(i).getNodeName().equals("ROW"))
			{
				NodeList nietos = hijos.item(i).getChildNodes();
				p = new Properties();
				miAlumno = new Alumno();
				for(int j=0; j<nietos.getLength();j++)
				{									
					if(nietos.item(j).getNodeName().equals("nombre"))
					{						
						miAlumno.setName(nietos.item(j).getFirstChild().getNodeValue());
					}
					if(nietos.item(j).getNodeName().equals("apellidos"))
					{
						miAlumno.setSurname(nietos.item(j).getFirstChild().getNodeValue());
					}
					if(nietos.item(j).getNodeName().equals("id"))
					{
						miAlumno.setId(nietos.item(j).getFirstChild().getNodeValue());
					}
				}
				p.put("name", miAlumno.getName());
				p.put("surname", miAlumno.getSurname());
				p.put("id", miAlumno.getId());
				list.add(p);				
			}
		}		
		/*p.put("name", "Vicente");
		p.put("surname", "Quiles");
		p.put("id", new Long(1));
		list.add(p);*/
		return list;
	}

}
