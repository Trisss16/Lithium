package lithium;
import java.io.IOException;
import java.nio.file.*;
import lithium.Expression.IntExpression;
import lithium.Expression.FloatExpression;

public class Lithium {
    
    static Path parentFile;

    public static void main(String[] args) {
        //IntExpression iexp = new IntExpression("((2 * (1 / 2)) + (2 - 1))");
        /*IntExpression iexp = new IntExpression("((1 - 2) * (10 / (4 / 1)))");
        System.out.println(iexp.evaluate());
        
        FloatExpression fexp = new FloatExpression("((1 - 2) * (10 / (4 / 1)))");
        System.out.println(fexp.evaluate());*/
        
        if (args.length == 0) {
            //llamar a una funcion que imprima información y comandos si no se reciben argumentos
            System.out.println("Especify a file to compile.");
            return;
        }
        
        
        
        try {
            Path path = Paths.get(args[0]); //ruta del archivo que se especificó
            path = path.toAbsolutePath(); //ruta absoluta, considerando la ruta donde se llamo al programa en la consola
            parentFile = path.getParent(); //ruta de la carpeta donde se encuentra el archivo, para acceder al resto de modulos

            System.out.println("Ruta relativa: " + path);
            System.out.println("Ruta absoluta: " + parentFile);

            // 5. Leer contenido
            String content = Files.readString(path);
            System.out.println("\nContenido del archivo:\n");
            System.out.println(content);


        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        
    }
    
}
