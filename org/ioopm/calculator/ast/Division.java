package org.ioopm.calculator.ast;

public class Division extends Binary{
    
    public Division(SymbolicExpression lhs, SymbolicExpression rhs){
        super(lhs,rhs);
    }

    @Override 
    public String getName(){
        return "/";
    }
    
    @Override 
    public int getPriority(){
        return 100;
    }

    @Override 
    public SymbolicExpression eval(Enviroment enviroment){
        SymbolicExpression lhs = this.getLhs().eval(enviroment);
        SymbolicExpression rhs = this.getRhs().eval(enviroment);

        if(lhs.isConstant() && rhs.isConstant()){
            if(rhs.getValue()==0){
                throw new RuntimeException("Division with 0");
            }
            return new Constant(lhs.getValue()/rhs.getValue());
        }
        return new Division(lhs, rhs);
    }
}