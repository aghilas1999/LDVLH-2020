package controller;

import model.Book;
import model.Paragraph;
import view.UserInterface;


public class DoAdd extends AL{

	protected UserInterface userinterface;

    public DoAdd(Book inputBook, UserInterface inputUI){
        super(inputBook); //AL
        this.userinterface = inputUI;
    }


    //-@Override //AL//
    public void actionToDo(){//control
        this.book.getParagraphsList().get(this.book.getCurrentParagraph()).changeContent(this.userinterface.getTextDisplay().getTextArea().getText(), this.userinterface.getTextDisplay().getQuestionArea().getText());
        this.book.addParaEnd(new Paragraph());
    }
}