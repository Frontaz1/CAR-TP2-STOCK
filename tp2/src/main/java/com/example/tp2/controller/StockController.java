package com.example.tp2.controller;

import com.example.tp2.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stock")
    public ModelAndView  voirStock(Model model) {
        //model.addAttribute("lignes", stockService.getAllStock());
        return new ModelAndView("stock", Map.of( "lignes", stockService.getAllStock()));

    }

    @PostMapping("/stock/reappro")
    public String reapprovisionner() {
        stockService.addStock();
        return "redirect:/stock";
    }
}