package org.ioopm.calculator.ast;

public class Negation extends Unary{
    
    public Negation(SymbolicExpression lhs){
        super(lhs);
    }

    
    @Override 
    public String getName(){
        return "-";
    }

    @Override 
    public SymbolicExpression eval(Enviroment enviroment) {
        SymbolicExpression lhs = this.getLhs().eval(enviroment);
        if (lhs.isConstant()) {
            return new Constant(lhs.getValue());
        } else {
            return lhs; //new constant???
        }
    }
}