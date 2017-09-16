package game.model;

import java.util.List;

/**
 * This class represents an event 
 * 
 * @author Connor Seiden
 *
 */
public class StartEvent extends SubEvent {
	
	private Requirement trigger;
	private Requirement prerequisite;
	
	public StartEvent(){
		super();
	}

	public StartEvent(String description, List<Option> choices,
			Requirement trigger, Requirement prerequisite) {
		super(description, choices);
		this.trigger = trigger;
		this.prerequisite = prerequisite;
	}

	public Requirement getTrigger() {
		return trigger;
	}
	public void setTrigger(Requirement trigger) {
		this.trigger = trigger;
	}
	public Requirement getPrerequisite() {
		return prerequisite;
	}
	public void setPrerequisite(Requirement prerequisite) {
		this.prerequisite = prerequisite;
	}

}
