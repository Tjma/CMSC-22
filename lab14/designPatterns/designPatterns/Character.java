package designPatterns;

public abstract class Character {
	private WeaponBehavior weaponBehavior;

	public WeaponBehavior getWeaponBehavior() {
		return weaponBehavior;
	}

	public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
		this.weaponBehavior = weaponBehavior;
	}
	
	public void fight(){
		weaponBehavior.useWeapon();
	}
	
	public abstract void display();
	
}