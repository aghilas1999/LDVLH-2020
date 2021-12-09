package controller;

import controller.AL;
import view.ChoiceCreation;

import model.Book;

public class DoChoice extends AL{

    public DoChoice(Book inputBook){
        super(inputBook); //AL
    }


    public void actionToDo(){
        ChoiceCreation newChoice = new ChoiceCreation(book);
        //new ChoiceCreation(book);
    }
}