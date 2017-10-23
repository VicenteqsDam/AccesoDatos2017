package es.fempa.accesodatos.app.simple.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.fempa.accesodatos.app.simple.model.entity.Alumno;
import es.fempa.accesodatos.app.simple.model.pojo.FilterForm;
import es.fempa.accesodatos.app.simple.service.GeneralService;

@Controller
public class IndexController {

    @Autowired
    GeneralService serv;

    @RequestMapping("/")
    public String alumnListDom(Map<String, Object> model) {
        ArrayList<Properties> list = this.serv.createDemoListDom();
        model.put("alumns", list);
        model.put("filter", new FilterForm());
        return "index";
    }

    @RequestMapping("/alumn/detail/{id}")
    public String alumnDetail(Map<String, Object> model, @PathVariable Long id) {
        Properties p = this.serv.getDataAlumn(id);
        model.put("alumn", p);
        return "detail";
    }

    @PostMapping("/filterAlumn")
    public String filterAlumn(Map<String, Object> model, @ModelAttribute FilterForm filter) {
        ArrayList<Properties> list = this.serv.createDemoListFiltered(filter);
        model.put("alumns", list);
        model.put("filter", new FilterForm());
        return "index";
    }

    @RequestMapping("/alumn/new")
    public String newAlumn(Map<String, Object> model) {
        model.put("alumn", new Alumno());
        return "new";
    }

    @PostMapping("/alumn/processNewAlumn")
    public String processNewAlumn(@ModelAttribute Alumno alumno) throws JAXBException {
        this.serv.createAlumn(alumno);
        return "redirect:/";
    }
}
