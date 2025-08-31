package lithium.Expression;


public class BoolExpression extends Expression{

    public BoolExpression(String expression) {
        super(expression);
        
        operators = new String[]{"==", "!=", };
    }

    @Override
    protected boolean isValidValue(String str) {
        return true;
    }
    
}
