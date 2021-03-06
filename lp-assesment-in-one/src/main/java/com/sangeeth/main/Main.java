package com.sangeeth.main;

import com.sangeeth.assesThree.CarParckAssistant;
import com.sangeeth.assesThree.CarParckSystem;
import com.sangeeth.assesThree.Vehicle;
import com.sangeeth.assesOne.Filereader;
import com.sangeeth.assesTwo.ReversObjInt;
import com.sangeeth.assesone.Filewriter;
import com.sangeeth.util.ColorBank;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sangeeth.util.Constants.*;

/**
 * @author dtsangeeth
 * @created 13 / 12 / 2020
 * @project LPTraining
 */
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    static List<Vehicle> vehicleslist = new ArrayList<>();
    public Scanner sc;
    Filereader fr = new Filereader("../"+DIRECTORY);
    ReversObjInt roi = new ReversObjInt("../"+DIRECTORY);

    public static void main(String[] args) {
        System.out.println(ColorBank.RED + "\t \t \t \tW E L C O M E " + ColorBank.RESET);
        System.out.println();
        System.out.println(ColorBank.PURPLE + "\t \t A S S I G N M E N T \t O N E & T W O" + ColorBank.RESET);
        System.out.println();
        Main m = new Main();
        m.display();
    }

    public void display(){

        sc = new Scanner(System.in);
        int option;

        System.out.println("\n-----------------------------------------------------");
        System.out.println("- - - - - - - - - - - Main Menu- - - - - - - - - - - ");
        System.out.println();
        System.out.println("1. Insert new Words / Number");
        System.out.println("2. Read All Saved Text Files");
        System.out.println("3. Convert to Uppercase");
        System.out.println("4. Covert to Lowercase");
        System.out.println("5. Show after revers digit");
        System.out.println("6. Log into CarPark system");
        System.out.println("0. Exit Program");
        System.out.println();
        try {
            System.out.print(ColorBank.CYAN+"Enter option : "+ColorBank.RESET);
            option = sc.nextInt();
            switch (option){
                case 1:
                    insertText();
                    break;
                case 2:
                    readTextFile();
                    break;
                case 3:
                    conToUpperCase();
                    break;
                case 4:
                    conToLowerCase();
                    break;
                case 5:
                    reversInt();
                    break;
                case 6:
                    CarParckSystem carParckSystem = new CarParckAssistant();
                    carParckSystem.initialize(vehicleslist);
                case 0:
                    System.exit(0);
                    break;
                default:
                    LOGGER.info("Invalid option!");
                    display();
                    break;
            }
        }catch (NumberFormatException e){
            LOGGER.error("Invalid option!");
            sc.hasNextInt(); //consumes the type mismatch exception
            display();
        }catch (InputMismatchException ex){
            LOGGER.error("Invalid option!");
            display();
        }catch (IOException io){
            LOGGER.error("Text File not found!");
            display();
        }

    }


    public void insertText (){
        System.out.println();
        System.out.print(ColorBank.BLUE + "Enter your Text : " +ColorBank.RESET);
        sc = new Scanner(System.in);
        String textIn = sc.nextLine();
        Filewriter fw;

        try {
            if (validateString(textIn)){
                fw = new Filewriter(TXTFILEONE);
                fw.writeStringToTxtFile(textIn);

            }else {
                fw = new Filewriter(TXTFILETWO);
                fw.writeStringToTxtFile(textIn);
            }
        } catch (IOException e) {
            LOGGER.error("Sorry! The program could not locate the text file",e);
            insertText();
        }
        display();
    }

    public boolean validateString(String inp){

        boolean numeric = true;
        numeric = inp.matches("-?\\d+(\\.\\d+)?");
        if (numeric){
            return false;
        }else {
            return true;
        }
    }

    public void readTextFile (){

        try {
            fr.printAllFileContent();
        } catch (FileNotFoundException e) {
            LOGGER.error("Sorry... File could not found !", e);
        } catch (IOException e) {
            LOGGER.error("Sorry! The program could not locate the text file", e);
        }
        display();
    }

    public void conToUpperCase(){
        fr.toConChar("UPPER");
        display();
    }

    public void conToLowerCase(){
        fr.toConChar("LOWER");
        display();
    }

    public void reversInt(){
        try {
            roi.reverseNumberFirstMeth();
            roi.reverseNumberSecondMeth();
        } catch (IOException e) {
            e.printStackTrace();
        }
        display();
    }

}