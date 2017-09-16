package game.controller;

import java.util.ArrayList;
import java.util.List;

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
		Player player = new Player("Test Man", 20, 100, 100 , 100);
		List<StartEvent> events = EventBuilder.buildEvents();
		
		View view = null;	//Need to actually instantiate this when Holly makes it.
		
//		//////////////////////////////////////
//		view = new TestUI();
//		runStartEvent(events.get(0), player, view);
//		System.out.println("Game Over");
//		return;
//		/////////////////////////////////////
		
		while(true){
			//check for triggered events
			
			//
			runStartEvent(events.get(0), player, view);
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
		
		//run the sub event, if there is one.
		if(availableOptions.get(selected).getSubEvent() != null){
			runEvent(availableOptions.get(selected).getSubEvent(), player, view);
		}
	}
	
	
}
