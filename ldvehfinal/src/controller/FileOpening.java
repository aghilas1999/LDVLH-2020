package controller;
//Pour editor

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;

import model.Book;
import model.Paragraph;
import model.Weapon;
import view.UserInterface;
import model.Choice;
import model.Fight;

public class FileOpening extends AbstractAction{

    public FileOpening(String inputText){
        super(inputText); //AL
    }


    //-@Override //AL//
    public void actionPerformed(ActionEvent e){
        Book book = new Book();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.setFileFilter(new FileNameExtensionFilter("text Documents", "txt"));
        //fileChooser.setFileFilter(new FileNameExtensionFilter("dot Documents", "dot"));
        Paragraph.paraNull();
        int result = fileChooser.showOpenDialog(null);
        try{
            if(result == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                String text = "";
                String question = "";
                String choices = "";
                int i = 0;
                boolean textStart = false;
                boolean quesStart = false;
                boolean choiceStart = false;
                ArrayList<Choice> choicesList = new ArrayList<Choice>();//list of collected choices in a paragraph
                boolean weaponStart = false;
                ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();//list of collected weapons in a paragraph
                boolean fightStart = false;
                ArrayList<Fight> fightsList = new ArrayList<Fight>();//list of collected fights in a paragraph
                boolean pvMinStart = false;
                ArrayList<Integer> pvMinList = new ArrayList<Integer>();//list of collected pv to remove in a paragraph
                boolean pvPlusStart = false;
                ArrayList<Integer> pvPlusList = new ArrayList<Integer>();//list of collected pv to add in a paragraph
                
                
                while ((line = reader.readLine()) != null) {
                ///Text Reading
                    if (line.contains("[text]")){//start text reading
                        textStart = true;
                        if(line.contains("[/text]")) {//start and end on the same line
                            line = line.substring(6,line.indexOf("[/text]"));
                            textStart = false;
                        }else {//only start on this line
                            line = line.substring(line.indexOf("[text]") + 6);
                        }
                        text += line;
                    }
                    else if(line.contains("[/text]")) {//end text reading on other line
                        line = "\n" + line.substring(0,line.indexOf("[/text]"));
                        textStart = false;
                        text += line;
                    }
                    else if(textStart==true) {//reading text not in start and end line
                        line = "\n" + line.substring(0);
                        text += line;
                    }
                ///Question Reading
                    if (line.contains("[question]")){//start question reading
                        quesStart = true;
                        if(line.contains("[/question]")) {//start and end on the same line
                            line = line.substring(10,line.indexOf("[/question]"));
                            quesStart = false;
                        }else {//only start on this line
                            line = line.substring(line.indexOf("[question]") + 10);
                        }
                        question += line;
                    }
                    else if(line.contains("[/question]")) {//end question reading on other line
                        line = "\n" + line.substring(0,line.indexOf("[/question]"));
                        quesStart = false;
                        question += line;
                    }
                    else if(quesStart == true) {//reading question not in start and end line
                        line = "\n" + line.substring(0);
                        question += line;
                    }
                //Choices Reading
                    String choiceTitle;//Get title of choice
                    int idParagraph;//Get id of paragraph
                    if (line.contains("[choice]")){//start choice reading
                        choiceStart = true;
                        if(line.contains("[/choice]")) {//start and end on the same line
                            choiceTitle = line.substring(8,line.indexOf(" = to paragraph"));
                            idParagraph = Integer.parseInt(line.substring((line.indexOf("[/choice]")-1),line.indexOf("[/choice]")));
                            choiceStart = false;
                        }else {//only start on this line
                            choiceTitle = line.substring(8,line.indexOf(" = to paragraph"));
                            idParagraph = Integer.parseInt(line.substring((line.length()-1)));	
                        }
                        choicesList.add(new Choice(choiceTitle, idParagraph-1));//set a choice with the collected title and id
                    }
                    else if(line.contains("[/choice]")) {//end choice reading on other line
                    	choiceTitle = line.substring(0,line.indexOf(" = to paragraph"));
                        idParagraph = Integer.parseInt(line.substring((line.indexOf("[/choice]")-1),line.indexOf("[/choice]")));
                        choiceStart = false;
                        choicesList.add(new Choice(choiceTitle, idParagraph-1));//set a choice with the collected title and id
                    }
                    else if(choiceStart == true) {//reading choice not in start and end line
                    	choiceTitle = line.substring(0,line.indexOf(" = to paragraph"));
                        idParagraph = Integer.parseInt(line.substring((line.length()-1),(line.length())));
                        choicesList.add(new Choice(choiceTitle, idParagraph-1));//set a choice with the collected title and id
                    }
                  //Weapons Reading
                    String weaponTitle;//Get title of weapon
                    int weaponPower;//Get power of weapon
                    if (line.contains("[weapon]")){//start weapon reading
                        weaponStart = true;
                        if(line.contains("[/weapon]")) {//start and end on the same line
                            weaponTitle = line.substring(8,line.indexOf(" | Power : "));
                            weaponPower = Integer.parseInt(line.substring((line.indexOf("| Power : ")+10),line.indexOf("[/weapon]")));
                            weaponStart = false;
                        }else {//only start on this line
                        	weaponTitle = line.substring(8,line.indexOf(" | Power : "));
                        	weaponPower = Integer.parseInt(line.substring((line.indexOf(" | Power : ")+11)));	
                        }
                        weaponsList.add(new Weapon(weaponTitle, weaponPower));//set a weapon with the collected title and power
                    }
                    else if(line.contains("[/weapon]")) {//end weapon reading on other line
                    	weaponTitle = line.substring(0,line.indexOf(" | Power : "));
                    	weaponPower = Integer.parseInt(line.substring((line.indexOf("| Power : ")+10),line.indexOf("[/weapon]")));
                    	weaponStart = false;
                        weaponsList.add(new Weapon(weaponTitle, weaponPower));//set a weapon with the collected title and power
                    }
                    else if(weaponStart == true) {//reading weapon not in start and end line
                    	weaponTitle = line.substring(0,line.indexOf(" | Power : "));
                    	weaponPower = Integer.parseInt(line.substring((line.indexOf("| Power : ")+10)));
                    	weaponsList.add(new Weapon(weaponTitle, weaponPower));//set a weapon with the collected title and id
                    }
                    
                  //Fights Reading
                    String fightName;//Get name of fight enemy
                    int fightPV;//Get PV of fight enemy
                    String fightWeapon;//Get weapon of fight enemy
                    int fightPower;//Get power of fight enemy
                    int fightPVlose;//Get pv to lose of fight loser
                    int fightPVwin;//Get pv to win of fight winner
                    if (line.contains("[fight]")){//start fight reading
                        fightStart = true;
                        fightName = line.substring(7,line.indexOf(" | PV : "));
                        fightPV = Integer.parseInt(line.substring((line.indexOf("| PV : ")+7),line.indexOf(" | Weapon : ")));
                        fightWeapon = line.substring((line.indexOf("| Weapon : ")+11),line.indexOf(" | Power : "));
                        fightPower = Integer.parseInt(line.substring((line.indexOf("| Power : ")+10),line.indexOf(" | PV to lose : ")));
                        fightPVlose = Integer.parseInt(line.substring((line.indexOf("| PV to lose : ")+15),line.indexOf(" | PV to win : ")));
                        if(line.contains("[/fight]")) {//start and end on the same line
                        	fightPVwin = Integer.parseInt(line.substring((line.indexOf("| PV to win : ")+14),line.indexOf("[\fight]")));
                            fightStart = false;
                        }else {//only start on this line
                        	fightPVwin = Integer.parseInt(line.substring((line.indexOf("| PV to win : ")+14)));
                        }
                        fightsList.add(new Fight(fightName, fightPower,fightPV,fightWeapon, fightPVlose,fightPVwin));//set a weapon with the collected title and power
                    }
                    else if(line.contains("[/fight]")) {//end weapon reading on other line
                    	fightName = line.substring(7,line.indexOf(" | PV : "));
                        fightPV = Integer.parseInt(line.substring((line.indexOf("| PV : ")+7),line.indexOf(" | Weapon : ")));
                        fightWeapon = line.substring((line.indexOf("| Weapon : ")+11),line.indexOf(" | Power : "));
                        fightPower = Integer.parseInt(line.substring((line.indexOf("| Power : ")+10),line.indexOf(" | PV to lose : ")));
                        fightPVlose = Integer.parseInt(line.substring((line.indexOf("| PV to lose : ")+15),line.indexOf(" | PV to win : ")));
                        fightPVwin = Integer.parseInt(line.substring((line.indexOf("| PV to win : ")+14),line.indexOf("[/fight]")));
                        fightStart = false;
                        fightsList.add(new Fight(fightName, fightPower,fightPV,fightWeapon, fightPVlose,fightPVwin));//set a weapon with the collected title and power
                    }
                    else if(fightStart == true) {//reading weapon not in start and end line
                    	fightName = line.substring(0,line.indexOf(" | PV : "));
                        fightPV = Integer.parseInt(line.substring((line.indexOf("| PV : ")+7),line.indexOf(" | Weapon : ")));
                        fightWeapon = line.substring((line.indexOf("| Weapon : ")+11),line.indexOf(" | Power : "));
                        fightPower = Integer.parseInt(line.substring((line.indexOf("| Power : ")+10),line.indexOf(" | PV to lose : ")));
                        fightPVlose = Integer.parseInt(line.substring((line.indexOf("| PV to lose : ")+15),line.indexOf(" | PV to win : ")));
                        fightPVwin = Integer.parseInt(line.substring((line.indexOf("| PV to win : ")+14)));
                        fightsList.add(new Fight(fightName, fightPower,fightPV,fightWeapon, fightPVlose,fightPVwin));//set a weapon with the collected title and id
                    }
                    
                  //PV to remove Reading
                    int pvRemove;//Get power of weapon
                    if (line.contains("[PVremove]")){//start PV to remove reading
                        pvMinStart = true;
                        if(line.contains("[/PVremove]")) {//start and end on the same line
                            pvRemove = Integer.parseInt(line.substring((line.indexOf("[PVRemove]- ")+13),line.indexOf(" PV[/PVremove]")));
                            pvMinStart = false;
                        }else {//only start on this line
                        	pvRemove = Integer.parseInt(line.substring((line.indexOf("[PVRemove]- ")+13), line.indexOf(" PV")));
                        }
                        pvMinList.add(pvRemove);//set a pv removal with the collected value
                    }
                    else if(line.contains("[/PVremove]")) {//end weapon reading on other line
                    	pvRemove = Integer.parseInt(line.substring(2,line.indexOf(" PV[/PVremove]")));
                        pvMinStart = false;
                        pvMinList.add(pvRemove);//set a pv removal with the collected value
                    }
                    else if(pvMinStart == true) {//reading PV to remove not in start and end line
                    	pvRemove = Integer.parseInt(line.substring(2,line.indexOf(" PV")));
                        pvMinList.add(pvRemove);//set a pv removal with the collected value
                    }
                  //PV to add Reading
                    int pvAdd;//Get pv to add
                    if (line.contains("[PVadd]")){//start PV to add reading
                        pvPlusStart = true;
                        if(line.contains("[/PVadd]")) {//start and end on the same line
                        	pvAdd = Integer.parseInt(line.substring((line.indexOf("[PVadd]+ ")+9),line.indexOf(" PV[/PVadd]")));
                            pvPlusStart = false;
                        }else {//only start on this line
                        	pvAdd = Integer.parseInt(line.substring((line.indexOf("[PVadd]+ ")+9), line.indexOf(" PV")));
                        }
                        pvPlusList.add(pvAdd);//set a pv adding with the collected value
                    }
                    else if(line.contains("[/PVadd]")) {//end PV to add reading on other line
                    	pvAdd = Integer.parseInt(line.substring(2,line.indexOf(" PV[/PVadd]")));
                        pvPlusStart = false;
                        pvPlusList.add(pvAdd);//set a pv adding with the collected value
                    }
                    else if(pvPlusStart == true) {//reading PV to remove not in start and end line
                    	pvAdd = Integer.parseInt(line.substring(2,line.indexOf(" PV")));
                        pvPlusList.add(pvAdd);//set a pv adding with the collected value
                    }
                //End paragraph
                    if (line.contains("==========")){
                    Paragraph newPara = new Paragraph(text, question, false, false, i++);//create paragraph with collected arguments
                    for(int k= 0; k<choicesList.size(); k++) {//add to the paragraph every the choices accumulated in the list
                        newPara.addChoice(choicesList.get(k));
                    }
                    for(int k= 0; k<weaponsList.size(); k++) {//add to the paragraph every the weapons accumulated in the list
                        newPara.addWeapon(weaponsList.get(k));
                    }
                    for(int k= 0; k<fightsList.size(); k++) {//add to the paragraph every the fights accumulated in the list
                        newPara.addFight(fightsList.get(k));
                    }
                    for(int k= 0; k<pvMinList.size(); k++) {//add to the paragraph every the removal PV accumulated in the list
                        newPara.addMinPV(pvMinList.get(k));
                    }
                    for(int k= 0; k<pvPlusList.size(); k++) {//add to the paragraph every the adding PV accumulated in the list
                        newPara.addPlusPV(pvPlusList.get(k));
                    }
                    book.addParaEnd(newPara);
                    ///reset variables for the next paragraph
                    text = "";
                    question = "";
                    choicesList = new ArrayList<Choice>();
                    weaponsList = new ArrayList<Weapon>();
                    fightsList = new ArrayList<Fight>();
                    pvMinList = new ArrayList<Integer>();
                    pvPlusList = new ArrayList<Integer>();
                }
             }
                reader.close();
            }
          }
            catch (IOException ex) {
              System.out.println(ex);
              System.out.println("erreur d'ouverture");
            }
            /**Open a new window with the opened book**/
            UserInterface userInterface = new UserInterface(book);
            AL addAL = new DoAdd(book,userInterface);
            AL removeAL = new DoRemoval(book,userInterface);
            AL previousAL = new ToPreviousPara(book,userInterface);
            AL nextAL = new ToNextPara(book,userInterface);

            userInterface.getButtonDisplay().getPreviousButton().addActionListener(previousAL);
            userInterface.getButtonDisplay().getAddButton().addActionListener(addAL);
            userInterface.getButtonDisplay().getRemoveButton().addActionListener(removeAL);
            userInterface.getButtonDisplay().getNextButton().addActionListener(nextAL);
    }


}