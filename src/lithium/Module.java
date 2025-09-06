package lithium;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author trili
 */

//representa un modulo de lithium
public class Module {
    
    private String absolutePath;
    private File file;
    private String[] lines;
    
    public Module(String moduleName) {
        //Recibe la ruta absoluta del modulo, y comprueba que el archivo sea .ltm
        
        this.absolutePath = Lithium.parentFile + "\\" + moduleName;
        file = new File(absolutePath);
        
        checkFileType();
        
        if (!file.exists()) {
            System.out.println("The file does not exist.");
            System.exit(0);
        }
        
        System.out.println("reading file");
        try {  
            ArrayList<String> linesList = new ArrayList<String>();
            
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                linesList.add(sc.nextLine());
            }
            
            lines = linesList.toArray(lines);
            
        } catch(Exception e) {
            System.out.println("Could not read file: " + e);
            System.exit(0);
        }
        
        for (String i: lines) {
            System.out.println(i);
        }
        
    }
    
    private void checkFileType() {
        String fileType = absolutePath.substring(absolutePath.length() - 4);
        System.out.println(fileType);
        
        if (!fileType.equals(".ltm")) {
            System.out.println("Invalid file type.");
            System.exit(0);
        }
        
        if (!file.canRead()) {
            System.out.println("coulnt read file");
            System.exit(0);
        }
    }
}
