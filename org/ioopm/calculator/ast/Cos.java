package org.ioopm.calculator.ast;

public class Cos extends Unary{
    
    public Cos(SymbolicExpression lhs){
        super(lhs);
    }
    
    @Override 
    public String getName(){
        return "cos";
    }

    
    public SymbolicExpression eval(Enviroment enviroment) {
        SymbolicExpression lhs = this.getLhs().eval(enviroment);
        if (lhs.isConstant()) {
            return new Constant(Math.cos(lhs.getValue()));
        } else {
            return new Cos(lhs);
        }
    }
}