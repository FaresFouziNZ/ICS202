package Lab1;

public abstract class Student {
    protected int ID;
    protected double GPA;
    public double getGPA() {
        return GPA;
    }
    public int getID() {
        return ID;
    }
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public abstract String getStatue();
    public String displayStudent(){
        return getClass()+" ID>> "+ID+", GPA>>"+GPA+", Status>> "+getStatue();
    }

    

}
