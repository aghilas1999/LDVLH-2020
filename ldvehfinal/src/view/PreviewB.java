package view;

import java.util.*;

import javax.swing.tree.DefaultMutableTreeNode;

import model.Book;

public class PreviewB extends DefaultMutableTreeNode implements Observer{
    private Book book;

    public PreviewB(Book inputBook){
        this.book = inputBook;
        this.book.addObserver(this);
        this.creation();
    }

    public void creation(){
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)this.getRoot();
        root.removeAllChildren();

        for(int i = 0; i<this.book.getParagraphsList().size(); i++){
            Underfault para = new Underfault("Paragraph " + this.book.getParagraphsList().get(i).getNumPara(), i);
            this.add(para);
        }
    }

    public void update(Observable observable, Object obj){
        this.creation();
    }
}