package Lab1;

public class Undergraduate extends Student {
    @Override
    public String getStatue() {
        if(getGPA()>=3.0){
            return "honor";
        }else if(getGPA()>=2.0){
            return "good";
        }else {
            return "probation";
        }
       
    }
}
