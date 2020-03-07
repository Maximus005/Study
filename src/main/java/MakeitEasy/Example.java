package MakeitEasy;

public class Example {
    public static void main(String[] args) {
        ((A)null).f();
    }
}

class A{
    public static void f(){
        System.out.println("hi");
    }

    public void f1(){
        System.out.println("hi");
    }
}
