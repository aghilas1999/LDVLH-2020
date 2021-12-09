/*package data.view;

import model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import data.model.Book;
import data.model.Fight;

public class FightCreation extends JFrame implements ActionListener{
    private Book book;
    private PreviewB previewB;
    private JLabel jlabel;
    private JPanel jpanel;
    private JTextArea enemyName;
    private JTextArea enemyPV;
    private JTextArea enemyPower;
    private JTextArea enemyWeapon;
    private JTextArea pvToWin;
    private JTextArea pvToLose;
    private JButton confirmButton;
    private JButton cancelButton;

    
    public FightCreation(Book inputBook){

      try{
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
      }catch(Exception exception){
        exception.printStackTrace();
      }

        this.book = inputBook;
        this.previewB = new PreviewB(this.book);
        this.jlabel = new JLabel();
        this.jpanel = new JPanel();
        this.enemyName = new JTextArea();
        this.enemyPower = new JTextArea();
        this.enemyWeapon = new JTextArea();
        this.pvToWin = new JTextArea();
        this.pvToLose = new JTextArea();
        this.confirmButton = new JButton("Confirm");
        this.cancelButton = new JButton("Cancel");

        this.setTitle("Adding a Fight");
        this.setSize(300,250); /////////
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.confirmButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
        this.add(this.jlabel, BorderLayout.NORTH);
        
        this.enemyName.setLineWrap(true);
        //this.weaponPower.setBackground(new Color(103,191,205));
        this.enemyName.setText("Enter the name of the enemy");
        this.enemyPower.setText("Enter the power of the enemy \n(int)");
        this.enemyPV.setText("Enter the PV of the enemy \n(int)");
        this.enemyWeapon.setText("Enter the weapon of the enemy \n(int)");
        this.pvToLose.setText("Enter the pv to lose for the fight loser\n(int)");
        this.pvToWin.setText("Enter the pv to win for the fight winner\n(int)");
        this.setLayout(new BorderLayout());
        //this.setLayout(new GridLayout(3, 2));
        //this.add(new JScrollPane(this.weaponName), BorderLayout.WEST);
        //this.add(new JScrollPane(this.weaponPower), BorderLayout.EAST);
        this.add(new JScrollPane(this.enemyName), BorderLayout.NORTH);
        this.add(new JScrollPane(this.enemyPower), BorderLayout.CENTER);
        this.add(new JScrollPane(this.enemyPV), BorderLayout.SOUTH);
        this.add(new JScrollPane(this.enemyWeapon));
        this.add(new JScrollPane(this.pvToLose));
        this.add(new JScrollPane(this.pvToWin));
        //this.pack();

        
        this.add(this.jpanel, BorderLayout.SOUTH);
        this.jpanel.add(this.confirmButton);
        this.jpanel.add(this.cancelButton);

        

    }


	@Override
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.confirmButton){
          int ePower = Integer.parseInt(this.enemyPower.getText());
          int ePV = Integer.parseInt(this.enemyPV.getText());
          int pvWin = Integer.parseInt(this.pvToWin.getText());
          int pvLose = Integer.parseInt(this.pvToLose.getText());
          this.book.getParagraphsList().get(this.book.getCurrentParagraph()).addFight(new Fight(this.enemyName.getText(),ePower, ePV, this.enemyWeapon.getText(), pvLose, pvWin));
          this.dispose();
        }
        if(e.getSource() == this.cancelButton){
          this.dispose();
        }
      }

}*/
package view;

import model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import model.Book;
import model.Fight;

public class FightCreation extends JFrame implements ActionListener{
    private Book book;
    private PreviewB previewB;
    private JLabel jlabel;
    private JPanel jpanel;
    private JPanel param;
    private JTextArea enemyName;
    private JTextArea enemyPower;
    private JTextArea enemyPV;
    private JTextArea enemyWeapon;
    private JTextArea pvToLose;
    private JTextArea pvToWin;
    private JButton confirmButton;
    private JButton cancelButton;
    private int numSelectedNode;

    
    public FightCreation(Book inputBook){

      try{
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }catch(Exception exception){
        exception.printStackTrace();
      }

        this.book = inputBook;
        this.previewB = new PreviewB(this.book);
        this.jlabel = new JLabel("New weapon unlock at paragraph number " + (this.book.getCurrentParagraph()+1));
        this.jpanel = new JPanel();
        this.param = new JPanel();
        this.enemyName = new JTextArea();
        this.enemyPower = new JTextArea();
        this.enemyPV = new JTextArea();
        this.enemyWeapon = new JTextArea();
        this.pvToLose = new JTextArea();
        this.pvToWin = new JTextArea();
        this.confirmButton = new JButton("Confirm");
        this.cancelButton = new JButton("Cancel");
        this.numSelectedNode = -1;

        this.setTitle("Adding a fight");
        this.setSize(650,250); /////////
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.confirmButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
        this.add(this.jlabel, BorderLayout.NORTH);
        

        this.enemyName.setText("Enter the Name of the enemy");
        this.enemyPower.setText("Enter the power of the enemy \n(int)");
        this.enemyPV.setText("Enter the pv of the enemy \n(int)");
        this.enemyWeapon.setText("Enter the weapon of the enemy");
        this.pvToLose.setText("Enter the pv to lose for the loser of the fight\n(int)");
        this.pvToWin.setText("Enter the pv to win for the winner of the fight\n(int)");
        //this.setLayout(new BorderLayout());
        this.param.setLayout(new GridLayout(3, 2));
        this.param.add(new JScrollPane(this.enemyName));
        this.param.add(new JScrollPane(this.enemyPV));
        this.param.add(new JScrollPane(this.enemyWeapon));
        this.param.add(new JScrollPane(this.enemyPower));
        this.param.add(new JScrollPane(this.pvToLose));
        this.param.add(new JScrollPane(this.pvToWin));
        //this.pack();
		this.add(this.param, BorderLayout.CENTER);
        
        this.add(this.jpanel, BorderLayout.SOUTH);
        this.jpanel.add(this.confirmButton);
        this.jpanel.add(this.cancelButton);
    }
        
	       @Override
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.confirmButton){
          int ePower = Integer.parseInt(this.enemyPower.getText());
          String eWeapon = this.enemyWeapon.getText();;
          int ePV = Integer.parseInt(this.enemyPV.getText());
          int pvWin = Integer.parseInt(this.pvToWin.getText());
          int pvLose = Integer.parseInt(this.pvToLose.getText());
          this.book.getParagraphsList().get(this.book.getCurrentParagraph()).addFight(new Fight(this.enemyName.getText(),ePower, ePV, eWeapon, pvLose, pvWin));
          this.dispose();
        }
        if(e.getSource() == this.cancelButton){
          this.dispose();
        }
      }

}