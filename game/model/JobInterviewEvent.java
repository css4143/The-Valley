package game.model;

import java.util.ArrayList;
import java.util.List;

public class JobInterviewEvent extends SubEvent {
	
private List<Option> interview; 
	
	public JobInterviewEvent(String description, List<Option> options){
		super(description, null);
		this.interview = options;
	}
	
	public List<Option> getOptions() {
		List<Option> options = new ArrayList<Option>();
		
		if(Math.random() <= 0.66){
			options.add(interview.get(0));
			this.setDescription("You got an interview!");
		}
		else{
			options.add(interview.get(1));
			this.setDescription("No luck, you got ignored.");
		}
		
		return options;
	}

}
