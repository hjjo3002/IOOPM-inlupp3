package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
    private SymbolicExpression lhs;

    public Unary(SymbolicExpression lhs){
        this.lhs = lhs;
    }

    @Override 
    public String toString(){
        String lhsString = lhs.toString();
        if(lhs.getPriority()<this.getPriority()){
            lhsString = "(" + lhsString + ")";
        }
        return this.getName() + " " + lhsString;
    }

    @Override 
    public int getPriority(){
        return 100;
    }

    public boolean equals(Object other){
        if(other instanceof Unary){
            return equals((Unary) other);
        }
        return false;
    }

    public boolean equals(Unary other){
        return this.getName().compareTo(other.getName())==0; 
    }

    protected SymbolicExpression getLhs(){
        return this.lhs;
    }


}