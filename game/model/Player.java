package game.model;

import java.util.HashMap;
import java.util.Map;

public class Player {
	
	private String name;
	private int age;
	private int money;
	private int satisfaction;
	private int health;
	private Map<String, String> choices;
	
	public Player(String name, int age, int money, int satisfaction, int health){
		this.name = name;
		this.age = age;
		this.money = money;
		this.satisfaction = satisfaction;
		this.health = health;
		this.choices = new HashMap<String, String>();
	}
	
	public String getChoice(String key) {
		return choices.get(key);
	}
	public void addChoice(String key, String choice){
		choices.put(key, choice);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}
