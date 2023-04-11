package pt.amane.condominium_fee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pt.amane.condominium_fee.model.Titulo;
import org.springframework.beans.factory.annotation.Autowired;
import pt.amane.condominium_fee.repositories.TituloRepository;
@Controller
@RequestMapping(value = "/titulos")
public class TituloController {

    @Autowired
    private TituloRepository repository;

    @RequestMapping(value = "/novo")
    public String novo() {
        return "cadastroTitulo";
    }

    @RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.POST)
    public String salvar(Titulo titulo) {
        repository.save(titulo);
        System.out.println(">>> " + titulo.getDescricao());
        return "cadastroTitulo";
    }

}
