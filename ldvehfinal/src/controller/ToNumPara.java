package controller;

import model.Book;
import view.UserInterface;
import model.*;

public class ToNumPara extends AL{

    protected UserInterface userinterface;
    protected int numPara;

    public ToNumPara(Book inputBook, UserInterface inputUI, int inputNumPara){
        super(inputBook); //AL
        this.userinterface = inputUI;
        this.numPara = inputNumPara;
    }


    //-@Override //AL//
    public void actionToDo(){
        this.book.getParagraphsList().get(this.book.getCurrentParagraph()).changeContent(this.userinterface.getTextDisplay().getTextArea().getText(), this.userinterface.getTextDisplay().getQuestionArea().getText());
        this.book.setCurrentParagraph(this.numPara);
    }
}