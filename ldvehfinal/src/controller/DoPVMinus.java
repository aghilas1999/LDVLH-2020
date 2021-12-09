package controller;

import model.Book;
import view.UserInterface;
import model.*;
import view.MinusCreation;

public class DoPVMinus extends AL{

	protected UserInterface userinterface;

    public DoPVMinus(Book inputBook, UserInterface inputUI){
        super(inputBook); //AL
        this.userinterface = inputUI;
    }


    //-@Override //AL//
    public void actionToDo(){
        this.book.getParagraphsList().get(this.book.getCurrentParagraph()).changeContent(this.userinterface.getTextDisplay().getTextArea().getText(), this.userinterface.getTextDisplay().getQuestionArea().getText());
        MinusCreation minusPV = new MinusCreation(this.book);
        //new MinusCreation(this.book)
    }
}