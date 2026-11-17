package org.ioopm.calculator.ast;

public class Sin extends Unary{
    
    public Sin(SymbolicExpression lhs){
        super(lhs);
    }
    
    @Override 
    public String getName(){
        return "sin";
    }

    @Override 
    public SymbolicExpression eval(Enviroment enviroment) {
        SymbolicExpression lhs = this.getLhs().eval(enviroment);
        if (lhs.isConstant()) {
            return new Constant(Math.sin(lhs.getValue()));
        } else {
            return new Sin(lhs);
        }
    }
}