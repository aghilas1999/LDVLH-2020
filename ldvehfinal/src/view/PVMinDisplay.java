/*package data.view;

import model.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.*;

import javax.swing.*;

import data.controller.AL;
import data.controller.DoPVMinus;
import data.controller.DoPVPlus;
import data.model.Book;

public class PVDisplay extends JPanel implements Observer{
    private Book book;
    private JPanel jpanel;
    private JLabel jlabel;
    private UserInterface userinterface;
    private JButton minusPvButton;
    private JButton plusPvButton;
    

    public PVDisplay(Book inputBook, UserInterface inputUI){
        this.book = inputBook;
        this.jpanel = new JPanel();
        this.userinterface = inputUI;
        this.book.addObserver(this);

        for(int i=0; i<this.book.getParagraphsList().size(); i++){
            this.book.getParagraphsList().get(i).addObserver(this);
        }

        this.setLayout(new BorderLayout());
        AL minusAl = new DoPVMinus(book, userinterface);
        minusPvButton = new JButton("PV -");
        minusPvButton.setPreferredSize(new Dimension(40,40));///////
        minusPvButton.addActionListener(minusAl);
        AL plusAl = new DoPVPlus(book, userinterface);
        plusPvButton = new JButton("PV +");
        plusPvButton.setPreferredSize(new Dimension(40,40));///////
        plusPvButton.addActionListener(plusAl);
        
        //this.choices();
        this.add(new JScrollPane(jpanel), BorderLayout.CENTER);
        this.add(minusPvButton, BorderLayout.NORTH);
        this.add(plusPvButton, BorderLayout.CENTER);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch( Exception exception ) {
            exception.printStackTrace();
        }
    }


    public void allPV(){
        this.jpanel.removeAll();
        //this.jlabel = new JLabel("Paragraph " + (this.book.getCurrentParagraph()+1) + "choices");
        if(this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getPVList().size()==0){
            JLabel noPVModif = new JLabel("You haven't modified PV yet");
            this.jpanel.add(noPVModif, BorderLayout.EAST);
        }
        else{
            for(int i=0; i<this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getPVminList().size(); i++){
                JButton minPVButton = new JButton("-" + this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getPVminList().get(i));
                this.jpanel.add(minPVButton, BorderLayout.EAST);
            }
            for(int i=0; i<this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getPVplusList().size(); i++){
                JButton plusPVButton = new JButton("+" + this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getPVplusList().get(i));
                this.jpanel.add(plusPVButton, BorderLayout.EAST);
            }
        }
    }


    public void update(Observable observable, Object obj){
            this.allPV();
            this.revalidate();
            this.repaint();
    }
    
    
    
    

}*/

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

import controller.AL;
import controller.DoChoice;
import controller.DoPVMinus;
import controller.DoPVPlus;
import controller.ToNumPara;
import model.Book;

public class PVMinDisplay extends JPanel implements Observer{
    private Book book;
    private JPanel jpanel;
    private JLabel jlabel;
    private UserInterface userinterface;
    

    public PVMinDisplay(Book inputBook, UserInterface inputUI){
        this.book = inputBook;
        this.jpanel = new JPanel();
        this.userinterface = inputUI;
        this.book.addObserver(this);

        for(int i=0; i<this.book.getParagraphsList().size(); i++){
            this.book.getParagraphsList().get(i).addObserver(this);
        }

        this.setLayout(new BorderLayout());
        //this.jpanel.setPreferredSize(new Dimension(55,70));
        AL actionListener = new DoPVMinus(book, userinterface);
        //this.jlabel = new JLabel();
        JButton plusPvButton = new JButton("- PV");
        plusPvButton.setPreferredSize(new Dimension(35,60));///////
        plusPvButton.addActionListener(actionListener);
        //this.add(jlabel, BorderLayout.NORTH);
        this.removePV();
        this.add(new JScrollPane(jpanel), BorderLayout.CENTER);
        this.add(plusPvButton, BorderLayout.SOUTH);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch( Exception exception ) {
            exception.printStackTrace();
        }
    }


    public void removePV(){
        this.jpanel.removeAll();
        this.jlabel = new JLabel("Paragraph " + (this.book.getCurrentParagraph()+1) + "adding PV");
        //System.out.println(this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getChoicesList().size()==0);
        if(this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getPVminList().size()==0){
            JLabel noRemove = new JLabel("0");
            noRemove.setPreferredSize(new Dimension(10,70));
            this.jpanel.add(noRemove, BorderLayout.CENTER);
        }
        else{
            for(int i=0; i<this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getPVminList().size(); i++){
            	JButton minPVButton = new JButton("-" + this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getPVminList().get(i));
                this.jpanel.add(minPVButton, BorderLayout.EAST);
                
            	/*AL actionListener = new ToNumPara(this.book, this.userinterface, this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getChoicesList().get(i).getParaRedirection());
                JButton choiceButton = new JButton(this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getChoicesList().get(i).getChoiceName());
                this.jpanel.add(choiceButton, BorderLayout.NORTH);
                choiceButton.addActionListener(actionListener);*/
            }
        }
    }


    public void update(Observable observable, Object obj){
            this.removePV();
            this.revalidate();
            this.repaint();
    }

}