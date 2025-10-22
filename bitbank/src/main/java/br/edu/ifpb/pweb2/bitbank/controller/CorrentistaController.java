package br.edu.ifpb.pweb2.bitbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpb.pweb2.bitbank.model.Correntista;
import br.edu.ifpb.pweb2.bitbank.repository.CorrentistaRepository;

@Controller
@RequestMapping("/correntistas")
public class CorrentistaController {
    
    @Autowired
    private CorrentistaRepository correntistaRepository;

    @RequestMapping("/save")
    public String save(Correntista correntista, Model model) {
        correntistaRepository.save(correntista);
        model.addAttribute("correntista", correntistaRepository.findAll());
        return "correntista/list";
    }

    @RequestMapping("/form")
    public String getForm(Correntista correntista, Model model) {
        model.addAttribute("correntista", correntista);
        return "correntista/form";
    }
}

// Note que tanto a classe quanto o método getForm() possuem a anotação @RequestMapping. O uso
// dela na classe faz com que todas as rotas para métodos desta classe tenham que ter o path
//“correntistas”. Isto melhora a organização do código e padroniza URLs correlacionadas ao mesmo
// tema, como veremos durante os testes.

//Teste a aplicação no navegador com http://localhost:8080/bitbank/correntistas/form. Preencha o
//formulário e salve os dados. Um erro deve surgir na tela do navegador, pois não implementamos o
//método controlador “/correntistas/save” usado no action do formulário.