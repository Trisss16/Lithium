package lithium;
import lithium.Expression.IntExpression;
import lithium.Expression.FloatExpression;

public class Lithium {

    public static void main(String[] args) {
        //IntExpression iexp = new IntExpression("((2 * (1 / 2)) + (2 - 1))");
        IntExpression iexp = new IntExpression("((1 - 2) * (10 / (4 / 1)))");
        System.out.println(iexp.evaluate());
        
        FloatExpression fexp = new FloatExpression("((1 - 2) * (10 / (4 / 1)))");
        System.out.println(fexp.evaluate());
    }
    
}
