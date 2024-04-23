package BegJava.SortingAlgos;

public class Address {
    private String Street;
    private String City;
    private String Zip;

    public Address() {
        this("No Street", "No City", "No Zip");
    }

    public Address(String s, String c, String z) {
        Street = s;
        City = c;
        Zip = z;
    }
    public String toString() {
        return Street + ", " + City + ", " + Zip;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    public String getStreet() {
        return Street;
    }

    public String getCity() {
        return City;
    }

    public String getZip() {
        return Zip;
    }
}
