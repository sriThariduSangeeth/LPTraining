package com.sangeeth.main;

import com.sangeeth.parkmanager.CarParckAssistant;
import com.sangeeth.parkmanager.CarParckSystem;
import com.sangeeth.parkmanager.Vehicle;
import com.sangeeth.util.ColorBank;

import java.io.IOException;
import java.util.*;

/**
 * @author dtsangeeth
 * @created 18 / 12 / 2020
 * @project lp-exception-imp
 */
public class Main {

    static List<Vehicle> vehicleslist = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.display();
    }

    public void display(){
        try {
            CarParckSystem carParckSystem = new CarParckAssistant();
            carParckSystem.initialize(vehicleslist);
        } catch (NumberFormatException e){
            System.out.println(ColorBank.RED + "\nInvalid option!" + ColorBank.RESET);
            display();
        }catch (InputMismatchException ex){
            System.out.println(ColorBank.RED + "\nInvalid option!" + ColorBank.RESET);
            display();
        }catch (IOException io){
            System.out.println(ColorBank.RED + "\nText File not found!" + ColorBank.RESET);
            display();
        }
    }
}
