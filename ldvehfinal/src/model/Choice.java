package model;

//Un choix : redirection vers un autre paragraphe en fonction de ce qui est choisi

public class Choice {
    private String choiceName;
    private int paraRedirection;

	public Choice(String inputChoiceName, int inputParaRedirection){
	    this.choiceName = inputChoiceName;
	    this.paraRedirection = inputParaRedirection;
	}
	
	/*Accesseurs :*/
	public String getChoiceName(){
	    return this.choiceName;
	}
	
	public int getParaRedirection(){
	    return this.paraRedirection;
	}
}

