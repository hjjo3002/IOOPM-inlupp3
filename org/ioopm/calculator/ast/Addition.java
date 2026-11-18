package org.ioopm.calculator.ast;

public class Addition extends Binary{
    
    public Addition(SymbolicExpression lhs, SymbolicExpression rhs){
        super(lhs,rhs);
    }

    @Override 
    public String getName(){
        return "+";
    }

    @Override 
    public int getPriority(){
        return 50;
    }

    @Override 
    public SymbolicExpression eval(Environment enviroment){
        SymbolicExpression lhs = getLhs().eval(enviroment);
        SymbolicExpression rhs = getRhs().eval(enviroment);

        if(lhs.isConstant() && rhs.isConstant()){
            return new Constant(rhs.getValue()+lhs.getValue());
        }
        return this;
    }
    
}