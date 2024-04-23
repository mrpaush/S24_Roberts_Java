package BegJava.SortingAlgos;

import java.util.Comparator;

public class Employee {
    private String Name;
    private int Age;
    private double Salary;
    //make the address attribute call to the address class
    private Address address;
    public Employee() {
        Name = "No Name";
        Age = 0;
        Salary = 0.0;
        address = new Address();
    }
    public Employee(String n, int a, double s, Address ad) {
        Name = n;
        Age = a;
        Salary = s;
        address = ad;
    }
    public void setName(String n) {
        Name = n;
    }
    public void setAge(int a) {
        Age = a;
    }
    public void setSalary(double s) {
        Salary = s;
    }
    public void setAddress(Address ad) { address = ad; }
    public String getName() {
        return Name;
    }
    public int getAge() {
        return Age;
    }
    public double getSalary() {
        return Salary;
    }
    public Address getAddress() { return address; }

    public String toString() {
        return "ProgFund.SortingAlgos.Employee{" + "Name=" + '\"' + Name + "\", Age=" + Age + ", Salary=" + Salary + ", ProgFund.SortingAlgos.Address=" + '\"' + address + '\"' + '}';
    }
    //comparator
    public int compareTo(Employee e) {
        return this.Age - e.Age;
    }
    class Sortbyroll implements Comparator<Employee> {
        public int compare(Employee a, Employee b) {
            return a.Age - b.Age;
        }
    }
}