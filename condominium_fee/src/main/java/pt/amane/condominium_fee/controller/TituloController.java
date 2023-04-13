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
import org.springframework.validation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/titulos")
public class TituloController {

    @Autowired
    private TituloRepository repository;

    @RequestMapping(value = "/novo")
    public ModelAndView novo() {
        ModelAndView modelAndView = new ModelAndView("cadastroTitulo");
        modelAndView.addObject(new Titulo());
        // StatusTitulo.values() ->retorna um array de enum
        //todosStatusTitulo é um objecto chave que recebe o valor de array de enum.
        modelAndView.addObject("todosStatusTitulo", StatusTitulo.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {
        //ModelAndView modelAndView = new ModelAndView("cadastroTitulo");
        if (errors.hasErrors()) {
            return "cadastroTitulo";
        }
        repository.save(titulo);
//        ModelAndView mv = new ModelAndView("redirect:/titulos/novo");
        attributes.addFlashAttribute("mensagem", "Titulo salvo com sucesso!");
        return "redirect:/titulos/novo";
    }

    @RequestMapping
    public ModelAndView pesquisar() {
        java.util.List<Titulo> todosTitulos = repository.findAll();
        ModelAndView modelAndView = new org.springframework.web.servlet.ModelAndView("pesquisaTitulos");
        modelAndView.addObject("titulos", todosTitulos);
        return modelAndView;
    }

    @ModelAttribute("todosStatusTitulo")
    public java.util.List<pt.amane.condominium_fee.model.StatusTitulo> todosStatusTitulo() {
        return Arrays.asList(StatusTitulo.values());
    }

}
