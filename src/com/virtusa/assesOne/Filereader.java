package com.virtusa.assesOne;

import com.virtusa.util.ColorBank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.virtusa.util.Constants.TXTFILEONE;
import static com.virtusa.util.Constants.TXTFILETWO;

/**
 * @author dtsangeeth
 * @created 13 / 12 / 2020
 * @project LPTraining
 */
public class Filereader {

    public File directory;
    public File[] listOfFiles;
    public BufferedReader br = null;
    public FileReader fr = null;

    public Filereader(String path){
        directory = new File(path);
        listOfFiles = directory.listFiles();
    }


    public void printAllFileContent() throws IOException {


        for (File file : listOfFiles) {
            // Access file.getName() or do anything else here
            String line;
            if(file.getName().equalsIgnoreCase(TXTFILEONE) || file.getName().equalsIgnoreCase(TXTFILETWO)){
                br = new BufferedReader(new FileReader(file.getName()));

                if(!isEmptyFile(file.getName())){
                    System.out.println(ColorBank.YELLOW+"\nFile Name is : " + file.getName()+""+ColorBank.RESET);
                    int con = 1;
                    while ((line = br.readLine()) != null) {
                        System.out.println("0"+con+".\t "+line);
                        con++;
                    }
                    if (br != null) br.close();
                }else {
                    System.out.println(ColorBank.RED +"No visible value in "+file.getName()+ ColorBank.RESET);
                }
            }
        }
    }

    //checking if the text file is empty
    static boolean isEmptyFile(String source) {
        try {

            for (String line : Files.readAllLines(Paths.get(source))) {
                if (line != null && !line.trim().isEmpty()) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Default to true.
        return true;
    }

    public void toConChar(String v){

        System.out.println("- - - - - - - - - - - - -");
        System.out.println("CONVERT INTO "+v+" CASE");
        System.out.println("- - - - - - - - - - - - -");
        System.out.println();
        for (File file : listOfFiles) {
            if(file.getName().equalsIgnoreCase(TXTFILEONE)){
                try {

                    fr = new FileReader(TXTFILEONE);
                    char[] ch = new char[(int)file.length()];
                    fr.read(ch);
                    for (char ch1 : ch) {
                        if(v.equalsIgnoreCase("upper")){
                            System.out.print(Character.toUpperCase(ch1));
                        }else {
                            System.out.print(Character.toLowerCase(ch1));
                        }

                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("- - - - - - - - - - - - -");
    }

}
