package controller;

import controller.AL;
import view.FightCreation;

import model.Book;

public class DoFight extends AL{

    public DoFight(Book inputBook){
        super(inputBook); //AL
    }


    //-@Override //AL//
    public void actionToDo(){
		FightCreation newFight = new FightCreation(book);
		//new FightCreation(book);
    }
}