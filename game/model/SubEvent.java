package game.model;

import java.util.List;

public class SubEvent {
	
	//The text that is displayed to the player on the main screen, describing
	//the events that are occurring.
	private String description;
	private List<Option> options;
	
	public SubEvent(){}
	
	public SubEvent(String description, List<Option> options) {
		this.description = description;
		this.options = options;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}

}
