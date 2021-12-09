package view;

import javax.swing.tree.DefaultMutableTreeNode;

public class Underfault extends DefaultMutableTreeNode {
    private int numParagraph;

    public Underfault(String text, int inputNumPara){
        super(text);
        this.numParagraph = inputNumPara;
    }

    public int getNumParagraph(){
        return this.numParagraph;
    }
}