package ua.com.hotsport.dto;

import java.util.ArrayList;
import java.util.List;

import ua.com.hotsport.entity.Category;
import ua.com.hotsport.entity.Country;
import ua.com.hotsport.entity.News;
import ua.com.hotsport.entity.Player;
import ua.com.hotsport.entity.Team;
import ua.com.hotsport.entity.User;

public class DtoUtilMapper {

	public static List<PlayerDTO> playersToPlayersDTO(List<Player> players) {

		List<PlayerDTO> playerDTOs = new ArrayList<PlayerDTO>();

		for (Player player : players) {
			PlayerDTO playerDTO = new PlayerDTO();

			playerDTO.setName(player.getName());
			playerDTO.setSurname(player.getSurname());

			playerDTOs.add(playerDTO);

		}

		return playerDTOs;

	}

	public static List<CountryDTO> countriesToCountriesDTO(List<Country> countries) {

		List<CountryDTO> countryDTOs = new ArrayList<CountryDTO>();

		for (Country country : countries) {
			countryDTOs.add(new CountryDTO(country.getId(), country.getName()));
		}
		return countryDTOs;

	}

	public static List<TeamDTO> teamsToTeamsDTO(List<Team> teams) {

		List<TeamDTO> teamDTOs = new ArrayList<TeamDTO>();

		for (Team team : teams) {
			teamDTOs.add(new TeamDTO(team.getId(), team.getTitle()));
		}
		return teamDTOs;

	}

	public static List<UserDTO> usersToUsersDTO(List<User> users) {

		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (User user : users) {
			userDTOs.add(new UserDTO(user.getId(), user.getName(), user.getEmail()));
		}
		return userDTOs;

	}

	public static List<CategoryDTO> categoriesToCategoriesDTO(List<Category> categories) {

		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();

		for (Category category : categories) {
			CategoryDTO categoryDTO = new CategoryDTO();

			categoryDTO.setName(category.getTitle());

			categoryDTOs.add(categoryDTO);

		}

		return categoryDTOs;

	}
	
	
	public static List<NewsDTO> newsToNewsDTO(List<News> newss) {

		List<NewsDTO> newsDTOs = new ArrayList<NewsDTO>();

		for (News news : newss) {
			newsDTOs.add(new NewsDTO(news.getId(), news.getTitle(), news.getShortStory(), news.getFullStory(), news.getDateofPublic()));
		}
		return newsDTOs;

	}
	
	
	

}
