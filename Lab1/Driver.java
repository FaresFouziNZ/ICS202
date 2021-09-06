package Lab1;
import java.util.Random;

public class Driver {
    public static void main(String[] argus){
        int x = 0;
        Student[] studentarr = new Student[10];
        Random rand = new Random();
        for(int i=0;i<10;i++){
            if(x==0){
            studentarr[i] = new Undergraduate();
            studentarr[i].setGPA(Math.floor(Math.random()*(4.0+1)));
            studentarr[i].setID((int)Math.floor(Math.random()*(999999+1)));
            x=1;
            }else if(x==1){
                studentarr[i] = new Graduate();
                studentarr[i].setGPA(Math.floor(Math.random()*(4.0+1)));
                studentarr[i].setID((int)Math.floor(Math.random()*(999999+1)));
                x=0;
            }
            print(studentarr[i].displayStudent());
            
        }
    }
    public static void print(String S){
        System.out.print(S);
    }
}
