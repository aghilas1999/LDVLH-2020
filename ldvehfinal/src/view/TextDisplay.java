package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import model.Book;

//@SuppressWarnings("serial")
public class TextDisplay extends JPanel{
    private JTextArea text; //= new JTextArea()
    private JTextArea question; //= new JTextArea()
    private JLabel label; //= new JLabel()
    private Book book;
    private int para;


    public TextDisplay(Book inputBook){
        this.text = new JTextArea();
        this.question = new JTextArea();
        this.label = new JLabel();
        //

        // 103, 191, 205
        //int red = 103;
        ////int green = 191;
        //int blue = 205;
        //Color myBlue = new Color(red,green,blue);
        //panel.setBackground(new Color(103,191,205));
        this.para = 0;
        this.book = inputBook;
        this.text.setLineWrap(true);
        this.question.setBackground(new Color(200,240,218));
    
        this.label.setText("Paragraph number " + this.book.getParagraphsList().get(0).getNumPara());
        this.text.setText(this.book.getParagraphsList().get(0).getContent());
        this.question.setText(this.book.getParagraphsList().get(0).getQuestion());

        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.NORTH);//ou CENTER
        this.add(text,BorderLayout.CENTER);//ou SOUTH
        this.add(question,BorderLayout.SOUTH);//ou NORTH

        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception exception){
            exception.printStackTrace();
        }

    }


    public JTextArea getTextArea(){
        return this.text;
    }

    public JTextArea getQuestionArea(){
        return this.question;
    }

    public Book getBook(){
        return this.book;
    }

    public int getPara(){
        return this.para;
    }

    public JLabel getLabel(){
        return this.label;
    }

    /*public void setBook(Book inputBook){
        this.book = inputBook;
    }*/

    
    public void editPara(int i){
        this.para=i;
        label.setText("Paragraphe n°" + this.book.getParagraphsList().get(i).getNumPara());
        text.setText(this.book.getParagraphsList().get(i).getContent());
        question.setText(this.book.getParagraphsList().get(i).getQuestion());
    }
    
    
    
    

}