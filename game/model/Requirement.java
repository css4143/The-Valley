package game.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a requirement within an event or a choice.  Its 
 * conditions must be met for the event to be triggered, or for the event to
 * occur once its been triggered, or for an option to appear.
 * 
 * healthReq, moneyReq, and satisfactionReq should be 0 if they do not have an
 * associated requisite.  If they are a positive number, then that means that
 * the requirement is greater than that number.  If they are a negative number, it
 * means that the requirement is less than the absolute value of that number.
 * 
 * @author Connor Seiden
 *
 */
public class Requirement {
	
	//healthReq, moneyReq, and satisfactionReq should be 0 if they do not
	//have an associated requisite.  If they are a positive number, then that means that t  
	//choiceReq will be null if it has no associated requisite.
	
	private int healthReq;
	private int moneyReq;
	private int satisfactionReq;
	//job req is 0 for doesn't matter, 1 for no job, and 2 for job
	private int jobReq;
	//A list of String arrays (all size 2) that represent previous choices
	//that can be referenced in the player choices dictionary.
	private List<String[]> choiceReq;

	//daysReq is 0 for doesn't matter, 1 for odd days, and 2 for even days
	private int daysReq;
	
	public Requirement(){
		this.healthReq = 0;
		this.moneyReq = 0;
		this.satisfactionReq = 0;
		this.jobReq = 0;
		this.choiceReq = new ArrayList<String[]>();
		this.daysReq = 2;
	}
	
	public Requirement(int healthReq, int moneyReq, int satisfactionReq,
			int jobReq, List<String[]> choiceReq, int daysReq) {
		this.healthReq = healthReq;
		this.moneyReq = moneyReq;
		this.satisfactionReq = satisfactionReq;
		this.jobReq = jobReq;
		this.choiceReq = choiceReq;
		this.daysReq = daysReq;
	}
	
	public int getJobReq() {
		return jobReq;
	}
	public void setJobReq(int jobReq) {
		this.jobReq = jobReq;
	}
	public int gethealthReq() {
		return healthReq;
	}
	public void sethealthReq(int healthReq) {
		this.healthReq = healthReq;
	}
	public int getMoneyReq() {
		return moneyReq;
	}
	public void setMoneyReq(int moneyReq) {
		this.moneyReq = moneyReq;
	}
	public int getSatisfactionReq() {
		return satisfactionReq;
	}
	public void setSatisfactionReq(int satisfactionReq) {
		this.satisfactionReq = satisfactionReq;
	}
	public List<String[]> getChoiceReq() {
		return choiceReq;
	}
	public void setChoiceReq(List<String[]> choiceReq) {
		this.choiceReq = choiceReq;
	}

	public int getDaysReq() { return daysReq; }
	public void setDaysReq(int daysReq) { this.daysReq = daysReq; }
	
	//Returns true if requirement is met, false otherwise.
	public boolean check(Player player){
		boolean met = (reqCheck(player.getHealth(), healthReq) && 
				reqCheck(player.getMoney(), moneyReq) && 
				reqCheck(player.getSatisfaction(), satisfactionReq));
		
		if((jobReq == 1 && player.getJob()) || (jobReq == 2 && !player.getJob())){
			met = false;
		}
		
		if(choiceReq != null){
			for(String[] choice: choiceReq){
				if(!choice[1].equals(player.getChoice(choice[0]))){
					met = false;
				}
			}
		}
		
		return met;
	}
	
	private boolean reqCheck(int base, int req){
		if(req == 0){
			return true;
		}
		
		if(req > 0 && base >= req){
			return true;
		}
		else if(req < 0 && base <= Math.abs(req)){
			return true;
		}
		return false;
	}
}
