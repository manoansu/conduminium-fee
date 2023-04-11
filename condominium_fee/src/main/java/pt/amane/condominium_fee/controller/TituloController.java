package pt.amane.condominium_fee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value = "/titulos")
public class TituloController {

    @RequestMapping(value = "/novo")
    public String novo() {
        return "cadastroTitulo";
    }

    @RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.POST)
    public String salvar(pt.amane.condominium_fee.model.Titulo titulo) {
        System.out.println(">>> " + titulo.getDescricao());
        return "cadastroTitulo";
    }

}
