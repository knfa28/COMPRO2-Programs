public class Food extends ConsumableItem{

	public Food(String name, int healValue){
		super(name, healValue);
	}
	
	@Override
	public void use() {
		owner.increaseHP(getValue());
	}
}