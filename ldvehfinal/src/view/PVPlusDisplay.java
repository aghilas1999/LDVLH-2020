package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

import controller.AL;
import controller.DoChoice;
import controller.DoPVPlus;
import controller.ToNumPara;
import model.Book;

public class PVPlusDisplay extends JPanel implements Observer{
    private Book book;
    private JPanel jpanel;
    private JLabel jlabel;
    private UserInterface userinterface;
    

    public PVPlusDisplay(Book inputBook, UserInterface inputUI){
        this.book = inputBook;
        this.jpanel = new JPanel();
        this.userinterface = inputUI;
        this.book.addObserver(this);

        for(int i=0; i<this.book.getParagraphsList().size(); i++){
            this.book.getParagraphsList().get(i).addObserver(this);
        }

        this.setLayout(new BorderLayout());
        //this.jpanel.setPreferredSize(new Dimension(55,70));
        AL actionListener = new DoPVPlus(book, userinterface);
        //this.jlabel = new JLabel();
        JButton plusPvButton = new JButton("+ PV");
        plusPvButton.setPreferredSize(new Dimension(35,60));///////
        plusPvButton.addActionListener(actionListener);
        //this.add(jlabel, BorderLayout.NORTH);
        this.addPV();
        this.add(new JScrollPane(jpanel), BorderLayout.CENTER);
        this.add(plusPvButton, BorderLayout.SOUTH);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch( Exception exception ) {
            exception.printStackTrace();
        }
    }


    public void addPV(){
        this.jpanel.removeAll();
        this.jlabel = new JLabel("Paragraph " + (this.book.getCurrentParagraph()+1) + "adding PV");
        //System.out.println(this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getChoicesList().size()==0);
        if(this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getPVplusList().size()==0){
            JLabel noAdd = new JLabel("0");
            this.jpanel.add(noAdd, BorderLayout.CENTER);
            noAdd.setPreferredSize(new Dimension(10,70));
        }
        else{
            for(int i=0; i<this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getPVplusList().size(); i++){
            	JButton plusPVButton = new JButton("+" + this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getPVplusList().get(i));
                this.jpanel.add(plusPVButton, BorderLayout.CENTER);
            	
            	/*AL actionListener = new ToNumPara(this.book, this.userinterface, this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getChoicesList().get(i).getParaRedirection());
                JButton choiceButton = new JButton(this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getChoicesList().get(i).getChoiceName());
                this.jpanel.add(choiceButton, BorderLayout.NORTH);
                choiceButton.addActionListener(actionListener);*/
            }
        }
    }


    public void update(Observable observable, Object obj){
            this.addPV();
            this.revalidate();
            this.repaint();
    }

}