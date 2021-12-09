package model;

import java.util.*;

@SuppressWarnings("deprecation")
public class Paragraph extends Observable{
	protected static int numTotPara = 0;
	protected int numPara;
	protected String content;
	protected String question;
	protected boolean loser;
	protected boolean last;
	protected int nextPara; //static ??
	protected ArrayList<Choice> choicesList; //= new ArrayList<Choice>();
	protected ArrayList<Fight> fightsList;
	protected ArrayList<Weapon> weaponsList;
	protected int nbPV;
	protected ArrayList<Integer> pvMinList;
	protected ArrayList<Integer> pvPlusList;
	protected ArrayList<Integer> pvList;



public Paragraph(String content, String question, boolean loser, boolean last, int nextPara){
    Paragraph.numTotPara +=1;
    this.numPara = Paragraph.numTotPara;
    this.content = content;
    this.question = question;
    this.loser = loser;
    this.last = last;
    this.nextPara = nextPara;
    this.choicesList = new ArrayList<Choice>();///
    this.fightsList = new ArrayList<Fight>();
    this.weaponsList = new ArrayList<Weapon>();
    this.pvMinList = new ArrayList<Integer>();
    this.pvPlusList = new ArrayList<Integer>();
    this.pvList = new ArrayList<Integer>();
    this.pvList = this.pvMinList;
    this.pvList.addAll(pvPlusList);
    this.nbPV = 0;
}

public Paragraph(){
    Paragraph.numTotPara +=1;
    this.numPara = Paragraph.numTotPara;
    this.content = "Put your paragraph here ";
    this.question = "Ask your question here ";
    this.loser = false;
    this.last = false;
    this.nextPara = 0;
    this.nbPV = 0;
    this.choicesList = new ArrayList<Choice>();///
    this.fightsList = new ArrayList<Fight>();
    this.weaponsList = new ArrayList<Weapon>();
    this.pvMinList = new ArrayList<Integer>();
    this.pvPlusList = new ArrayList<Integer>();
    this.pvList = new ArrayList<Integer>();
    this.pvList = this.pvMinList;
    this.pvList.addAll(pvPlusList);
}

public Paragraph(Paragraph para){
    Paragraph.numTotPara +=1;
    this.numPara = Paragraph.numTotPara;
    /*this.content = content;
    this.question = question;
    this.loser = loser;
    this.last = last;*/
    this.nextPara = para.nextPara;
}


/***Accesseurs***/
public int getNumTotPara(){
    return Paragraph.numTotPara;
}

public int getNumPara(){
    return this.numPara;
}

public String getContent(){
    return this.content;
}

public String getQuestion(){
    return this.question;
}

public boolean getLoser(){
    return this.loser;
}

public boolean getLast(){
    return this.last;
}

public int getNextPara(){
    return this.nextPara;
}

public ArrayList<Choice> getChoicesList(){
    return this.choicesList;
}

public ArrayList<Fight> getFightsList(){
    return this.fightsList;
}

public ArrayList<Weapon> getWeaponsList(){
    return this.weaponsList;
}
////////////

public ArrayList<Integer> getPVList(){
    return this.pvList;
}

public ArrayList<Integer> getPVminList(){
    return this.pvMinList;
}

public ArrayList<Integer> getPVplusList(){
    return this.pvPlusList;
}

public int getPV(){
    return this.nbPV;
}

public void setPV(int inputPV){
    this.nbPV = inputPV;
}


public void changeContent(String inputContent, String inputQuestion){
    this.content = inputContent;
    this.question = inputQuestion;
}

public void addChoice(Choice choice){
    this.choicesList.add(choice);
    setChanged();
    notifyObservers();
}

public void addFight(Fight fight){
    this.fightsList.add(fight);
    setChanged();
    notifyObservers();
}

public void addWeapon(Weapon inputWeapon){
    this.weaponsList.add(inputWeapon);
    setChanged();
    notifyObservers();
}
////

public void addMinPV(int inputPV){
    this.pvMinList.add(inputPV);
    setChanged();
    notifyObservers();
}

public void addPlusPV(int inputPV){
    this.pvPlusList.add(inputPV);
    setChanged();
    notifyObservers();
}////

public static void paraNull(){
    numTotPara=0; //pour ouverture fichier
}

}