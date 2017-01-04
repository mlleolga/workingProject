package ua.com.hotsport.controller;

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

import ua.com.hotsport.editor.CountryEditor;
import ua.com.hotsport.editor.PlayerEditor;
import ua.com.hotsport.entity.Country;
import ua.com.hotsport.entity.Player;
import ua.com.hotsport.entity.Team;
import ua.com.hotsport.service.CountryService;
import ua.com.hotsport.service.PlayerService;
import ua.com.hotsport.service.TeamService;
import ua.com.hotsport.dto.DtoUtilMapper;


@Controller
public class TeamController {
	@Autowired
	private TeamService teamService;
	@Autowired
	private PlayerService playerService;
	@Autowired
	private CountryService countryService;

	@InitBinder
		public void InitBinder(WebDataBinder binder){
			binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
			binder.registerCustomEditor(Player.class, new PlayerEditor(playerService));
	}
	
	
	
	
	@RequestMapping(value = "newTeam", method = RequestMethod.GET)
	public String newTeam(Model model) {
		model.addAttribute("teams", teamService.findTeamWithPlayers());
		model.addAttribute("teamNew", new Team());
		model.addAttribute("teamsCountry", teamService.findAll());
		
	/*	model.addAttribute("countries", countryService.findAll());*/
		model.addAttribute("countriesDTOs", DtoUtilMapper.countriesToCountriesDTO(countryService.findAll()));
		
		model.addAttribute("teams1", teamService.findTeam1WithNews());
		model.addAttribute("teams2", teamService.findTeam2WithNews());
		
	
		return "views-admin-newTeam";
	}

	@RequestMapping(value = "/saveTeam", method = RequestMethod.POST)
	public String saveTeam(@ModelAttribute Team teamNew) {
		teamService.add(teamNew);
		return "redirect:/newTeam";

	}

	@RequestMapping(value = "/deleteTeam/{id}", method = RequestMethod.GET)
	public String newTeam(@PathVariable String id) {
		teamService.delete(Integer.parseInt(id));
		return "redirect:/newTeam";

	}

	@RequestMapping(value = "/deleteNewsFromTeam1/{idNews}")
	public String deleteNewsFromTeam1(@PathVariable String idNews) {
			
		teamService. deleteNewsFromTeam1(Integer.parseInt(idNews));
		return "redirect:/newTeam";
	}
	@RequestMapping(value = "/deleteNewsFromTeam2/{idNews}")
	public String deleteNewsFromTeam2(@PathVariable String idNews) {
			
		teamService. deleteNewsFromTeam2(Integer.parseInt(idNews));
		return "redirect:/newTeam";
	}
	
	@RequestMapping(value = "/deletePlayerFromTeam/{idPlayer}")
	public String deletePlayerFromTeam(@PathVariable String idPlayer) {
			
		teamService.deletePlayerFromTeam(Integer.parseInt(idPlayer));
		return "redirect:/newTeam";
	}
	
}
