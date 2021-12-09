/*package data.view;

import model.*;
//import controller.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.*;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

import java.util.Observer;
import java.util.Observable;

import data.model.Book;
import data.model.Paragraph;


public class UserInterface extends JFrame implements Observer{
	protected Book book;
	protected TextDisplay text;
	protected ChoiceDisplay choice;
	protected ButtonDisplay button;
	protected PVDisplay pv;
	protected PreviewB previewB;
	protected MenuBar editor;
	protected JPanel jpanel;
	protected JTree jtree;
    


    public UserInterface(Book inputBook){
        this.book = inputBook;
        this.text = new TextDisplay(this.book);
        this.choice = new ChoiceDisplay(inputBook, this);
        this.button = new ButtonDisplay(text); //this.text
        this.pv = new PVDisplay(inputBook, this);
        this.previewB = new PreviewB(this.book);
        this.editor = new MenuBar(this);
        this.jpanel = new JPanel();

        this.book.addObserver(this);

        this.jtree = new JTree(previewB); //this.preview
        jpanel.add(new JScrollPane(jtree));
        jpanel.setPreferredSize(new Dimension(140,300)); //setPreferredSize class jframe \ dimension java awt

        this.setJMenuBar(editor);//this.editor


        ////
        this.setTitle("Editeur de livre dont vous êtes le héros");
        this.setSize(830,630); /////////////

        ImageIcon icon = new ImageIcon("images/20210413_011044.png");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception exception){
            exception.printStackTrace();
        }

    }
        public Book getBook(){
            return this.book;
        }

        public TextDisplay getTextDisplay(){
            return this.text;
        }

        public ButtonDisplay getButtonDisplay(){
            return this.button;
        }

        public void setBook(Book inputBook){
            this.book=inputBook;
        }

        public void update(Observable observable, Object obj){
            ((DefaultTreeModel)this.jtree.getModel()).reload();
            text.editPara(this.book.getCurrentParagraph());
        }

}*/
package view;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
//////
import model.Paragraph;
import model.Book;
import view.ChoiceDisplay;

import java.util.Observer;
import java.util.Observable;
/**
*Classe assemblant l'ensemble des éléments de l'interface graphique dans un JFrame.
*La classe implement un Observer permettant une mise à jour automatique (défectueuse) de l'Ui lorsque le livre est modifié.
*@author Mathieu Langlois, Colin Fabello,Vincent Tourigny
*/
public class UserInterface extends JFrame implements Observer{

  Book pl;
  TextDisplay pan1;
  ChoiceDisplay panC;
  ButtonDisplay panB;
  PVMinDisplay panPVmin;
  PVPlusDisplay panPVplus;
  WeaponDisplay panWp;
  FightDisplay panF;
  PreviewB un;
  JTree jt;
  JPanel pan2;
  JPanel pan3;
  JPanel pan11;
  JPanel pan12;
  JPanel panButton;
  /**
  *Constructeur de la classe Ui
  *@param l
  *   Livre qui est ouvert par le logiciel.
  */
  public UserInterface(Book l){
    this.pl=l;
    this.pan1 = new TextDisplay(this.pl);
    this.pan2 = new JPanel();
    this.pan3 = new JPanel();
    this.un = new PreviewB(this.pl);
    this.panB = new ButtonDisplay(pan1);
    MenuBar men = new MenuBar(this);
    this.panC=new ChoiceDisplay(l,this);
    this.panPVmin=new PVMinDisplay(l,this);
    this.panPVplus=new PVPlusDisplay(l,this);
    this.panWp=new WeaponDisplay(l,this);
    this.panF=new FightDisplay(l,this);
    this.pan11 = new JPanel();
    this.pan12 = new JPanel();
    this.panButton = new JPanel();

    this.pl.addObserver(this);
    
    

    //fenetre setting
    this.setTitle("Editeur de livres");
    this.setSize(900, 650);
    ImageIcon img = new ImageIcon("ressources/icon.png");
    this.setIconImage(img.getImage());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());
    this.setVisible(true);
    //this.setLayout(new GridLayout(2, 3));
    try {
        // On change le look and feel en cours
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch( Exception exception ) {
        exception.printStackTrace();
    }
    
    pan1.setPreferredSize(new Dimension((int)(this.getWidth()*0.72),(int)(this.getHeight()*0.6)));
    //panel1
    this.jt = new JTree(un);
    pan2.add(new JScrollPane(jt));
    pan2.setPreferredSize(new Dimension((int)(this.getWidth()*0.2), (int)(this.getHeight()*0.6)));
    
    //pan3.add(panPV, BorderLayout.BEFORE_LINE_BEGINS);
    panC.setPreferredSize(new Dimension(200,150));
    panWp.setPreferredSize(new Dimension(200,150));
    panF.setPreferredSize(new Dimension(280,150));
    panPVmin.setPreferredSize(new Dimension(70,150));
    panPVplus.setPreferredSize(new Dimension(70,150));
    pan3.add(panC, BorderLayout.WEST);
    pan3.add(panWp, BorderLayout.CENTER);
    pan3.add(panF, BorderLayout.EAST);
    pan3.add(panPVmin);
    pan3.add(panPVplus);
    
    pan11.add(new JScrollPane(pan1), BorderLayout.WEST);
    pan11.add(pan2, BorderLayout.EAST);

    this.setJMenuBar(men);

    //position panel
    //this.getContentPane().add(pan12, BorderLayout.NORTH);
    //pan11.setSize(new Dimension(280,200));
    this.getContentPane().add(new JScrollPane(pan11), BorderLayout.CENTER);
    this.getContentPane().add(new JScrollPane(pan3), BorderLayout.SOUTH);
    
    //this.getContentPane().add(new JScrollPane(pan1), BorderLayout.CENTER);
    //this.getContentPane().add(pan2, BorderLayout.EAST);//EAST
    this.getContentPane().add(panB, BorderLayout.NORTH);
    //this.getContentPane().add(panB, BorderLayout.NORTH);
    //this.getContentPane().add(panC, BorderLayout.SOUTH);//SOUTH
    //this.getContentPane().add(pan3, BorderLayout.SOUTH);
    //this.getContentPane().add(panPV, BorderLayout.BEFORE_FIRST_LINE);
    //this.getContentPane().add(panWp, BorderLayout.AFTER_LAST_LINE);
    //this.getContentPane().add(panF, BorderLayout.AFTER_LAST_LINE);
  }
  public ButtonDisplay getButtonDisplay(){return this.panB;}
  public TextDisplay getTextDisplay(){return this.pan1;}
  public Book getBook(){return this.pl;}
  public void setBook(Book l){
    this.pl=l;
   
  }
  /**
  *Méthode mettant à jour l'élément lorsque le livre ouvert est modifié.
  */
  public void update(Observable o, Object arg) {
    ((DefaultTreeModel)this.jt.getModel()).reload();
    pan1.editPara(this.pl.getCurrentParagraph());
    panC.choices();
  }
}
