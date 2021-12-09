package view;

import model.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import model.Book;

public class MinusCreation extends JFrame implements ActionListener{
    private Book book;
    private PreviewB previewB;
    private JLabel jlabel;
    private JPanel jpanel;
    //private JTree jtree;
    private JTextArea jtextarea;
    private JButton confirmButton;
    private JButton cancelButton;
    private int numSelectedNode;

    
    public MinusCreation(Book inputBook){

      try{
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    	//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }catch(Exception exception){
        exception.printStackTrace();
      }

        this.book = inputBook;
        this.previewB = new PreviewB(this.book);
        this.jlabel = new JLabel("Remove PV to paragraph number " + (this.book.getCurrentParagraph()+1));
        this.jpanel = new JPanel();
        this.jtextarea = new JTextArea();
        this.confirmButton = new JButton("Confirm");
        this.cancelButton = new JButton("Cancel");
        this.numSelectedNode = -1;

        this.setTitle("Remove PV");
        this.setSize(320,200); /////////
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.confirmButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
        this.add(this.jlabel, BorderLayout.NORTH);
        this.add(new JScrollPane(this.jtextarea));


        
        this.add(this.jpanel, BorderLayout.SOUTH);
        this.jpanel.add(this.confirmButton);
        this.jpanel.add(this.cancelButton);

    }


	@Override
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.confirmButton){
          int pvMinus = Integer.parseInt(this.jtextarea.getText());
          //this.book.get().getParagraphsList().(this.book.getCurrentParagraph()).setPV(this.inputBook.getCurrentParagraph().getPV() - pvMinus;
          this.book.getParagraphsList().get(this.book.getCurrentParagraph()).setPV(this.book.getCurrentParagraph()-pvMinus);
          this.book.getParagraphsList().get(this.book.getCurrentParagraph()).addMinPV(pvMinus);
          this.dispose();
        }
        if(e.getSource() == this.cancelButton){
          this.dispose();
        }
      }

}