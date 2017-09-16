package game.controller;

import java.util.ArrayList;
import java.util.List;
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

	public static List<StartEvent> buildEvents(){
		List<StartEvent> events = new ArrayList<StartEvent>();
		events.add(makeMainEvent());
		
		return events;
	}
	
	private static StartEvent makeMainEvent(){
		
		Option cont = new Option(null, "OK", 0, 0, 0, null);
		List<Option> confirm = new ArrayList<Option>();
		confirm.add(cont);
		
		List<Option> options = new ArrayList<Option>();
		StartEvent t = new StartEvent();
		t.setDescription("What do you do today?");
		
		List<Option> subOptions = new ArrayList<Option>();
		
		options.add(new Option(null, "Get Healthy", 1, 0, 0,
				new SubEvent("You drink apple cider vinegar (Health +1)", confirm)));
		options.add(new Option(null, "Get Money", 0, 1, 0,
				new SubEvent("You get mad dosh (Money +1)", confirm)));
		options.add(new Option(null, "Get Satisfied", 0, 0, 1,
				new SubEvent("You satisfy yourself (Satisfaction +1)", confirm)));
		
		SubEvent t1 = new SubEvent();
		t1.setDescription("While buying your taco, a dog asks for a bite.  What do?");
		
		subOptions.add(new Option(null, "Give him a bite", -1, 0, 1, 
				new SubEvent("You helped a dog, you feel better about "
						+ "yourself, but now you're hungry (Satisfaction +1, Health -1)", confirm)));
		
		subOptions.add(new Option(null, "Don't give him a bite", 1, 0, -1,
				new SubEvent("You feel bad about not helping the dog, "
						+ "but it was a good taco (Satisfaction -1, Health +1)", confirm)));
		
		t1.setOptions(subOptions);
		options.add(new Option(null, "Buy a taco", 0, 1, 0, t1));
		
		t.setOptions(options);
		t.setPrerequisite(new Requirement(50, 0, 50, null));
		return t;
	}
	
}
