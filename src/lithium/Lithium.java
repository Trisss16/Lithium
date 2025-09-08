package lithium;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import lithium.Expression.IntExpression;
import lithium.Expression.FloatExpression;

public class Lithium {
    
    public static String parentFile;

    public static void main(String[] args) {
        //IntExpression iexp = new IntExpression("((2 * (1 / 2)) + (2 - 1))");
        /*IntExpression iexp = new IntExpression("((1 - 2) * (10 / (4 / 1)))");
        System.out.println(iexp.evaluate());
        
        FloatExpression fexp = new FloatExpression("((1 - 2) * (10 / (4 / 1)))");
        System.out.println(fexp.evaluate());*/
        
        ArrayList<Module> modules = new ArrayList<Module>();
        
        if (args.length == 0) {
            //llamar a una funcion que imprima información y comandos si no se reciben argumentos
            /*System.out.println("Especify a file to compile.");
            return;*/
            
            //para pruebas sin ejecutar en consola
            Path path = Paths.get("C:\\Users\\trili\\OneDrive\\Documentos\\lithium\\test\\test.ltm"); //ruta del archivo que se especificó
            parentFile = "C:\\Users\\trili\\OneDrive\\Documentos\\lithium\\test"; //ruta de la carpeta donde se encuentra el archivo, para acceder al resto de modulos
            
            modules.add(new Module("test.ltm"));
            
        } else {    
            
            Path path = Paths.get(args[0]); //ruta del archivo que se especificó
            path = path.toAbsolutePath(); //ruta absoluta, considerando la ruta donde se llamo al programa en la consola
            parentFile = path.getParent().toString(); //ruta de la carpeta donde se encuentra el archivo, para acceder al resto de modulos

            //System.out.println("Ruta relativa: " + path.toString());
            //System.out.println("Ruta absoluta: " + parentFile);
            
            //crea un nuevo modulo
            modules.add(new Module(args[0]));
            
        }
    }
    
    public static Module getModule(String moduleName) {
        return new Module(moduleName);
    }
    
}
