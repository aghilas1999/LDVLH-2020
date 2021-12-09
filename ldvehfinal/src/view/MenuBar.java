package view;

import model.*;
import java.util.*;

import javax.swing.*;

import controller.FileOpening;
import controller.FileSaving;

public class MenuBar extends JMenuBar {
    private UserInterface userinterface;
    private JMenu file;
    //private JMenuItem open;
    private FileSaving saving;
    private FileOpening opening;

    
    public MenuBar(UserInterface inputUI){
        this.userinterface = inputUI;
        this.file = new JMenu("File");
        this.saving = new FileSaving("Save As", this.userinterface.getTextDisplay());
        this.opening = new FileOpening("Open File");

        this.add(this.file);


        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception exception){
            exception.printStackTrace();
        }

        this.file.add(new JMenuItem(this.opening));
        this.file.add(new JMenuItem(this.saving));

    }
}