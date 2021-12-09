package model;

//Une arme : une arme apporte de la puissance

	public class Weapon {
	    protected String weaponName;
	    protected int power;
	
	public Weapon(String inputWeaponName, int inputPower){
	    this.weaponName = inputWeaponName;
	    this.power = inputPower;
	}
	
	/*Accesseurs :*/
	public String getWeaponName(){
	    return this.weaponName;
	}
	
	public int getPower(){
	    return this.power;
	}
}