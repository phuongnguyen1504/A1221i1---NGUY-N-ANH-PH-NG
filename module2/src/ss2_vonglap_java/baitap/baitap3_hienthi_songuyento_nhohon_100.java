package ss2_vonglap_java.baitap;

public class baitap3_hienthi_songuyento_nhohon_100 {
    public static void main(String[] args) {
        int dem=1;
        for (int i=2;i<100;i++){
            if (checkPrime(i)){
                System.out.println("Số nguyên tố thứ "+dem+" là:"+i);
                dem++;
            }
        }
    }
    public static boolean checkPrime(int n){
        boolean check= true;
        if (n<2){
            check =false;
        }
        else if (n>2){
            for (int i=2;i<Math.sqrt(n+1);i++){
                if (n%i==0){
                    check=false;
                    break;
                }
            }
        }
        return check;
    }
}
