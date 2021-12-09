package model;

import java.util.*;

import javax.swing.UIManager;

@SuppressWarnings("deprecation")
public class Book extends Observable{

    private int currentParagraph = 0;
    private List<Paragraph> paragraphsList = new ArrayList<>();


    public Book(){};

    public Book(int nbPages){
        this.emptyPages(nbPages);
        
        try {
            // On change le look and feel en cours
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch( Exception exception ) {
            exception.printStackTrace();
        }
    }


    public int getCurrentParagraph(){
        return this.currentParagraph;
    }

    public List<Paragraph> getParagraphsList(){
        return this.paragraphsList;
    }


    public void setCurrentParagraph(int nbParagraph){
        this.currentParagraph = nbParagraph;
        setChanged();
        notifyObservers();
    }

    public void emptyPages(int nbPages){
        for (int i=0; i < nbPages ; i++){
            this.paragraphsList.add(new Paragraph());
        }
    }

    public void addParaEnd(Paragraph inputParagraph){
        this.paragraphsList.add(inputParagraph);
        setChanged();
        notifyObservers();
    }

    public void deletePara(int inputParagraph){
        this.paragraphsList.remove(inputParagraph);
        setChanged();
        notifyObservers();
    }


}