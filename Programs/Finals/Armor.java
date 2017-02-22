public class Armor extends Item{

	public Armor(String name, int defenseValue){
		super(name, defenseValue, false);
	}
	
	@Override
	public void use(){
		owner.setArmor(this);
	}
}