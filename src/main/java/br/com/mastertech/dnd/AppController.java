package br.com.mastertech.dnd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AppController {
    @GetMapping
    public String mostrarHome(){
        return "index";
    }

    @GetMapping("formulario")
    public String mostrarForm(){
        return "formulario";
    }

    @PostMapping("resultado")
    public String mostrarResultado(@ModelAttribute Formulario formulario, Model model)throws DadoInvalidoException {
        Dado dado = new Dado(formulario.getLados());
        Sorteador sorteador = new Sorteador(dado);
        Resultado resultado = sorteador.sortear(formulario.getVezes());

        model.addAttribute("resultado", resultado);

        return "resultado";
    }
}
