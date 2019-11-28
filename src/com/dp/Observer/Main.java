package com.dp.Observer;
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int state);
}

class BinObserver implements Observer {
    @Override
    public void update(int state) {
        System.out.println(Integer.toBinaryString(state));
    }
}

class HexObserver implements Observer {
    @Override
    public void update(int state) {
        System.out.println(Integer.toHexString(state));
    }
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    private int state;
    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void setState(int value) {
        this.state = value;
    }

    public void execute() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addObserver(new HexObserver());
        subject.addObserver(new BinObserver());
        subject.setState(15);
        subject.execute();
    }
}
