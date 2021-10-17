public class RecLab {
    public static void main(String[] args) {
        System.out.println(putCommas("987631000"));
    }

    public static String findSmallest(String[] array, int index) {
        if (1 == index) {
            return array[index];
        } else {
            return findSmallest(array, ++index);
        }

    }
    public static int GCD(int n, int m) {
        if (m == 0) {
            return n;
        } else {
            return GCD(m, n % m);
        }
    }
    public static String putCommas(String x) {
        if (x.length() <= 3) {
            return x;
        } else {
            return putCommas(x.substring(0, x.length() - 3)) + "," + x.substring(x.length() - 3);
        }
    }
    public static boolean isPlaindrome(String x){
        if(x.length()<= 1){
            return true;
        }else{
            if(x.charAt(0)==x.charAt(x.length()-1)){
               
            }
            return false;
        }
    }
}
