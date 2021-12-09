package view;

import model.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.*;

import javax.swing.*;

import controller.AL;
import controller.DoWeapon;
import model.Book;

public class WeaponDisplay extends JPanel implements Observer{
    private Book book;
    private JPanel jpanel;
    private JLabel jlabel;
    private UserInterface userinterface;
    

    public WeaponDisplay(Book inputBook, UserInterface inputUI){
        this.book = inputBook;
        this.jpanel = new JPanel();
        this.userinterface = inputUI;
        this.book.addObserver(this);

        for(int i=0; i<this.book.getParagraphsList().size(); i++){
            this.book.getParagraphsList().get(i).addObserver(this);
        }

        this.setLayout(new BorderLayout());
        //this.jpanel.setPreferredSize(new Dimension(205,70));
        AL actionListener = new DoWeapon(book);
        //this.jlabel = new JLabel();
        JButton addWeaponButton = new JButton("Add a weapon");
        addWeaponButton.setPreferredSize(new Dimension(55,60));///////
        addWeaponButton.addActionListener(actionListener);
        //this.add(jlabel, BorderLayout.NORTH);
        this.weapons();
        this.add(new JScrollPane(jpanel), BorderLayout.CENTER);
        this.add(addWeaponButton, BorderLayout.SOUTH);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch( Exception exception ) {
            exception.printStackTrace();
        }
    }


    public void weapons(){
        this.jpanel.removeAll();
        this.jlabel = new JLabel("Paragraph " + (this.book.getCurrentParagraph()+1) + "weapons");
        if((this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getWeaponsList()).size()==0){
            JLabel noWeapons = new JLabel("No weapon yet");
            this.jpanel.add(noWeapons, BorderLayout.CENTER);
            noWeapons.setPreferredSize(new Dimension(100,70));
        }
        else{
            for(int i=0; i<this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getWeaponsList().size(); i++){
            	String name = this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getWeaponsList().get(i).getWeaponName();
            	int power = this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getWeaponsList().get(i).getPower();
                JButton weaponButton = new JButton(name + " | Power : " + power);
                this.jpanel.add(weaponButton, BorderLayout.CENTER);
            }
        }
    }


    public void update(Observable observable, Object obj){
            this.weapons();
            this.revalidate();
            this.repaint();
    }
    
    
    
    

}