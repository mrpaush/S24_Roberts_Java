package IntJava.OOP.XYZCompany;

class Emp {
    protected int id, age;
    private static int idCount = 0;
    public Emp(int age) {
        this.id = ++idCount;
        this.age = age;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    @Override public String toString() {return "Emp," + id + "," + age;}
}

class FullTime extends Emp {
    protected double annualSalary;
    public FullTime(int age, double annualSalary) {
        super(age);
        this.annualSalary = annualSalary;
    }
    public double getAnnualSalary() {return annualSalary;}
    public void setAnnualSalary(double annualSalary) { this.annualSalary = annualSalary; }
    @Override public String toString() {return "FullTime," + id + "," + age + "," + annualSalary;}
}
class PartTime extends Emp {
    protected double hourlyRate;
    protected int hoursAllowed;
    public PartTime(int age, double hourlyRate, int hoursAllowed) {
        super(age);
        this.hourlyRate = hourlyRate;
        this.hoursAllowed = hoursAllowed;
    }
    public double getHourlyRate() {return hourlyRate;}
    public void setHourlyRate(double hourlyRate) {this.hourlyRate = hourlyRate;}
    public int getHoursAllowed() {return hoursAllowed;}
    public void setHoursAllowed(int hoursAllowed) {this.hoursAllowed = hoursAllowed;}
    @Override public String toString() {return "PartTime," + id + "," + age + "," + hourlyRate + "," + hoursAllowed;}
}
class Hourly extends Emp {
    protected double hourlyRate;
    public Hourly(int age, double hourlyRate) {
        super(age);
        this.hourlyRate = hourlyRate;
    }
    public double getHourlyRate() {return hourlyRate;}
    public void setHourlyRate(double hourlyRate) {this.hourlyRate = hourlyRate;}
    @Override public String toString() {return "Hourly," + id + "," + age + "," + hourlyRate;}
}
