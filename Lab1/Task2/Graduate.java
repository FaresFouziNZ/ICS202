package Task2;


public class Graduate extends Student {
    @Override
    public String getStatue() {
        if(getGPA()>=3.0){
            return "honor";
        }else{
            return "probation";
        }
    }
}
