package org.ioopm.calculator.ast;

public class Subtraction extends Binary{
    
    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs){
        super(lhs,rhs);
    }

    
    @Override 
    public String getName(){
        return "-";
    }

    @Override 
    public int getPriority(){
        return 50;
    }

    @Override 
    public SymbolicExpression eval(Enviroment enviroment){
        SymbolicExpression lhs = this.getLhs().eval(enviroment);
        SymbolicExpression rhs = this.getRhs().eval(enviroment);

        if(lhs.isConstant() && getRhs().isConstant()){
            return new Constant(rhs.getValue()-lhs.getValue());
        }
        return this;
    }
    
}