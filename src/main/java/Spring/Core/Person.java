package Spring.Core;

public class Person {

    public Employee employee1;
    public Employee employee2;
    public String name;
    public int i;

    public Person() {
    }

    public Person(Employee employee1, Employee employee2, String name, int i) {
        this.employee1 = employee1;
        this.employee2 = employee2;
        this.name = name;
        this.i = i;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }
    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee2(Employee employee2) {
        this.employee2 = employee2;
    }
    public Employee getEmployee2() {
        return employee2;
    }
}
