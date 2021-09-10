package Lab1.Task2;


import java.util.Random;


import java.text.DecimalFormat;

public class DriverT2 {
    public static void main(String[] argus){
        int x = 0;
        Student[] studentArray = new Student[10];
        Random rand = new Random();
        DecimalFormat f = new DecimalFormat("##.00");
        for(int i=0;i<10;i++){
            x =  (int)(Math.random() * (2));
            if(x==0){
                studentArray[i] = new Undergraduate();
                studentArray[i].setGPA(Double.parseDouble(f.format((4.0) * rand.nextDouble())));
                studentArray[i].setID((int)Math.floor(Math.random()*(999999+1)));
            }else if(x==1){
                studentArray[i] = new Graduate();
                studentArray[i].setGPA(Double.parseDouble(f.format((4.0) * rand.nextDouble())));
                studentArray[i].setID((int)Math.floor(Math.random()*(999999+1)));
            }
            System.out.println(studentArray[i].displayStudent());
            
        }
    }
  
}