package game.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.model.*;

/**
 * This class is where all of the events of the game are defined and
 * constructed.  Ideally, these events would be defined in an XML file, but
 * this is faster and I'm making this at a hackathon.
 * 
 * @author Connor Seiden
 *
 */
public class EventBuilder {
	
	public static List<StartEvent> buildRandomEvents(){
		List<StartEvent> randomEvents = new ArrayList<StartEvent>();
		
		List<Option> confirm = new ArrayList<Option>();
		Option cont = new Option(null, "OK", 0, 0, 0, 0, null);
		confirm.add(cont);
		//
		// FINISH PUTTING THIS STUFF IN
		//
		StartEvent teslas3 = new StartEvent("You see two Teslas pull up to a charging station at the same time.  They drivers get out and argue with each other before fighting.  One of them looks like a little bitch and is getting his ass kicked.  What do you do?",
				confirm, null, null);
		
		List<Option> choices2 = new ArrayList<Option>();
		choices2.add(new Option(null, "Watch what happens.", 0, 0, 0, 0, teslas3));
		choices2.add(new Option(null, "Help the guy beating up Elon.", 0, 0, 10, 0, null));
		choices2.add(new Option(null, "I MUST SAVE ELON MUSK!", -15, 0, 0, 0, null));
		
		StartEvent teslas2 = new StartEvent("Upon closer inspection, the guy getting his ass kicked is Elon Musk.  What do you do?",
				choices2, null, null);
		
		List<Option> choices1 = new ArrayList<Option>();
		choices1.add(new Option(null, "Check it out", 0, 0, 0, 0, teslas2));
		choices1.add(new Option(null, "Fuck it, you've got places to be", 0, 0, 10, 0, null));
		
		StartEvent teslas1 = new StartEvent("You see two Teslas pull up to a charging station at the same time.  They drivers get out and argue with each other before fighting.  One of them looks like a little bitch and is getting his ass kicked.  What do you do?",
				choices1, null, null);
		
		
		randomEvents.add(teslas1);
		return randomEvents;
	}
	
	public static List<StartEvent> buildTriggeredEvents(){
		List<StartEvent> events = new ArrayList<StartEvent>();
		
		List<Option> confirm = new ArrayList<Option>();
		Option cont = new Option(null, "OK", 0, 0, 0, 0, null);
		confirm.add(cont);
		cont.setEndGame(true);
		
		StartEvent healthDeath = new StartEvent("You forgot to drink your apple cider "
				+ "vinegar and your health was too poor to fight off the toxins."
				+ "  You're Dead.  Game Over.", confirm, new Requirement(-1, 0, 0, 0, null), null);
		
		StartEvent moneyDeath = new StartEvent("No longer able to afford an apartment, "
				+ "you moved back in with your parents on the East Coast.  You got a job in the "
				+ "adjacent city. Without having to pay rent, you pay off your "
				+ "student loans with ease and live a pleasant life.  You Lose?", 
				confirm, new Requirement(0, -1, 0, 0, null), null);
		
		StartEvent satisfactionDeath = new StartEvent("You find no satisfaction in your life."
				+ "You realize that everything is meaningless and life has no point.  After "
				+ "coming out of your existentialist depression, you decide to wander the world."
				+ "  You're shot to death in Tibet 3 years later with no regrets. Game Over.", 
				confirm, new Requirement(0, 0, -1, 0, null), null);
		
		
		events.add(healthDeath);
		events.add(moneyDeath);
		events.add(satisfactionDeath);
		return events;
	}
	
	public static JobApplicationEvent makeJobApplicationEvent(){
		
		Option cont = new Option(null, "OK", 0, 0, 0, 0, null);
		List<Option> confirm = new ArrayList<Option>();
		confirm.add(cont);
		
		SubEvent intResult = new SubEvent("No luck, you didn't get the job.", confirm);
		
		List<Option> languages = new ArrayList<Option>();
		languages.add(new Option(null, "Java", 0, 0, 0, 0, intResult));
		languages.add(new Option(null, "C#", 0, 0, 0, 0, intResult));
		languages.add(new Option(null, "Python", 0, 0, 0, 0, intResult));
		languages.add(new Option(null, "Javascript", 0, 0, 0, 0, intResult));
		
		Random r = new Random();
		int i = r.nextInt(4);
		languages.get(i).setSubEvent(new SubEvent("You got the job!", confirm));
		languages.get(i).setJobMod(2);
		
		SubEvent interview = new SubEvent("At the interview, you are asked "
				+ "which language you are the most experienced with?", languages);
		
		List<Option> result = new ArrayList<Option>();
		
		result.add(new Option(null, "Go to interview.", 0, 0, 2, 0, interview));
		result.add(new Option(null, "OK", 0, 0, -5, 0, null));
		
		JobApplicationEvent step1 = new JobApplicationEvent("", result);
		
		return step1;
	}
	
	public static StartEvent makeDefaultEvent(){
		
		Option cont = new Option(null, "OK", 0, 0, 0, 0, null);
		List<Option> confirm = new ArrayList<Option>();
		confirm.add(cont);
		
		List<Option> options = new ArrayList<Option>();
		StartEvent t = new StartEvent();
		t.setDescription("What do you do today?");
		
		List<Option> subOptions = new ArrayList<Option>();
		
		options.add(new Option(null, "Apply to Jobs", 0, -5, 0, 0,
				makeJobApplicationEvent()));
		options.add(new Option(null, "Get Unhealthy", -20, 0, 0, 0,
				new SubEvent("You drink battery acid (Health -20)", confirm)));
		options.add(new Option(null, "Spend Money", 0, -20, 0, 0,
				new SubEvent("You throw money at dogs (Money -20)", confirm)));
		options.add(new Option(null, "Get Unsatisfied", 0, 0, -20, 0,
				new SubEvent("You can't get no satisfaction (Satisfaction -20)", confirm)));
		
		SubEvent t1 = new SubEvent();
		t1.setDescription("While buying your taco, a dog asks for a bite.  What do?");
		
		subOptions.add(new Option(null, "Give him a bite", -1, 0, 1, 0, 
				new SubEvent("You helped a dog, you feel better about "
						+ "yourself, but now you're hungry (Satisfaction +1, Health -1)", confirm)));
		
		subOptions.add(new Option(null, "Don't give him a bite", 1, 0, -1, 0,
				new SubEvent("You feel bad about not helping the dog, "
						+ "but it was a good taco (Satisfaction -1, Health +1)", confirm)));
		
		t1.setOptions(subOptions);
		options.add(new Option(null, "Buy a taco", 0, 1, 0, 0, t1));
		
		t.setOptions(options);
		t.setPrerequisite(new Requirement(0, 0, 0, 0, null));
		return t;
	}
}
