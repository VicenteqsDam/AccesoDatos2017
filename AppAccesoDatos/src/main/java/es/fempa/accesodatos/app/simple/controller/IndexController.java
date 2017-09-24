package es.fempa.accesodatos.app.simple.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		ArrayList<Properties> list = new ArrayList<Properties>();
		Properties p = new Properties();
		p.put("name", "Vicente");
		p.put("surname", "Quiles");
		list.add(p);
		model.put("users", list);
		return "index";
	}
}
