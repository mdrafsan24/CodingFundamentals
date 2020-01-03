import java.util.*;


/*
What is generics :
Whenever declaring a variable
int value = 5;
Since java is type safe, you have to declare the type first
When we talk about Collection framwork:
List values = new ArrayList();
values.add(someObject); someObject could any type
How is that possible ?
To achieve type safety you have to :
List <Integer> values = new ArrayList<Integer> ();

This where generics come in :

**@IMPORTANT ONLY SUPPORTs REFERENCE TYPE
*/

class Container <T extends Number> {
    T value; // T is the type so T changes based on what you
             // specify
            
    public void show() {
        System.out.println(value.getClass().getName());
    }
}

public class Generics {
    public static void main(String[] args) {
        Container<String> obj = new Container();
        //obj.value = 9.9;
        obj.show();
    }
}
