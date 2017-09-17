package game.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
	
	private String name;
	private int age;
	private int money;
	private int satisfaction;
	private int health;
	private Map<String, String> choices;
	private List<String> skills;
	private boolean job;
	
	public Player(){ }
	
	public Player(String name, int age, int money, int satisfaction, int health, boolean job){
		this.name = name;
		this.age = age;
		this.money = money;
		this.satisfaction = satisfaction;
		this.health = health;
		this.choices = new HashMap<String, String>();
		this.skills = new ArrayList<String>();
		this.job = job;
	}
	
	public String getChoice(String key) {
		return choices.get(key);
	}
	public void addChoice(String key, String choice){
		choices.put(key, choice);
	}
	
	public List<String> getSkills(){
		return skills;
	}
	public void setSkills(List<String> skills){
		this.skills = skills;
	}

	public boolean getJob() {
		return job;
	}
	public void setJob(boolean job) {
		this.job = job;
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
