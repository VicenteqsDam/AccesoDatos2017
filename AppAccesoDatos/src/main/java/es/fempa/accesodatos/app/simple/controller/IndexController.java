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
	public String userList(Map<String, Object> model) {
		ArrayList<Properties> list = this.serv.createDemoList();
		model.put("users", list);
		return "index";
	}

	@RequestMapping("/user/detail/{id}")
	public String userDetail(Map<String, Object> model, @PathVariable Long id) {
		return "detail";
	}
}
