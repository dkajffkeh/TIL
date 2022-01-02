package me.patrick.laboratory.memoryleak;

public class EnclosingClass {

    private int[] data;

    public EnclosingClass(int size)
    {
        data = new int[size];
    }

    static class EnclosedClass{}

    EnclosedClass getEnclosedClassObject()
    {
        return new EnclosedClass();
    }

}
