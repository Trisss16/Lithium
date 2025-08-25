package lithium.Expression;

public class IntExpression extends Expression {
    
    public IntExpression(String expression) {
        super(expression);
        operators = new String[]{"+", "-", "*", "/"};
        
        //System.out.println(expression);
        if (!isExpression(expression)) {
            System.out.println("Error: invalid expression.");
            System.exit(0);
        }
    }
    
    
    @Override
    protected boolean isValidValue(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    
    //para llamar a evaluate por fuera del metodo sin pasar la expresion cada vez
    public int evaluate() {
        return evaluate(expression);
    }
    
    public int evaluate(String str) {
        /*cuando se evaluen expresiones anidadas podria recibir algun numero que se puede parsear directamente, antes
        de tratar str como una expresion checa si es parseable y si lo es solo regresa el valor*/
        if (isValidValue(str)) return Integer.parseInt(str);
        
        int value;
        str = getCleanExpression(str);
        String[] splitStr = str.split(" ");
        
        
        //evalua una expresion simple con solo numeros
        if (splitStr.length == 3) {
            value = doOperation(Integer.parseInt(splitStr[0]), Integer.parseInt(splitStr[2]), splitStr[1]);
            return value;
        }
        
        //separa los dos valores
        int operatorPos = getMainOperator(str);
        String expression1 = str.substring(0, operatorPos - 1);
        String expression2 = str.substring(operatorPos + 2);
        String op = str.substring(operatorPos, operatorPos + 1);
        
        int evaluated1 = evaluate(expression1);
        int evaluated2 = evaluate(expression2);
        
        value = doOperation(evaluated1, evaluated2, op);
        
        //System.out.println(expression1 + "\n" + expression2 + "\n" + op);
        return value;
    }
    
    protected int doOperation(int value1, int value2, String operator) {
        int value;
        
        switch(operator) {
            case "+":
                value = value1 + value2;
                break;
                    
            case "-":
                value = value1 - value2;
                break;
                
            case "*":
                value = value1 * value2;
                break;
                
            case "/":
                value = value1 / value2;
                break;
                    
            default:
                value = 0;
                break;
        }
            
        return value;
    }
}
