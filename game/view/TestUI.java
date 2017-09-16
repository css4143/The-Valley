package game.view;

import java.util.List;
import java.util.Scanner;

public class TestUI implements View {

	@Override
	public int runEvent(String description, List<String> options, int health,
			int money, int satisfaction) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n"+description);
		for(int i=0;i<options.size();i++){
			System.out.println("\t"+i+":"+options.get(i));
		}
		System.out.println("Enter number of choice: ");
		int input = scanner.nextInt();
		
		return input;
	}

}
