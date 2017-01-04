package ua.com.hotsport.editor;

import java.beans.PropertyEditorSupport;

import ua.com.hotsport.service.CountryService;

public class CountryEditor extends PropertyEditorSupport{
	private final CountryService countryService;
	
	public CountryEditor(CountryService countryService){
		this.countryService=countryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(countryService.findOne(Integer.parseInt(text)));
	}
	
	
}
