package Lab1;
import java.util.Random;
import java.text.DecimalFormat;

public class Driver {
    public static void main(String[] argus){
        int x = 0;
        Student[] studentArray = new Student[10];
        Random rand = new Random();
        DecimalFormat f = new DecimalFormat("##.00");
        for(int i=0;i<10;i++){
            if(x==0){
                studentArray[i] = new Undergraduate();
                studentArray[i].setGPA(Double.parseDouble(f.format((4.0) * rand.nextDouble())));
                studentArray[i].setID((int)Math.floor(Math.random()*(999999+1)));
            x=1;
            }else if(x==1){
                studentArray[i] = new Graduate();
                studentArray[i].setGPA(Double.parseDouble(f.format((4.0) * rand.nextDouble())));
                studentArray[i].setID((int)Math.floor(Math.random()*(999999+1)));
                x=0;
            }
            System.out.println(studentArray[i].displayStudent());
            
        }
    }
  
}
