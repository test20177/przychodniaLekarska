package com.company.przychodnia.controller;

import com.company.przychodnia.domain.Wiadomosc;
import com.company.przychodnia.service.WiadomosciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        model.addAttribute("wiadomosci", wiadomosciService.pobierzOstatnieWiadomosci(3));
        return "index";
    }

    @GetMapping("/aktualnosci")
    public String aktualnosci(Model model) {
        model.addAttribute("wiadomosci", wiadomosciService.pobierzWszytkieWiadomosci());
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



}
