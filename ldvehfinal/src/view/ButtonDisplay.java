package view;

import javax.swing.*;

public class ButtonDisplay extends JPanel{
    protected JButton previousButton;
    protected JButton nextButton;
    protected JButton addButton;
    protected JButton removeButton;  


    public ButtonDisplay(TextDisplay text){
        this.previousButton = new JButton("<-");
        this.addButton = new JButton("Add");
        this.removeButton = new JButton("Remove");
        this.nextButton = new JButton("->");

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        this.add(previousButton); //sans le this??
        this.add(addButton);
        this.add(removeButton);
        this.add(nextButton);
    }

    public JButton getPreviousButton(){
        return this.previousButton;
    }

    public JButton getAddButton(){
        return this.addButton;
    }

    public JButton getRemoveButton(){
        return this.removeButton;
    }

    public JButton getNextButton(){
        return this.nextButton;
    }
    
    
    
    

}