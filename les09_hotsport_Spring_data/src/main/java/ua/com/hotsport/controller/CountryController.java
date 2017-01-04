package ua.com.hotsport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.hotsport.editor.TeamEditor;
import ua.com.hotsport.entity.Country;
import ua.com.hotsport.entity.Team;
import ua.com.hotsport.service.CountryService;
import ua.com.hotsport.service.TeamService;



@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;
	@Autowired
	private TeamService teamService;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Team.class, new TeamEditor(teamService));
	}
	
	@RequestMapping(value = "/newCountry", method = RequestMethod.GET)
	public String newCountry(Model model) {
		model.addAttribute("countries", countryService.findCountryWithTeam());
		model.addAttribute("country", new Country());
		return "views-admin-newCountry";
	}
	
	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public String saveCountry(@ModelAttribute Country country) {
		countryService.add(country);
		
		return "redirect:/newCountry";
	}	
	
	@RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.GET)
	public String newCountry(@PathVariable int id) {
		
		countryService.delete(id);
		
		return "redirect:/newCountry";
	}
	
	@RequestMapping (value="/deleteTeamFromCountry/{idTeam}")
	public String deleteTeamFromCountry(@PathVariable String idTeam){
		countryService.deleteTeamFromCountry(Integer.parseInt(idTeam));
		return "redirect:/newCountry";
	}
	
}
