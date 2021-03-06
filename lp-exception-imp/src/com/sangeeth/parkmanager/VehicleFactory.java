package com.sangeeth.parkmanager;

import java.util.Date;

/**
 * @author dtsangeeth
 * @created 18 / 12 / 2020
 * @project lp-exception-imp
 */
public class VehicleFactory {

    public static Vehicle getVehicle (String type , String id , String brand , Date date , Double cargo , int tire , String color , int door , String capacity){

        if(type.equalsIgnoreCase("Car")){
            return new Car(type,id,brand,date,color,door);
        }else if(type.equalsIgnoreCase("Van")){
            return new Van(type,id,brand,date,cargo,tire);
        }else if(type.equalsIgnoreCase("Motorbike")){
            return new Motorbike(type,id,brand,date,capacity);
        }
        return null;
    }
}
