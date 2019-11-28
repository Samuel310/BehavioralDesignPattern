package com.dp.ChainOfResponsibility;

interface Chain {
    void setNext(Chain chain);
    void process(Decision decision);
}

class Wash implements Chain{
    private Chain chain;
    @Override
    public void setNext(Chain chain) {
        this.chain = chain;
    }
    @Override
    public void process(Decision decision) {
        if (decision.getDecision().equals("Washing")){
            System.out.println(decision.getDecision());
        }
        else {
            System.out.println("This is: Washing, Going to next obj in the chain..");
            chain.process(decision);
        }
    }
}

class Clean implements Chain {
    private Chain chain;
    @Override
    public void setNext(Chain chain) {
        this.chain = chain;
    }
    @Override
    public void process(Decision decision) {
        if (decision.getDecision().equals("Cleaning")){
            System.out.println(decision.getDecision());
        }else {
            System.out.println("This is: Cleaning, Going to next obj in the chain..");
            chain.process(decision);
        }
    }
}

class Decision {
    private String decision;
    public Decision(String decision){
        this.decision = decision;
    }
    public String getDecision(){
        return decision;
    }
}

public class Main {
    public static void main(String[] args) {
        Chain c1 = new Wash();
        Chain c2 = new Clean();
        c1.setNext(c2);
        c1.process(new Decision("Cleaning"));
    }
}
