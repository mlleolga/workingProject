package ua.com.hotsport.dto;

public class PlayerDTO {
	
	
	private String name;
	private String surname;
	
	
	
	public PlayerDTO() {
	}
	
	public PlayerDTO(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "PlayerDTO [name=" + name + ", surname=" + surname + "]";
	}
	
	
	
	
	
	

}
