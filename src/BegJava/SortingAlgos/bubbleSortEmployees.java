package BegJava.SortingAlgos;

public class bubbleSortEmployees {
    //write a code that will sort an array of employee objects.
    //create a few of these objects in an array
    //employee is a class with age, salary, and name with all the needed methos
    //the sort will be based on the age
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Jack", 27, 27000.0, new Address());
        employees[1] = new Employee("Jill", 25, 25000.0, new Address());
        employees[2] = new Employee("John", 30, 30000.0, new Address());
        employees[3] = new Employee("Jane", 22, 22000.0, new Address());
        employees[4] = new Employee("Joe", 35, 35000.0, new Address());
        sortEmployees(employees);
    }
    public static void sortEmployees(Employee[] e) {
        Employee temp;
        for (int i = 0; i < e.length-1; i++) {
            for (int n = 0; n < e.length-i-1; n++) {
                if (e[n].getAge() > e[n+1].getAge()) {
                    temp = e[n];
                    e[n] = e[n+1];
                    e[n+1] = temp;
                }
            }
        }
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
        }
    }
}
