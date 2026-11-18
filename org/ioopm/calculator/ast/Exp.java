package org.ioopm.calculator.ast;

public class Exp extends Unary{
    
    public Exp(SymbolicExpression lhs){
        super(lhs);
    }

    
    @Override 
    public String getName(){
        return "^";
    }

    @Override 
    public SymbolicExpression eval(Environment enviroment) {
        SymbolicExpression lhs = this.getLhs().eval(enviroment);
        if (lhs.isConstant()) {
            return new Constant(Math.exp(lhs.getValue()));
        } else {
            return new Exp(lhs);
        }
    }
}