package es.fempa.accesodatos.app.simple.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.fempa.accesodatos.app.simple.model.entity.Alumno;
import es.fempa.accesodatos.app.simple.service.GeneralService;

@Controller
public class IndexController {

    @Autowired
    GeneralService serv;

    @RequestMapping("/")
    public String alumnListDom(Map<String, Object> model) {
        ArrayList<Properties> list = this.serv.createDemoListDom();
        model.put("alumns", list);
        return "index";
    }

    @RequestMapping("/indexSax")
    public String alumnListSax(Map<String, Object> model) {
        ArrayList<Properties> list = this.serv.createDemoListSax();
        model.put("alumns", list);
        return "index";
    }

    @RequestMapping("/indexJaxb")
    public String alumnListJaxb(Map<String, Object> model) {
        ArrayList<Alumno> list = this.serv.createDemoListJaxb();
        model.put("alumns", list);
        return "index";
    }

    @RequestMapping("/alumn/detail/{id}")
    public String alumnDetail(Map<String, Object> model, @PathVariable Long id) {
        Properties p = this.serv.getDataAlumn(id);
        model.put("alumno", p);
        return "detail";
    }

    @RequestMapping("/alumn/new")
    public String newAlumn(Map<String, Object> model) {
        model.put("alumn", new Alumno());
        return "new";
    }

    @PostMapping("/alumn/processNewAlumn")
    public String processNewAlumn(@ModelAttribute Alumno alumno) {
        this.serv.createAlumn(alumno);
        return "redirect:/";
    }
}
