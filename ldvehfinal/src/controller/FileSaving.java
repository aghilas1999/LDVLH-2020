package controller;
//Pour editor

import view.TextDisplay;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
//import javax.swing.AbstractAction;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileSaving extends AbstractAction{

	protected TextDisplay textdisplay;

    public FileSaving(String inputText, TextDisplay inputTextDisplay){
        super(inputText); //AL
        this.textdisplay = inputTextDisplay;
    }

    public void saving(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.setFileFilter(new FileNameExtensionFilter("text Documents", "txt"));
        //fileChooser.setFileFilter(new FileNameExtensionFilter("dot Documents", "dot"));

        int result = fileChooser.showSaveDialog(null);

        try{
            if(result == JFileChooser.APPROVE_OPTION){
                String content = "";
                this.textdisplay.getBook().getParagraphsList().get(this.textdisplay.getPara()).changeContent(this.textdisplay.getTextArea().getText(), this.textdisplay.getQuestionArea().getText());
            
            for (int i=0; i<this.textdisplay.getBook().getParagraphsList().size(); i++){
                content=content+ "[text]" + this.textdisplay.getBook().getParagraphsList().get(i).getContent() +"[/text]\n"+ "[question]" + this.textdisplay.getBook().getParagraphsList().get(i).getQuestion()+"[/question]\n";
        
                if(this.textdisplay.getBook().getParagraphsList().get(i).getChoicesList().size()>0) {
                	content += "[choice]";
                
	                for(int j=0; j<this.textdisplay.getBook().getParagraphsList().get(i).getChoicesList().size(); j++) {
	        	        if((content.length()-8) != (content.lastIndexOf("[choice]"))){
	                        content += "\n";
	                    }
	                    content = content +this.textdisplay.getBook().getParagraphsList().get(i).getChoicesList().get(j).getChoiceName()+" = to paragraph "+ (this.textdisplay.getBook().getParagraphsList().get(i).getChoicesList().get(j).getParaRedirection()+1);
	                }
	
	                content = content + "[/choice]\n";
                }
                if(this.textdisplay.getBook().getParagraphsList().get(i).getWeaponsList().size()>0) {
                	content += "[weapon]";
                
	                for(int j=0; j<this.textdisplay.getBook().getParagraphsList().get(i).getWeaponsList().size(); j++) {
	        	        if((content.length()-8) != (content.lastIndexOf("[weapon]"))){
	                        content += "\n";
	                    }
	                    content = content +this.textdisplay.getBook().getParagraphsList().get(i).getWeaponsList().get(j).getWeaponName()+" | Power : "+ (this.textdisplay.getBook().getParagraphsList().get(i).getWeaponsList().get(j).getPower());
	                }
	
	                content = content + "[/weapon]\n";
                }
                if(this.textdisplay.getBook().getParagraphsList().get(i).getFightsList().size()>0) {
                	content += "[fight]";
                
	                for(int j=0; j<this.textdisplay.getBook().getParagraphsList().get(i).getFightsList().size(); j++) {
	        	        if((content.length()-7) != (content.lastIndexOf("[fight]"))){
	                        content += "\n";
	                    }
	        	        String eName = (this.textdisplay.getBook().getParagraphsList().get(i).getFightsList().get(j).getEnemyName());
	        	        int ePV = (this.textdisplay.getBook().getParagraphsList().get(i).getFightsList().get(j).getEnemyPV());
	        	        String eWeapon = (this.textdisplay.getBook().getParagraphsList().get(i).getFightsList().get(j).getEnemyWeapon());
	        	        int ePower = (this.textdisplay.getBook().getParagraphsList().get(i).getFightsList().get(j).getEnemyPower());
	        	        int pvLose = (this.textdisplay.getBook().getParagraphsList().get(i).getFightsList().get(j).getPVToLose());
	        	        int pvWin = (this.textdisplay.getBook().getParagraphsList().get(i).getFightsList().get(j).getPVToWin());
	        	        
	                    content = content +eName+" | PV : "+ePV+" | Weapon : "+eWeapon+" | Power : "+ ePower + " | PV to lose : "+pvLose+" | PV to win : "+pvWin;
	                }
	
	                content = content + "[/fight]\n";
                }
                if(this.textdisplay.getBook().getParagraphsList().get(i).getPVminList().size()>0) {
                	content += "[PVremove]";
                
	                for(int j=0; j<this.textdisplay.getBook().getParagraphsList().get(i).getPVminList().size(); j++) {
	        	        if((content.length()-10) != (content.lastIndexOf("[PVremove]"))){
	                        content += "\n";
	                    }	        	        
	                    content = content +"- "+(this.textdisplay.getBook().getParagraphsList().get(i).getPVminList().get(j))+" PV";
	                }
	
	                content = content + "[/PVremove]\n";
                }
                if(this.textdisplay.getBook().getParagraphsList().get(i).getPVplusList().size()>0) {
                	content += "[PVadd]";
                
	                for(int j=0; j<this.textdisplay.getBook().getParagraphsList().get(i).getPVplusList().size(); j++) {
	        	        if((content.length()-7) != (content.lastIndexOf("[PVadd]"))){
	                        content += "\n";
	                    }	        	        
	                    content = content +"+ "+(this.textdisplay.getBook().getParagraphsList().get(i).getPVplusList().get(j))+" PV";
	                }
	
	                content = content + "[/PVadd]\n";
                }
                
                content += "==========\n";
            }

            FileWriter filename = new FileWriter(fileChooser.getSelectedFile()+".txt");
            BufferedWriter out = new BufferedWriter(filename);
            out.write(content);
            out.close();
            
            }
        }
            catch (IOException er){}
    }


    @Override //ActionListener//
    public void actionPerformed(ActionEvent e) {
        this.saving();
    }

}