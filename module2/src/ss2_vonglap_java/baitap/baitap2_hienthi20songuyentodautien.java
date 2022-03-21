package ss2_vonglap_java.baitap;

public class baitap2_hienthi20songuyentodautien {
    public static void main(String[] args) {
        int dem=0;
        int N=2;
        int arr[]=new int[20];
        while (dem<20){
            boolean check=true;
            for (int i=2;i<Math.sqrt(N+1);i++){
                if (N%i==0){
                    check=false;
                    break;
                }
            }
            if (check){
                arr[dem]=N;
                dem++;
            }
            N++;
        }
        for (int temp:arr){
            System.out.print(temp+",");
        }
    }
}
