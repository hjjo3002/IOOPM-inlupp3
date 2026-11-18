package org.ioopm.calculator.ast;

public class Log extends Unary{

    
    public Log(SymbolicExpression lhs){
        super(lhs);
    }

    
    @Override 
    public String getName(){
        return "Log";
    }

    @Override 
    public SymbolicExpression eval(Environment enviroment) {
        SymbolicExpression lhs = this.getLhs().eval(enviroment);
        if (lhs.isConstant()) {
            return new Constant(Math.log(lhs.getValue()));
        } else {
            return new Log(lhs);
        }
    }
}