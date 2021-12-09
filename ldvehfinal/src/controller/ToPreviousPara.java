package controller;

import model.Book;
import view.UserInterface;

public class ToPreviousPara extends AL{

	protected UserInterface userinterface;

    public ToPreviousPara(Book inputBook, UserInterface inputUI){
        super(inputBook); //AL
        this.userinterface = inputUI;
    }


    //-@Override //AL//
    public void actionToDo(){
        this.book.getParagraphsList().get(this.book.getCurrentParagraph()).changeContent(this.userinterface.getTextDisplay().getTextArea().getText(), this.userinterface.getTextDisplay().getQuestionArea().getText());
        
        if((this.book.getCurrentParagraph()>=1) && this.book.getCurrentParagraph()<=this.book.getParagraphsList().size()){ //paragraphe actuel dans la liste paragraphes (entre 0 et taille)
            this.book.setCurrentParagraph(this.book.getCurrentParagraph()-1);
        }else{
            this.book.setCurrentParagraph(this.book.getParagraphsList().size()-1); //para = 0 -> renvoie au au dernier paragraphe
        }
    }
}