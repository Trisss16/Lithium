package lithium.Expression;

public abstract class Expression {
    
    /*FORMATO DE UNA EXPRESIÓN: (value1 operator value2)
    ejemplo con int: (3 + 4)
    ejemplo con string: ("Hola, " .. "como estás?")
    ejemplo con boolean: (true == false)
    */
    
    protected String expression;
    protected String[] operators;
    
    //los datos de la expresión recibida, todos son strings hasta que en las clases hijas se intenten convertir
    protected String value1;
    protected String value2;
    protected String operator;
    
    public Expression(String expression) {
        this.expression = expression;
    }
    
    public String getExpression() {
        return expression;
    }
    
    protected final boolean isExpression(String str) {
        
        //primero comprueba que el string tenga contenido
        if (str == null || str.length() < 1) return false;
        
        if (isValidValue(str)) return true;
        
        //comprueba que tenga los parentesis
        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            str = getCleanExpression(str);
        } else {
            return false;
        }
        
        String[] splitStr = str.split(" ");
        
        if (splitStr.length == 3 && isValidValue(splitStr[0]) && isOperator(splitStr[1]) && isValidValue(splitStr[2])) {
            return true; //true si tiene exactamente dos valores, un operador y todos son validos
        } else if (splitStr.length < 3) {
            return false; //false si tiene menos de 3 palabras
        }
        
        /*si tiene mas de 3 palabras significa que hay más expresiones dentro, asi que obtiene la posición de donde se encuentra el operador principal
        (el operador en medio de las dos expresiones/numeros, ignorando el resto de los operadores de expresiones interiores)*/
        int operatorPos = getMainOperator(str);
        
        if (operatorPos == -1) return false; //no encontró operador principal
        
        String expression1 = str.substring(0, operatorPos - 1);
        String expression2 = str.substring(operatorPos + 2);
        
        if (isExpression(expression1) && isExpression(expression2)) {
            return true;
        }
        
        return false;
    }
    
    //obtiene la posicion del operador que hace la operación principal, ignorando los operadores de las expresiones interiores
    //recibe el string "limpio", sin los parentesis para indicar la expresión
    protected int getMainOperator(String str) {
        int depth = 0;
        
        for (int i = 0; i < str.length(); i++) {
           char c = str.charAt(i);
           
            if (c == '(') {
                depth++;
            } else if (c == ')') {
                depth--;
            } else if (isOperator("" + c) && depth == 0) {
                return i;
            }
        }
        
        return -1; //regresa -1 si no encontró ningun operador principal
    }
    
    
    protected boolean isOperator(String str) {    
        for (String i: operators) {
            if (str.equals(i)) {
                return true;
            }
        }
        return false; //si despues de comparar con todos los operadores no salio de la funcion, significa que no es operador
    }
    
    
    //"limpia" una expresion (le quita los parentesis)
    protected String getCleanExpression(String str) {
        return str.substring(1, str.length() - 1);
    }
    
    //Cada tipo de expresion evalua sus valores y operadores de la forma que necesiten
    protected abstract boolean isValidValue(String str);
    
}
