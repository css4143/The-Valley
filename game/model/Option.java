package game.model;

/**
 * This class represents an option on the main screen.  When the player selects
 * it, then it defines what will happen.  It can affect a player stat, trigger
 * a sub-event, add a flag to the player-choices dictionary, or any combination
 * of these.  If the prerequisite is not null, then the Requirement must be met
 * in order for the Choice to appear.
 * 
 * @author Connor Seiden
 *
 */
public class Option {
	
	private Requirement prerequisite;
	private String description;
	private int healthMod;
	private int moneyMod;
	private int satisfactionMod;
	private SubEvent subEvent;
	
	public Option(Requirement prerequisite, String description, int healthMod, int moneyMod, int satisfactionMod,
			SubEvent subEvent) {
		super();
		this.prerequisite = prerequisite;
		this.description = description;
		this.healthMod = healthMod;
		this.moneyMod = moneyMod;
		this.satisfactionMod = satisfactionMod;
		this.subEvent = subEvent;
	}
	
	public Requirement getPrerequisite() {
		return prerequisite;
	}
	public void setPrerequisite(Requirement prerequisite) {
		this.prerequisite = prerequisite;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHealthMod() {
		return healthMod;
	}
	public void setHealthMod(int healthMod) {
		this.healthMod = healthMod;
	}
	public int getMoneyMod() {
		return moneyMod;
	}
	public void setMoneyMod(int moneyMod) {
		this.moneyMod = moneyMod;
	}
	public int getSatisfactionMod() {
		return satisfactionMod;
	}
	public void setSatisfactionMod(int satisfactionMod) {
		this.satisfactionMod = satisfactionMod;
	}
	public SubEvent getSubEvent() {
		return subEvent;
	}
	public void setSubEvent(SubEvent subEvent) {
		this.subEvent = subEvent;
	}
}
