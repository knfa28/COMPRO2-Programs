
public class Driver {
	public static void main(String[] args){
		Hero myHero = new Hero("Cloud", 100, 100);
		Hero enemyHero = new Hero("Sepiroth", 100, 100);
		
		// Items of myHero
		Weapon busterSword = new Weapon("Buster Sword", 25);
		Weapon shamshir = new Weapon("Shamshir", 20);

		Armor vest = new Armor("Vest", 5);
		Armor leatherJacket = new Armor("Leather Jacket", 5);
		
		ConsumableItem pie = new Food("Pie", 40);
		ConsumableItem cake = new Food("Cake", 60);
		ConsumableItem bacsi = new Food("Bacsi", 90);
		
		myHero.addItem(busterSword);
		myHero.addItem(shamshir);
		myHero.addItem(vest);
		myHero.addItem(leatherJacket);
		myHero.addItem(pie);
		myHero.addItem(cake);
		myHero.addItem(bacsi);
		// end of Items of myHero
		
		// Items of enemyHero
		Weapon masamune = new Weapon("Masamune", 30);
		Weapon katana = new Weapon("Katana", 25);

		Armor robe = new Armor("Robe", 10);

		enemyHero.addItem(masamune);
		enemyHero.addItem(katana);
		enemyHero.addItem(robe);
		// end of Items of enemyHero
		
		myHero.displayAllItems();
		
		// equip myHero with the busterSword and vest
		myHero.useItem(0);
		myHero.useItem(2);
		
		enemyHero.displayAllItems();
		
		// equip enemyHero with the masamune and robe
		enemyHero.useItem(0);
		enemyHero.useItem(2);
			
		// print details of hero and enemy
		System.out.println(myHero.toString());
		System.out.println(enemyHero.toString()+"\n");

		// START BATTLE
		myHero.attack(enemyHero);
		enemyHero.attack(myHero);
		
		// print details of hero and enemy
		System.out.println("\n"+myHero.toString());
		System.out.println(enemyHero.toString()+"\n");
		
		myHero.attack(enemyHero);
		enemyHero.attack(myHero);
				
		// print details of hero and enemy
		System.out.println("\n"+myHero.toString());
		System.out.println(enemyHero.toString()+"\n");
		
		myHero.displayAllItems();
		myHero.useItem(4); // use pie
		enemyHero.attack(myHero);
		
		// print details of hero and enemy
		System.out.println("\n"+myHero.toString());
		System.out.println(enemyHero.toString()+"\n");
		
		myHero.attack(enemyHero);
		enemyHero.attack(myHero);
				
		// print details of hero and enemy
		System.out.println("\n"+myHero.toString());
		System.out.println(enemyHero.toString()+"\n");
		
		myHero.attack(enemyHero);
		enemyHero.attack(myHero);
				
		// print details of hero and enemy
		System.out.println("\n"+myHero.toString());
		System.out.println(enemyHero.toString()+"\n");
		
		myHero.displayAllItems();
		myHero.useItem(4); // use cake
		enemyHero.attack(myHero);
		
		// print details of hero and enemy
		System.out.println("\n"+myHero.toString());
		System.out.println(enemyHero.toString()+"\n");
		
		myHero.attack(enemyHero);
		enemyHero.attack(myHero);
				
		// print details of hero and enemy
		System.out.println("\n"+myHero.toString());
		System.out.println(enemyHero.toString()+"\n");
		
		myHero.attack(enemyHero);
		enemyHero.attack(myHero);
				
		// print details of hero and enemy
		System.out.println("\n"+myHero.toString());
		System.out.println(enemyHero.toString()+"\n");
		
	}
}
