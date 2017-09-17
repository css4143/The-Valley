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
public class GameRunner {
	
	public static void main(String[] args){
		Player player = new Player("Test Man", 20, 50, 50 , 50, false);
		StartEvent defaultEvent = EventBuilder.makeDefaultEvent();
		
		List<StartEvent> triggeredEvents = EventBuilder.buildTriggeredEvents();
		List<StartEvent> randomEvents = EventBuilder.buildRandomEvents();
		
		View view = null;	//Need to actually instantiate this when Holly makes it.
		
//		//////////////////////////////////////
		view = new TestUI();
//		runStartEvent(events.get(0), player, view);
//		System.out.println("Game Over");
//		return;
//		/////////////////////////////////////
		
		while(true){
			
			System.out.println("Satisfaction: "+player.getSatisfaction());
			
			boolean eventOccurred = false;
			
			//check for triggered event
			if(triggeredEvents != null){
				for(int i=0;i<triggeredEvents.size();i++){
					if(triggeredEvents.get(i).getTrigger() == null || (triggeredEvents.get(i).getTrigger() 
							!= null && triggeredEvents.get(i).getTrigger().check(player))){
						runStartEvent(triggeredEvents.get(i), player, view);
						triggeredEvents.remove(i);
						eventOccurred = true;
						break;
					}
				}
				if(eventOccurred){ continue; }
			}
			
			//check for random event, 25% chance of occurring
			if(randomEvents != null){
				if(Math.random() <= 0.25){
					Random r = new Random();
					int i = r.nextInt(randomEvents.size());
					if(randomEvents.get(i).getPrerequisite() == null || (randomEvents.get(i).getPrerequisite() 
							!= null && randomEvents.get(i).getPrerequisite().check(player))){
						runStartEvent(randomEvents.get(i), player, view);
						randomEvents.remove(i);
						continue;
					}
				}
			}
			
			//If neither a random nor triggered event occurred, execute default event
			runStartEvent(defaultEvent, player, view);
		}
	}
	
	private static void runStartEvent(StartEvent event, Player player, View view){
		//It is horse shit that OR statements don't short circuit here.
		if(event.getPrerequisite() == null || (event.getPrerequisite() != null 
				&& event.getPrerequisite().check(player))){
			runEvent(event, player, view);
		}
	}
	
	private static void runEvent(SubEvent event, Player player, View view){
		ArrayList<Option> availableOptions = new ArrayList<Option>();
		ArrayList<String> optionDescriptions = new ArrayList<String>();
		for(Option option: event.getOptions()){
			if(option.getPrerequisite() == null || (option.getPrerequisite() 
					!= null && option.getPrerequisite().check(player))){
				availableOptions.add(option);
				optionDescriptions.add(option.getDescription());
			}
		}
		int selected = view.runEvent(event.getDescription(), optionDescriptions,
				player.getHealth(), player.getMoney(), player.getSatisfaction());
		
		//Apply any stat changes from the choice
		player.setHealth(player.getHealth()+ availableOptions.get(selected).getHealthMod());
		player.setMoney(player.getMoney()+ availableOptions.get(selected).getMoneyMod());
		player.setSatisfaction(player.getSatisfaction()+ availableOptions.
				get(selected).getSatisfactionMod());
		if(availableOptions.get(selected).getJobMod() == 1){
			player.setJob(false);
		}
		else if(availableOptions.get(selected).getJobMod() == 2){
			player.setJob(true);
		}
		
		if(availableOptions.get(selected).getEndGame()){
			System.exit(0);
		}
		
		//run the sub event, if there is one.
		if(availableOptions.get(selected).getSubEvent() != null){
			runEvent(availableOptions.get(selected).getSubEvent(), player, view);
		}
	}
	
	
}
