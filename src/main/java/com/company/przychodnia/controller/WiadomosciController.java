package com.company.przychodnia.controller;

import com.company.przychodnia.domain.Wiadomosc;
import com.company.przychodnia.service.WiadomosciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/wiadomosci")
public class WiadomosciController {

    private final WiadomosciService wiadomosciService;

    @Autowired
    public WiadomosciController(WiadomosciService wiadomosciService) {
        this.wiadomosciService = wiadomosciService;
    }

    @GetMapping
    public String wyswietlWiadomosci(Model model) {
        model.addAttribute("wiadomosci", wiadomosciService.pobierzWszytkieWiadomosci());
        return "wiadomosci";
    }

    @GetMapping("/dodaj")
    public String dodajWiadomoscFormularz(Model model) {
        model.addAttribute("wiadomosc", new Wiadomosc());
        return "wiadomosc";
    }

    @PostMapping("/dodaj")
    public String dodajWiadomosc(@Valid @ModelAttribute Wiadomosc wiadomosc, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "wiadomosc";
        }

        wiadomosciService.zapiszWiadomosc(wiadomosc);
        return "redirect:/wiadomosci";
    }

    @GetMapping("/edytuj/{id}")
    public String edytujWiadomoscFormularz(@PathVariable String id, Model model) {
        model.addAttribute("wiadomosc", wiadomosciService.pobierzWiadomosc(Long.parseLong(id)));
        return "wiadomosc";
    }

    @GetMapping("/usun/{id}")
    public String usunWiadomosc(@PathVariable String id) {
        wiadomosciService.usunWiadomosc(Long.parseLong(id));
        return "redirect:/wiadomosci";
    }

}
