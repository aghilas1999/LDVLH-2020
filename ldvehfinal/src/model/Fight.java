package model;


/*Un combat : joueur combat un perso (juste un nom) 
et doit avoir un soit un PV ou POWER ou WEAPON nécessaire pour le battre
si il gagne le joueur a des PV et/ou POWER en plus
sinon des PV et/ou POWER en moins*/

public class Fight {
    private String enemyName;
    private int enemyPower;
    private int enemyPV;
    private String enemyWeapon;
    private int pvToLose;
    private int pvToWin;

	public Fight(String inputEnemyName, int inputEnemyPower, int inputEnemyPV, String inputEnemyWeapon, int inputPVToLose, int inputPVToWin){
		System.out.println("je suis au fight");
		this.enemyName = inputEnemyName;
	    this.enemyPower = inputEnemyPower;
	    this.enemyPV = inputEnemyPV;
	    this.enemyWeapon = inputEnemyWeapon;
	    this.pvToLose = inputPVToLose;
	    this.pvToWin = inputPVToWin;
	}
	
	/*Accesseurs :*/
	public String getEnemyName(){
	    return this.enemyName;
	}
	
	public int getEnemyPower(){
	    return this.enemyPower;
	}
	
	public int getEnemyPV(){
	    return this.enemyPV;
	}
	
	public String getEnemyWeapon(){
	    return this.enemyWeapon;
	}
	
	public int getPVToLose(){
	    return this.pvToLose;
	}
	
	public int getPVToWin(){
	    return this.pvToWin;
	}
}