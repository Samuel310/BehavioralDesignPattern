package com.dp.Iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Shape {
    private final int id; private final String name;
    public Shape(int id , String name) {
        this.id = id; this.name = name;
    }
    @Override
    public String toString() { return name+" and "+id; }
}

class ShapeStorage {
    private List<Shape> shapes = new ArrayList<>();
    public void addShape(Shape obj) {
        shapes.add(obj);
    }
    public List<Shape> getShapes() {
        return shapes;
    }
}

class ShapeIterator implements Iterator<Shape> {
    private List<Shape> shapes;
    private int index = 0 ;
    public ShapeIterator(List<Shape> shapes) {
        this.shapes = shapes ;
    }
    @Override
    public boolean hasNext() {
        return index < shapes.size() && shapes.get(index) != null;
    }
    @Override
    public Shape next() {
        return shapes.get(index++);
    }
    @Override
    public void remove() {
        shapes.remove(index);
    }
    public void moveToFirst(){
        index = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeStorage shapeStorage = new ShapeStorage();
        shapeStorage.addShape(new Shape(1,"rectangle"));
        shapeStorage.addShape(new Shape (2,"circle"));
        ShapeIterator iterator = new ShapeIterator(shapeStorage.getShapes());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator.moveToFirst();
        while (iterator.hasNext()) {
            System.out.println("Removing..");
            iterator.remove();
        }
    }
}
