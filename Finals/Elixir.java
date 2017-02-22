public class Elixir extends ConsumableItem{

	public Elixir(String name, int gainValue){
		super(name, gainValue);
	}

	@Override
	public void use(){
		owner.increaseMP(getValue());
		owner.increaseMP(getValue());
	}
}