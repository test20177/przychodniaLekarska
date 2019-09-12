package com.company.przychodnia.controller;

import com.company.przychodnia.service.WiadomosciService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PrzychodniaController {

    private final WiadomosciService wiadomosciService;

    @Autowired
    public PrzychodniaController(WiadomosciService wiadomosciService) {
        this.wiadomosciService = wiadomosciService;
    }

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("wiadomosci", Lists.reverse(wiadomosciService.pobierzOstatnieWiadomosci(3)));
        return "index";
    }

    @GetMapping("/aktualnosci")
    public String aktualnosci(Model model) {
        model.addAttribute("wiadomosci", Lists.reverse(wiadomosciService.pobierzWszytkieWiadomosci()));
        return "aktualnosci";
    }

    @GetMapping("/oferta")
    public String oferta() {
        return "oferta";
    }

    @GetMapping("/kontakt")
    public String kontakt() {
        return "kontakt";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }



}
