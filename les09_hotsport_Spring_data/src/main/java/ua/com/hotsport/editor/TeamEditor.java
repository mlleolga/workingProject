package ua.com.hotsport.editor;

import java.beans.PropertyEditorSupport;

import ua.com.hotsport.service.TeamService;

public class TeamEditor extends PropertyEditorSupport{
	private final TeamService teamService;
	
	public TeamEditor(TeamService teamService){
		this.teamService = teamService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(teamService.findOne(Integer.parseInt(text)));
	}
	
	
}
