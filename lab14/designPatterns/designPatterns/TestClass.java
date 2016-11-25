package designPatterns;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        
	        Character c1 = new King();
	        Character c2 = new Queen();
	        Character c3 = new Knight();
	        Character c4 = new Troll();
	        
	        c1.setWeaponBehavior(new KnifeBehavior());
	        c1.fight();
	        
	        c2.setWeaponBehavior(new BowAndArrowBehavior());
	        c2.fight();
	        
	        c3.setWeaponBehavior(new SwordBehavior());
	        c3.fight();
	        
	        c4.setWeaponBehavior(new AxeBehavior());
	        c4.fight();
	        c4.display();
	        
	        
	        
	    }
	}

