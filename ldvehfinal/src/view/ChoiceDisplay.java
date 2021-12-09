package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

import controller.AL;
import controller.DoChoice;
import controller.ToNumPara;
import model.Book;

public class ChoiceDisplay extends JPanel implements Observer{
    private Book book;
    private JPanel jpanel;
    private JLabel jlabel;
    private UserInterface userinterface;
    

    public ChoiceDisplay(Book inputBook, UserInterface inputUI){
        this.book = inputBook;
        this.jpanel = new JPanel();
        this.userinterface = inputUI;
        this.book.addObserver(this);

        for(int i=0; i<this.book.getParagraphsList().size(); i++){
            this.book.getParagraphsList().get(i).addObserver(this);
        }

        this.setLayout(new BorderLayout());
        //this.setPreferredSize(new Dimension(205,70));
        AL actionListener = new DoChoice(book);
        //this.jlabel = new JLabel("Choix");
        JButton addChoiceButton = new JButton("Add a choice");
        addChoiceButton.setPreferredSize(new Dimension(55,60));///////
        addChoiceButton.addActionListener(actionListener);
        //this.add(jlabel, BorderLayout.NORTH);
        //this.add(new JScrollPane(jpanel));
        //this.add(addChoiceButton, BorderLayout.SOUTH);
        //this.add(new JScrollPane(jpanel), BorderLayout.SOUTH);
        this.choices();
        this.add(new JScrollPane(jpanel), BorderLayout.CENTER);
        this.add(addChoiceButton, BorderLayout.SOUTH);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch( Exception exception ) {
            exception.printStackTrace();
        }
    }


    public void choices(){
        this.jpanel.removeAll();
        this.jlabel = new JLabel("Paragraph " + (this.book.getCurrentParagraph()+1) + "choices");
        //System.out.println(this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getChoicesList().size()==0);
        if(this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getChoicesList().size()==0){
            JLabel noChoices = new JLabel("No choice yet");
            noChoices.setPreferredSize(new Dimension(90,70));
            this.jpanel.add(noChoices, BorderLayout.CENTER);
        }
        else{
            for(int i=0; i<this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getChoicesList().size(); i++){
                AL actionListener = new ToNumPara(this.book, this.userinterface, this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getChoicesList().get(i).getParaRedirection());
                JButton choiceButton = new JButton(this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getChoicesList().get(i).getChoiceName());
                this.jpanel.add(choiceButton, BorderLayout.CENTER);
                choiceButton.addActionListener(actionListener);
            }
        }
        
    }


    public void update(Observable observable, Object obj){
            this.choices();
            this.revalidate();
            this.repaint();
    }
    
    
    
    

}