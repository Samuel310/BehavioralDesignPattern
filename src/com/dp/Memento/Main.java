package com.dp.Memento;
import java.util.ArrayList;
import java.util.List;

class Life {

    private String time;
    private int age;
    private String State;

    public void set(String time, int age, String state ) {
        this.time = time;
        this.age=age;
        this.State=state;
    }

    public Memento saveToMemento() {
        System.out.println("Saving data to Memento");
        return new Memento(time, age, State);
    }

    public void restoreFromMemento(Memento memento) {
        memento.getSaveddata();
    }

    public static class Memento {

        private final String time;
        private final int age;
        private final String State;

        public Memento(String timeToSave, int that_age, String that_state) {
            time = timeToSave;
            age=that_age;
            State=that_state;
        }

        public void getSaveddata() {
            System.out.println("The retrived data are \n"+ time +" - "+age+" - "+State);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Life.Memento> mementoList = new ArrayList<>();
        Life life = new Life();
        life.set("3/10/1998", 1, "Born");
        mementoList.add(life.saveToMemento());
        life.set("2016", 17, "Completed school");
        mementoList.add(life.saveToMemento());
        life.set("2020", 21, "Graduated");
        mementoList.add(life.saveToMemento());
        life.restoreFromMemento(mementoList.get(1));
    }
}
