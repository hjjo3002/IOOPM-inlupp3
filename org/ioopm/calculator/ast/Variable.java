package org.ioopm.calculator.ast;

public class Variable extends Atom{
    private String id;

    public Variable(String id){
        this.id = id;
    }
    
    public String toString(){
        return id;
    }
    
    public String getVariableName(){
        return this.toString();
    }

    public boolean equals(Object other){
        if(other instanceof Variable){
            return equals((Variable) other);
        }
        return false;
    }

    public boolean equals(Variable other){
        return this.id.compareTo(other.id)==0;
    }

    @Override 
    public SymbolicExpression eval(Enviroment enviroment){

        if(enviroment.containsKey(this)){
            SymbolicExpression value = enviroment.get(this);
            return value;
        }
        return this;
    }

    @Override 
    public boolean isVariable(){
        return true;
    }

    @Override
    public int hashCode() {
        String name = this.toString();
        return name.hashCode();
    }
}