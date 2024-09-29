package com.leadtech.lookbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leadtech.lookbook.model.ClothingItem;
import com.leadtech.lookbook.model.Lookbook;
import com.leadtech.lookbook.service.ClothingItemService;
import com.leadtech.lookbook.service.LookbookService;

import jakarta.validation.Valid;

@Controller
public class LookbookController {
	@Autowired
	private LookbookService lookbookService;
	@Autowired
	private ClothingItemService clothingItemService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/lookbooks")
	public ModelAndView listarLookbooks() {
		ModelAndView mv = new ModelAndView("lookbook/list");
		mv.addObject("lookbooks", lookbookService.listarTodos());
		return mv;
	}

	@GetMapping("/lookbooks/novo")
	public ModelAndView novoForm() {
		ModelAndView mv = new ModelAndView("lookbook/form");
		mv.addObject("lookbook", new Lookbook());
		mv.addObject("clothingItems", clothingItemService.listarTodos());
		return mv;
	}

	@PostMapping("/lookbooks")
	public String salvarLookbook(@Valid @ModelAttribute("lookbook") Lookbook lookbook, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			// Carregar a lista de clothingItems novamente, caso tenha erros, para exibir msg no forms
			List<ClothingItem> clothingItems = clothingItemService.listarTodos();
			model.addAttribute("clothingItems", clothingItems);

			return "lookbook/form";
		}

		// Caso não tenha erros salva o lookbook
		lookbookService.salvar(lookbook);

		return "redirect:/lookbooks"; 
	}

	@GetMapping("/lookbooks/editar/{id}")
	public ModelAndView editarForm(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("lookbook/form");
		mv.addObject("lookbook", lookbookService.buscarPorId(id));
		mv.addObject("clothingItems", clothingItemService.listarTodos());
		return mv;
	}

	@GetMapping("/lookbooks/deletar/{id}")
	public ModelAndView deletar(@PathVariable Long id) {
		lookbookService.deletar(id);
		return new ModelAndView("redirect:/lookbooks");
	}
	
	@GetMapping("/lookbooks/detalhes/{id}")
	public ModelAndView detalhesLookbook(@PathVariable Long id) {
	    Lookbook lookbook = lookbookService.buscarPorId(id);
	    ModelAndView mv = new ModelAndView("lookbook/details");
	    mv.addObject("lookbook", lookbook);
	    return mv;
	}

}
