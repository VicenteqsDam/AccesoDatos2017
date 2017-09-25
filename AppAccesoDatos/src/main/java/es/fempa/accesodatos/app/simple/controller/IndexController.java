package es.fempa.accesodatos.app.simple.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.fempa.accesodatos.app.simple.service.GeneralService;

@Controller
public class IndexController {

	@Autowired
	GeneralService serv;

	@RequestMapping("/")
	public String alumnList(Map<String, Object> model) {
		ArrayList<Properties> list = this.serv.createDemoList();
		model.put("alumns", list);
		return "index";
	}

	@RequestMapping("/alumn/detail/{id}")
	public String alumnDetail(Map<String, Object> model, @PathVariable Long id) {
		return "detail";
	}

	@RequestMapping("/alumn/new")
	public String alumnNew() {
		return "new";
	}
}
