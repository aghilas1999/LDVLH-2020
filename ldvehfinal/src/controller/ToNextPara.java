package controller;

import model.Book;
import view.UserInterface;

public class ToNextPara extends AL{

	protected UserInterface userinterface;

    public ToNextPara(Book inputBook, UserInterface inputUI){
        super(inputBook); //AL
        this.userinterface = inputUI;
    }


    //-@Override //AL//
    public void actionToDo(){
        this.book.getParagraphsList().get(this.book.getCurrentParagraph()).changeContent(this.userinterface.getTextDisplay().getTextArea().getText(), this.userinterface.getTextDisplay().getQuestionArea().getText());
        
        if((this.book.getCurrentParagraph()>=0) && (this.book.getCurrentParagraph()<=this.book.getParagraphsList().size()-2)){ //paragraphe actuel dans la liste paragraphes (entre 0 et taille-1)
            this.book.setCurrentParagraph(this.book.getCurrentParagraph()+1);
        }else{
            this.book.setCurrentParagraph(0); //paragraphe actuel = dernier -> renvoie au 1er
        }
    }
}