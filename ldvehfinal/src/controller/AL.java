package controller;

import model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AL implements ActionListener{
	
	protected Book book;

    public AL(Book inputBook){
        this.book = inputBook;
    }
  
    public void actionPerformed(ActionEvent e) {
        this.actionToDo();
    }
    
    public abstract void actionToDo();
    

        /*public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        }

        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}*/
}