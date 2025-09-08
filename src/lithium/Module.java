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
        //Recibe el nombre del modulo y comprueba que el archivo sea .ltm
        
        this.absolutePath = Lithium.parentFile + "\\" + moduleName;
        System.out.println(absolutePath);
        file = new File(absolutePath);
        
        checkFileType();
        
        if (!file.exists()) {
            System.out.println("The file does not exist.");
            System.exit(0);
        }
        
        System.out.println("reading file");
        
        try {  
            ArrayList<String> linesList = new ArrayList<>();
            
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                linesList.add(sc.nextLine());
            }
            
            lines = linesList.toArray(new String[0]);
            
        } catch(FileNotFoundException e) {
            System.out.println("Could not read file: " + e);
            System.exit(0);
        }
        
        //imprimir el contenido
        System.out.println("Contenido del modulo:");
        for (String i: lines) {
            System.out.println(i);
        }
        
    }
    
    private void checkFileType() {
        String fileType = absolutePath.substring(absolutePath.length() - 4);
        
        if (!fileType.equals(".ltm")) {
            System.out.println("Invalid file type.");
            System.exit(0);
        }
        
        if (!file.canRead()) {
            System.out.println("could not read file.");
            System.exit(0);
        }
    }
}
