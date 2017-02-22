public class Weapon extends Item {
	
	public Weapon(String name, int attackValue){
		super(name, attackValue, false);
	}
	
	public int getAttackValue(){
		return super.getValue();
	}
	
	@Override
	public void use(){
		owner.setWeapon(this);
	}
}
