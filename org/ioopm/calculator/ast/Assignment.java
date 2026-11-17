package org.ioopm.calculator.ast;

public class Assignment extends Binary{
    
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs){
        super(lhs,rhs);
    }

    @Override
    public String getName() {
        return "=";
    }

    @Override 
    public int getPriority(){
        return 10;
    }

    @Override 
    public SymbolicExpression eval(Enviroment enviroment){
        SymbolicExpression lhs = this.getLhs().eval(enviroment);
        SymbolicExpression rhs = this.getRhs();

        if(rhs.isVariable()){
            Variable rhsVariable = (Variable) rhs;
            enviroment.put(rhsVariable, lhs);
            //System.out.println("lhs = "+ lhs);
            //System.out.println("rhs = "+rhs);
            return lhs;
        }
        throw new RuntimeException("Must be variable on right hand side!");
    }
}