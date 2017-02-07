package suanfa;

/**
 * Created by yhw on 02/07/2017.
 */
public class shell {

    public static void main(String[] args) {
        int [] num = {4,6,8,2,34,12,56,57,68,9};
        int [] interval = {5,4,3,2,1};
        for (int d = 0; d < interval.length; d++) {
            int t = interval[d];
            for (int i = 0; i + t < num.length; i += t) {
                int temp;
                if (num[i] > num[i + t]) {
                    temp = num[i];
                    num[i] = num[i + t];
                    num[i + t] = temp;
                }
            }
        }


        for (int i = 0; i < num.length; i++) {
            System.out.print("  " + num[i]);
        }
    }
}
