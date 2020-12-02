package factoryMethod;

import java.util.Comparator;

public class personInfo {
    private static int number = 1;
    private String userID;
    private String name;
    private String password;
    private int StartingSalary;

    public personInfo() {
        userID = String.valueOf(10000 + number);
        number++;
    }

    public personInfo(String name, String password) {
        this.userID = String.valueOf(10000 + number);
        this.name = userID + " " + name;
        this.password = password;
        number++;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStartingSalary() {
        return StartingSalary;
    }

    public void setStartingSalary(int i) {
        StartingSalary = i;
    }

}
