//package src;

import view.*;
import model.*;
import controller.*;


public class Main{
  public static void main(String[] args){
    Book book = new Book(1);
            UserInterface userInterface = new UserInterface(book);
            AL previousAL = new ToPreviousPara(book,userInterface);
            AL addAL = new DoAdd(book,userInterface);
            AL removeAL = new DoRemoval(book,userInterface);
            AL nextAL = new ToNextPara(book,userInterface);

            userInterface.getButtonDisplay().getPreviousButton().addActionListener(previousAL);
            userInterface.getButtonDisplay().getAddButton().addActionListener(addAL);
            userInterface.getButtonDisplay().getRemoveButton().addActionListener(removeAL);
            userInterface.getButtonDisplay().getNextButton().addActionListener(nextAL);
    }
}