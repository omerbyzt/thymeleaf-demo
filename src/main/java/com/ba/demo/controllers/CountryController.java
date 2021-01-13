package com.ba.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Country;
import com.example.demo.repositories.CountryRepository;

@Controller
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping("/")
    public String showPage(@RequestParam(defaultValue="0") int page, Model model) {
        Pageable pageable=PageRequest.of(page, 4);
        model.addAttribute("data",countryRepository.findAll(pageable));
        model.addAttribute("currentPage", page);
        
        return "index";
    }
	
	@PostMapping("/save")
	public String save(Country c) {
		countryRepository.save(c);
		return "redirect:/";
	}
	
	@DeleteMapping("/delete")
	public String deleteCountry(Integer id) {
		countryRepository.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public Country findOne(Integer id) {
		Optional<Country> optional = countryRepository.findById(id);
		return optional.get();
	}
}
