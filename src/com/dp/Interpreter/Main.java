package com.dp.Interpreter;

interface Expression {
    boolean interpreter(String con);
}

class TerminalExpression implements Expression{
    String data;
    public TerminalExpression(String data) {
        this.data = data;
    }
    @Override
    public boolean interpreter(String con) {
        if(con.contains(data)) {
            return true;
        }
        else {
            return false;
        }
    }
}

class OrExpression implements Expression{
    Expression expr1;
    Expression expr2;
    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    @Override
    public boolean interpreter(String con) {
        return expr1.interpreter(con) || expr2.interpreter(con);
    }
}

class AndExpression implements Expression{
    Expression expr1;
    Expression expr2;
    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    @Override
    public boolean interpreter(String con) {
        return expr1.interpreter(con) && expr2.interpreter(con);
    }
}

public class Main {
    public static void main(String[] args) {
        Expression person1 = new TerminalExpression("Simbu");
        Expression person2 = new TerminalExpression("vishal");
        Expression isSingle = new OrExpression(person1, person2);

        Expression Ranbir = new TerminalExpression("Ranbir");
        Expression committed = new TerminalExpression("Committed");
        Expression isCommitted = new AndExpression(Ranbir, committed);

        System.out.println(isSingle.interpreter("vishal"));
        System.out.println(isCommitted.interpreter("Single, vishal"));
    }
}
