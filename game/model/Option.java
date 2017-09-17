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
	//jobMod is 0 for no change, 1 for no job, and 2 for job
	private int jobMod;
	private SubEvent subEvent;
	private boolean endGame;
	
	public Option(Requirement prerequisite, String description, int healthMod,
			int moneyMod, int satisfactionMod, int jobMod, SubEvent subEvent) {
		super();
		this.prerequisite = prerequisite;
		this.description = description;
		this.healthMod = healthMod;
		this.moneyMod = moneyMod;
		this.satisfactionMod = satisfactionMod;
		this.subEvent = subEvent;
		endGame = false;
	}
	
	public Requirement getPrerequisite() {
		return prerequisite;
	}
	public void setPrerequisite(Requirement prerequisite) {
		this.prerequisite = prerequisite;
	}
	public int getJobMod() {
		return jobMod;
	}
	public void setJobMod(int jobMod) {
		this.jobMod = jobMod;
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
	public boolean getEndGame(){
		return this.endGame;
	}
	public void setEndGame(boolean endGame){
		this.endGame = endGame;
	}
	
}
