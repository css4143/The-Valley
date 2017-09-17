package game.model;

import java.util.ArrayList;
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
		if(options != null && options.size() > 0){
			return options;
		}
		
		List<Option> defaultOption = new ArrayList<Option>();
		defaultOption.add(new Option(null, "OK", 0, 0, 0, 0, null));
		return defaultOption;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}

}
