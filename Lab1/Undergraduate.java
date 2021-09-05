package Lab1;

public class Undergraduate extends Student {
    @Override
    public String getStatue() {
        if(getGPA()>=3.0){
            System.out.print("honor");
        }else if(getGPA()>=2.0){
            System.out.print("good");
        }else {
            System.out.print("probation");
        }
        return null;
    }
}
