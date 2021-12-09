package controller;

import model.Book;
import view.UserInterface;
import view.PlusCreation;

public class DoPVPlus extends AL{

    protected UserInterface userinterface;

    public DoPVPlus(Book inputBook, UserInterface inputUI){
        super(inputBook); //AL
        this.userinterface = inputUI;
    }


    //-@Override //AL//
    public void actionToDo(){
        this.book.getParagraphsList().get(this.book.getCurrentParagraph()).changeContent(this.userinterface.getTextDisplay().getTextArea().getText(), this.userinterface.getTextDisplay().getQuestionArea().getText());
        PlusCreation PlusPV = new PlusCreation(book);
        //new PlusCreation(book);
    }
}