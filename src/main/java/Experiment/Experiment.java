package Experiment;

import org.junit.Test;

public class Experiment {

  public static void main(String[] args) {

    Child child = new Child();
    child.setName("Child name");

    child.whatIsYourName();


  }

  public static class Child extends Parent {

    private String name;

    @Override
    public void setName(String name) {
      this.name = name;
      super.setName(name);
    }

    public void whatIsYourName() {

      System.out.println("Looking for my name...");
      System.out.println("It looks my name is " + this.name);

      System.out.println(super.name);

      sayYourName();
    }
  }

  public static class Parent {

    private String name;

    public void setName(String name) {
      this.name = name;
    }

    public void sayYourName() {
      System.out.println("I am parent: " + this.name);
    }

    private void m() {}
  }
}
