package game.view;

import java.util.List;

public interface View {
	
	public int runEvent(String description, List<String> options, int health, int money, int satisfaction);

}
