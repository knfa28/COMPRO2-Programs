import java.util.*;

public class Hero {
	
	private String name;
	private int currHP;
	private int currMP;
	
	private List<Item> bagOfItems;
	private Weapon equippedWeapon;
	private Armor equippedArmor;
	
	private int maxHP;
	private int maxMP;
	

	public Hero(String name, int maxHP, int maxMP){
		this.name = name;
		this.maxHP = maxHP;
		this.maxMP = maxMP;
		this.currHP = maxHP;
		this.currMP = maxMP;
		this.bagOfItems = new ArrayList<Item>();
	}

	public String getName(){
		return name;
	}

	public void setArmor(Armor armor){
		this.equippedArmor = armor;
	}
	
	public Armor getArmor(){
		return equippedArmor;
	}
	
	
	public void setWeapon(Weapon weapon){
		this.equippedWeapon = weapon;
	}

	public void increaseHP(int regenVal){
		currHP += regenVal;
	}

	public void reduceHP(int damageValue){
		currHP -= damageValue;
	}
	
	public int getCurrHP() {
		return currHP;
	}

	public void increaseMP(int regenVal){
		currMP += regenVal;
	}
	
	public void reduceMP(int manaPoints){
		currMP -= manaPoints;
	}
	
	public int getCurrMP() {
		return currMP;
	}

	public void addItem(Item newItem){
		newItem.setOwner(this);
		bagOfItems.add(newItem);
	}
	
	public void displayAllItems(){
		System.out.println("Items of "+name);
		for(int i=0; i<bagOfItems.size(); i++){
			Item currItem = bagOfItems.get(i);
			System.out.println("["+i+"]"+currItem.getName());
		}
		System.out.println();
	}
	
	public void useItem(int itemIndex){
		
		bagOfItems.get(itemIndex).use();
		
		if(bagOfItems.get(itemIndex).isConsumable()){
		    System.out.println(name + " used " + bagOfItems.get(itemIndex).getName());
			bagOfItems.remove(itemIndex);
		}
	}
	
	public void attack(Hero enemy){
		if(enemy.isAlive()){
			int damage = equippedWeapon.getValue() - enemy.getArmor().getValue();
			enemy.reduceHP(damage);
			System.out.println(name + " attacks " + enemy.getName());
		}
	}
	
	public boolean isAlive(){
		if(currHP > 0)
			return true;
		else
			return false;
	}
	
	public String toString(){
		return "Name: "+name+", HP: "+currHP+"/"+maxHP+", MP: "+currMP+"/"+maxMP+", Weapon: "+equippedWeapon.getName()+", Armor: "+equippedArmor.getName();
	}	
}
