package view;

import model.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import model.Book;

public class ParaRemoval extends JFrame implements ActionListener{
    private Book book;
    private JLabel jlabel;
    private JPanel jpanel;
    private JButton confirmButton;
    private JButton cancelButton;

    
    public ParaRemoval(Book inputBook){
        this.book = inputBook;
        this.jlabel = new JLabel("Remove paragraph number " + (this.book.getCurrentParagraph()+1));
        this.jpanel = new JPanel();
        this.confirmButton = new JButton("Confirm");
        this.cancelButton = new JButton("Cancel");

        this.setTitle("Paragraph Removal");
        this.setSize(220,100); /////////
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.confirmButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
        this.add(this.jlabel, BorderLayout.NORTH);
        this.add(this.jpanel, BorderLayout.SOUTH);
        this.jpanel.add(this.confirmButton);
        this.jpanel.add(this.cancelButton);
    }

        public void actionPerformed(ActionEvent e) {
          if(e.getSource() == this.confirmButton){
              if(this.book.getParagraphsList().size() == this.book.getCurrentParagraph()+1){
                  this.book.setCurrentParagraph(this.book.getCurrentParagraph()-1);
                  this.book.deletePara(this.book.getCurrentParagraph()+1);
                  this.dispose();
              }
              else if(this.book.getParagraphsList().size()==1){
                  this.book.deletePara(this.book.getCurrentParagraph());
                  this.dispose();
                  this.book.emptyPages(1);
              }
              else{
                  this.book.deletePara(this.book.getCurrentParagraph());
                  this.dispose();
              }
          }
          if(e.getSource() == this.cancelButton){
            this.dispose();
          }
        }////changer pour que quand supprime : nouveau num de paragraphe
}