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

import ua.com.hotsport.editor.PlayerEditor;
import ua.com.hotsport.editor.TeamEditor;
import ua.com.hotsport.entity.Player;
import ua.com.hotsport.entity.Team;
import ua.com.hotsport.service.PlayerService;
import ua.com.hotsport.service.TeamService;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	@Autowired
	private TeamService teamService;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Team.class, new TeamEditor(teamService));
	}

	@RequestMapping(value = "/newPlayer", method = RequestMethod.GET)
	public String newPlayer(Model model) {

		model.addAttribute("players", playerService.findAll());
		model.addAttribute("playerin", new Player());
				
		model.addAttribute("teams", teamService.findAll());

		return "views-admin-newPlayer";
	}

	@RequestMapping(value = "/savePlayer", method = RequestMethod.POST)
	public String savePlayer(@ModelAttribute Player playerin) {
		System.out.println("the save player");
		playerService.add(playerin);

		return "redirect:/newPlayer";
	}

	@RequestMapping(value = "/deletePlayer/{id}", method = RequestMethod.GET)
	public String newPlayer(@PathVariable String id) {

		playerService.delete(Integer.parseInt(id));

		return "redirect:/newPlayer";
	}

}
