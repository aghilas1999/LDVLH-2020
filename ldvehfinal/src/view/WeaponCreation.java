package view;

import model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import model.Book;
import model.Weapon;

public class WeaponCreation extends JFrame implements ActionListener{
    private Book book;
    private PreviewB previewB;
    private JLabel jlabel;
    private JPanel jpanel;
    private JTextArea weaponName;
    private JTextArea weaponPower;
    private JButton confirmButton;
    private JButton cancelButton;
    private int numSelectedNode;

    
    public WeaponCreation(Book inputBook){

      try{
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
       // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }catch(Exception exception){
        exception.printStackTrace();
      }

        this.book = inputBook;
        this.previewB = new PreviewB(this.book);
        this.jlabel = new JLabel("New weapon unlock at paragraph number " + this.book.getCurrentParagraph()+1);
        this.jpanel = new JPanel();
        this.weaponName = new JTextArea();
        this.weaponPower = new JTextArea();
        this.confirmButton = new JButton("Confirm");
        this.cancelButton = new JButton("Cancel");
        this.numSelectedNode = -1;

        this.setTitle("Adding a Weapon");
        this.setSize(250,200); /////////
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.confirmButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
        this.add(this.jlabel, BorderLayout.NORTH);
        
        this.weaponName.setLineWrap(true);
        this.weaponName.setText("Enter the title");
        this.weaponPower.setText("Enter the power \n(int)");
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(this.weaponName), BorderLayout.WEST);
        this.add(new JScrollPane(this.weaponPower), BorderLayout.EAST);

        
        this.add(this.jpanel, BorderLayout.SOUTH);
        this.jpanel.add(this.confirmButton);
        this.jpanel.add(this.cancelButton);
    }
        
		@Override
		public void actionPerformed(ActionEvent e) {
	          if(e.getSource() == this.confirmButton){
	        	  int newWeaponPower = Integer.parseInt(this.weaponPower.getText());
	        	this.book.getParagraphsList().get(this.book.getCurrentParagraph()).addWeapon(new Weapon(this.weaponName.getText(), newWeaponPower));
	            this.dispose();
	          }
	          if(e.getSource() == this.cancelButton){
	            this.dispose();
	          }
	        }

}