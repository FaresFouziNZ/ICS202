package Task2;
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
        if (GPA>4 || GPA<0){
            System.out.print("No");
        }
        this.GPA = GPA;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public abstract String getStatue();
    public final String displayStudent(){
        return getClass()+" ID>> "+ID+", GPA>>"+GPA+", Status>> "+getStatue();
    }

    

}
