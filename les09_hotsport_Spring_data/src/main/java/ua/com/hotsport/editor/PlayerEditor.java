package ua.com.hotsport.editor;

import java.beans.PropertyEditorSupport;

import ua.com.hotsport.service.PlayerService;

public class PlayerEditor extends PropertyEditorSupport{
	private final PlayerService playerService;
	
	public PlayerEditor(PlayerService playerService){
		this.playerService=playerService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(playerService.findOne(Integer.parseInt(text)));
	}
		
		
	}

