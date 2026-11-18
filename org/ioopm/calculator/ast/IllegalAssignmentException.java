package org.ioopm.calculator.ast;

public class IllegalAssignmentException extends RuntimeException{
    public IllegalAssignmentException(){
        super();
    }
    public IllegalAssignmentException(String str){
        super(str);
    }
}