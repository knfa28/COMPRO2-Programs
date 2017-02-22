public class Medicine extends ConsumableItem{

	public Medicine(String name, int mpValue){
		super(name, mpValue);
	}
	
	@Override
	public void use() {
		owner.increaseMP(getValue());
	}
}