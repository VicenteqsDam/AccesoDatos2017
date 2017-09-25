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

import java.util.ArrayList;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class GeneralService {

	public String getHelloMessage() {
		return "Hello ";
	}

	public ArrayList<Properties> createDemoList() {
		ArrayList<Properties> list = new ArrayList<Properties>();
		Properties p = new Properties();
		p.put("name", "Vicente");
		p.put("surname", "Quiles");
		p.put("id", new Long(1));
		list.add(p);
		return list;
	}

}
