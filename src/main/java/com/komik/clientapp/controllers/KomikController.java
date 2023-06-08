package com.komik.clientapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.komik.clientapp.models.Komik;
import com.komik.clientapp.services.KomikService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/komik")
@AllArgsConstructor
public class KomikController {
    private KomikService komikService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("komiks", komikService.getAll());
        return "komik/index";
    }

    @GetMapping("/create")
    public String create(Komik komik) {
        return "komik/create-form";
    }
}
