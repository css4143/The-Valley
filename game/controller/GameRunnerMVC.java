package game.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.model.*;
import game.view.*;

/**
 * This class starts and runs the game.
 * 
 * @author Connor Seiden
 *
 */
public class GameRunnerMVC {
	
	private List<StartEvent> triggeredEvents;
	private List<StartEvent> randomEvents;
	private StartEvent defaultEvent;
	private Player player;
	GameUI view;
	
	
	public GameRunnerMVC(){
		player = new Player("Test Man", 20, 50, 50 , 50, false);
		defaultEvent = EventBuilder.makeDefaultEvent();
		
		triggeredEvents = EventBuilder.buildTriggeredEvents();
		randomEvents = EventBuilder.buildRandomEvents();
		view = null;
	}
	
	public void begin(){
		view = new GameUI(this);
		view.setVisible(true);
		beginNewEvent();
	}
	
	private void beginNewEvent(){
		boolean eventOccurred = false;
		
		//check for triggered event
		if(triggeredEvents != null){
			for(int i=0;i<triggeredEvents.size();i++){
				if(triggeredEvents.get(i).getTrigger() == null || (triggeredEvents.get(i).getTrigger() 
						!= null && triggeredEvents.get(i).getTrigger().check(player))){
					runStartEvent(triggeredEvents.get(i), player);
					triggeredEvents.remove(i);
					eventOccurred = true;
					break;
				}
			}
			if(eventOccurred){ return; }
		}
		
		//check for random event, 25% chance of occurring
		if(randomEvents != null && randomEvents.size() != 0){
			if(Math.random() <= 0.25){
				Random r = new Random();
				int i = r.nextInt(randomEvents.size());
				if(randomEvents.get(i).getPrerequisite() == null || (randomEvents.get(i).getPrerequisite() 
						!= null && randomEvents.get(i).getPrerequisite().check(player))){
					runStartEvent(randomEvents.get(i), player);
					randomEvents.remove(i);
					return;
				}
			}
		}
		
		//If neither a random nor triggered event occurred, execute default event
		runStartEvent(defaultEvent, player);
	}
	
	
	private void runStartEvent(StartEvent event, Player player){
		//It is horse shit that OR statements don't short circuit here.
		if(event.getPrerequisite() == null || (event.getPrerequisite() != null 
				&& event.getPrerequisite().check(player))){
			runEvent(event, player);
		}
	}
	
	private void runEvent(SubEvent event, Player player){
		ArrayList<Option> availableOptions = new ArrayList<Option>();
		for(Option option: event.getOptions()){
			if(option.getPrerequisite() == null || (option.getPrerequisite() 
					!= null && option.getPrerequisite().check(player))){
				availableOptions.add(option);
			}
		}
		
		view.runEvent(event.getDescription(), availableOptions, player);
	}
	
	public void evaluateOption(Option option, Player player){
		player.setHealth(player.getHealth()+ option.getHealthMod());
		player.setMoney(player.getMoney()+ option.getMoneyMod());
		player.setSatisfaction(player.getSatisfaction()+ option.getSatisfactionMod());
		if(option.getJobMod() == 1){
			player.setJob(false);
		}
		else if(option.getJobMod() == 2){
			player.setJob(true);
		}
		
		if(option.getEndGame()){
			System.exit(0);
		}
		
		//run the sub event, if there is one.
		if(option.getSubEvent() != null){
			runEvent(option.getSubEvent(), player);
		}
		else{
			beginNewEvent();
		}
	}
	
	
}
