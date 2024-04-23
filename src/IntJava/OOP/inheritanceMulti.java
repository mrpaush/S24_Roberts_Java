package IntJava.OOP;

import java.lang.*;

//write a program that has the following:
// an OOPJava.OOP.Auto class that has: mileage, make
// OOPJava.OOP.SUV class that extends from OOPJava.OOP.Auto with extra "number of rows" attribute
// coupe class that extends from auto with extra "horse power" attribute
public class inheritanceMulti {
    public static void main(String[] args) {
        Auto a = new Auto(1000, "Toyota");
        SUV s = new SUV(2000, "Honda", 3);
        Coupe c = new Coupe(3000, "Lambo", 600);
        System.out.println(a);
        System.out.println(s);
        System.out.println(c);
    }
}

class Auto {
    protected int mileage;
    protected String make;

    public Auto(int mileage, String make) {
        this.mileage = mileage;
        this.make = make;
    }

    public Auto() {
        mileage = 0;
        make = "Toyota";
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "OOPJava.OOP.Auto{" +
                "mileage=" + mileage +
                ", make='" + make + '\'' +
                '}';
    }
}

class SUV extends Auto {
    private int rows;
    public SUV(int mileage, String make, int rows) {
        this.mileage = mileage;
        this.make = make;
        this.rows = rows;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "OOPJava.OOP.SUV{" +
                "rows=" + rows +
                ", mileage=" + mileage +
                ", make='" + make + '\'' +
                '}';
    }
}
class Coupe extends Auto {
    private int horsePower;
    public Coupe(int mileage, String make, int horsePower) {
        this.mileage = mileage;
        this.make = make;
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "OOPJava.OOP.Coupe{" +
                "horsePower=" + horsePower +
                ", mileage=" + mileage +
                ", make='" + make + '\'' +
                '}';
    }
}



