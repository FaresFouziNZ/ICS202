
package m251tma;


public class Account {
    //  this the common attributes 
    String name;

    String Nationality;

    public Account() {
        

    }
// get methode to return the value of the variable
    public String getName() {
        return name;
    }
// set methode save the value of the variable
    public void setName(String name) {
        this.name = name;
    }
// get methode to return the value of the variable
    public String getNationality() {
        return Nationality;
    }
// set methode save the value of the variable
    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    @Override 
    public String toString() { // toString method to let all the objects String
        return "Name:" + name + ", Nationality" + Nationality;
    }
}
