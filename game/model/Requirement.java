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
	//A list of String arrays (all size 2) that represent previous choices
	//that can be referenced in the player choices dictionary.
	private List<String[]> choiceReq;
	
	public Requirement(){
		this.healthReq = 0;
		this.moneyReq = 0;
		this.satisfactionReq = 0;
		this.choiceReq = new ArrayList<String[]>();
	}
	
	public Requirement(int healthReq, int moneyReq, int satisfactionReq, List<String[]> choiceReq) {
		this.healthReq = healthReq;
		this.moneyReq = moneyReq;
		this.satisfactionReq = satisfactionReq;
		this.choiceReq = choiceReq;
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
	
	//Returns true if requirement is met, false otherwise.
	public boolean check(Player player){
		System.out.println(healthReq + "  "+moneyReq+"  "+satisfactionReq);
		System.out.println(player.getHealth()+"  "+player.getMoney()+"  "+player.getSatisfaction());
		boolean met = (reqCheck(player.getHealth(), healthReq) && 
				reqCheck(player.getMoney(), moneyReq) && 
				reqCheck(player.getSatisfaction(), satisfactionReq));
		
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
