package controller;

import model.Book;
import view.UserInterface;
import view.ParaRemoval;

public class DoRemoval extends AL{

	protected UserInterface userinterface;

    public DoRemoval(Book inputBook, UserInterface inputUI){
        super(inputBook); //AL
        this.userinterface = inputUI;
    }


    //@Override //AL//
    public void actionToDo(){
        this.book.getParagraphsList().get(this.book.getCurrentParagraph()).changeContent(this.userinterface.getTextDisplay().getTextArea().getText(), this.userinterface.getTextDisplay().getQuestionArea().getText());
        ParaRemoval pRemove = new ParaRemoval(book);
        //new ParaRemoval(book);
    }
}