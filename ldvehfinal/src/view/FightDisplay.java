package view;

import model.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.*;

import javax.swing.*;

import controller.AL;
import controller.DoChoice;
import controller.DoFight;
import model.Book;

public class FightDisplay extends JPanel implements Observer{
    private Book book;
    private JPanel jpanel;
    private JLabel jlabel;
    private UserInterface userinterface;
    

    public FightDisplay(Book inputBook, UserInterface inputUI){
        this.book = inputBook;
        this.jpanel = new JPanel();
        this.userinterface = inputUI;
        this.book.addObserver(this);

        for(int i=0; i<this.book.getParagraphsList().size(); i++){
            this.book.getParagraphsList().get(i).addObserver(this);
        }

        this.setLayout(new BorderLayout());
        //this.jpanel.setPreferredSize(new Dimension(220,70));
        AL actionListener = new DoFight(book);
        //this.jlabel = new JLabel();
        JButton addFightButton = new JButton("Add a fight");
        addFightButton.setPreferredSize(new Dimension(220,60));///////
        addFightButton.addActionListener(actionListener);
        //this.add(jlabel, BorderLayout.NORTH);
        this.fights();
        this.add(new JScrollPane(jpanel), BorderLayout.CENTER);
        this.add(addFightButton, BorderLayout.SOUTH);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch( Exception exception ) {
            exception.printStackTrace();
        }
    }


    public void fights(){
        this.jpanel.removeAll();
        this.jlabel = new JLabel("Paragraph " + (this.book.getCurrentParagraph()+1) + "fights");
        if(this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getFightsList().size()==0){
            JLabel noFights = new JLabel("No fight yet");
            noFights.setPreferredSize(new Dimension(75,70));
            this.jpanel.add(noFights, BorderLayout.CENTER);
        }
        else{
            for(int i=0; i<this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getFightsList().size(); i++){
                String eName = this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getFightsList().get(i).getEnemyName();
                int ePower = this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getFightsList().get(i).getEnemyPower();
                int ePV = this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getFightsList().get(i).getEnemyPV();
                String eWeapon = this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getFightsList().get(i).getEnemyWeapon();
                int pvToLose = this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getFightsList().get(i).getPVToLose();
                int pvToWin = this.book.getParagraphsList().get(this.book.getCurrentParagraph()).getFightsList().get(i).getPVToWin();
                //JButton fightButton = new JButton("Fight VS." + eName + " | Power : " + ePower + " | PV : " + ePV + " | Weapon : " + eWeapon + "\nPV to lose : " + pvToLose + "PV to win : " + pvToWin);
                JButton fightButton = new JButton("<html>"+"Fight VS. "+eName+ " | PV : " + ePV + "<br>" + "Weapon : " + eWeapon +" | Power : "+ ePower +"<br>"+"PV to lose : " + pvToLose + " | PV to win : " + pvToWin+"</html>");
                this.jpanel.add(fightButton, BorderLayout.EAST);
            }
        }
    }


    public void update(Observable observable, Object obj){
            this.fights();
            this.revalidate();
            this.repaint();
    }
    
    
    
    

}