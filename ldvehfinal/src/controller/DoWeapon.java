package controller;

import model.Book;
import view.WeaponCreation;

public class DoWeapon extends AL{

    public DoWeapon(Book inputBook){
        super(inputBook); //AL
    }


    //-@Override //AL//
    public void actionToDo(){
        WeaponCreation newWeapon = new WeaponCreation(book);
        //new WeaponCreation(book);
    }
}