
public abstract class Item implements Usable {
	protected String name;
	protected boolean isConsumable;
	protected Hero owner;
	protected int value;
	
	public Item(String name, int value, boolean isConsumable){
		this.name = name;
		this.value = value;
		this.isConsumable = isConsumable;
	}

	public void setOwner(Hero owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public boolean isConsumable() {
		return isConsumable;
	}

	public int getValue() {
		return value;
	}
	
	public abstract void use();
	
}
