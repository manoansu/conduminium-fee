package pt.amane.condominium_fee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pt.amane.condominium_fee.model.Titulo;
import org.springframework.beans.factory.annotation.Autowired;
import pt.amane.condominium_fee.repositories.TituloRepository;
import org.springframework.web.servlet.ModelAndView;
import pt.amane.condominium_fee.model.StatusTitulo;
import java.util.Arrays;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/titulos")
public class TituloController {

    @Autowired
    private TituloRepository repository;

    @RequestMapping(value = "/novo")
    public ModelAndView novo() {
        ModelAndView modelAndView = new ModelAndView("cadastroTitulo");
        // StatusTitulo.values() ->retorna um array de enum
        //todosStatusTitulo é um objecto chave que recebe o valor de array de enum.
        modelAndView.addObject("todosStatusTitulo", StatusTitulo.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Titulo titulo) {
        repository.save(titulo);
        ModelAndView modelAndView = new ModelAndView("cadastroTitulo");
        modelAndView.addObject("mensagem", "Titulo salvo com sucesso!");
        return modelAndView;
    }

    @RequestMapping
    public ModelAndView pesquisar() {
        java.util.List<Titulo> titulos = repository.findAll();
        ModelAndView modelAndView = new org.springframework.web.servlet.ModelAndView("PesquisaTitulos");
        modelAndView.addObject("titulos", titulos);
        return modelAndView;
    }

    @ModelAttribute("todosStatusTitulo")
    public java.util.List<StatusTitulo> todosStatusTitulo() {
        return Arrays.asList(StatusTitulo.values());
    }

}
