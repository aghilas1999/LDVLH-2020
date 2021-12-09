package view;

import model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import model.Book;
import model.Choice;
import view.PreviewB;

public class ChoiceCreation extends JFrame implements ActionListener {
    protected Book book;
    protected PreviewB previewB;
    protected JLabel jlabel;
    protected JPanel jpanel;
    protected JTree jtree;
    protected JTextArea jtextarea;
    protected JButton confirmButton;
    protected JButton cancelButton;
    protected int numSelectedNode;
    protected int jfr = -1;

    
    public ChoiceCreation(Book inputBook){
      try{
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }catch(Exception exception){
        exception.printStackTrace();
      }

        this.book = inputBook;
        this.previewB = new PreviewB(this.book);
        this.jlabel = new JLabel("New choice to paragraph number " + (this.book.getCurrentParagraph()+1));
        this.jpanel = new JPanel();
        this.jtextarea = new JTextArea();
        this.confirmButton = new JButton("Confirm");
        this.cancelButton = new JButton("Cancel");
        this.numSelectedNode = -1;

        this.setTitle("Adding a choice");
        this.setSize(320,200); /////////
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.confirmButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
        this.add(this.jlabel, BorderLayout.NORTH);
        this.add(new JScrollPane(this.jtextarea));

        PreviewB previewB  = new PreviewB(this.book);
        this.jtree = new JTree(previewB); //this.preview
        /////////////
        jtree.addTreeSelectionListener(new TreeSelectionListener(){
          public void valueChanged(TreeSelectionEvent e) {
            Underfault selectedNode=(Underfault)jtree.getLastSelectedPathComponent();
            jfr = selectedNode.getNumParagraph();
          }
        });
        /////////////
        this.add(jtree, BorderLayout.WEST);
        this.add(this.jpanel, BorderLayout.SOUTH);
        this.jpanel.add(this.confirmButton);
        this.jpanel.add(this.cancelButton);
       

    }


	@Override
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.confirmButton && this.jfr != -1){
        	this.book.getParagraphsList().get(this.book.getCurrentParagraph()).addChoice(new Choice(this.jtextarea.getText(),this.jfr));
          this.dispose();
        }
        if(e.getSource() == this.cancelButton){
          this.dispose();
        }
      }

}