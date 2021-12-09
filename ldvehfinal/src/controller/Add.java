package controller;

import view.TextDisplay;
import model.Book;
import model.Paragraph;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
*Extensions de la class AbstractAction.
*Ajoute un paragraphe au livre actuellement ouvert.
*@author Mathieu Langlois, Vincent Tourigny
*/
public class Add extends AbstractAction{

  protected Book fiche;
  public Add(String texte, Book l){
  	super(texte);
    this.fiche=l;
  }
  public void actionPerformed(ActionEvent e) {
    this.fiche.addParaEnd(new Paragraph());
  }

}