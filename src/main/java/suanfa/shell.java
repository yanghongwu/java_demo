package suanfa;

/**
 * Created by yhw on 02/07/2017.
 */
public class shell {

    public static void main(String[] args) {
        int [] num = {4,6,8,2,34,12,56,57,68,9};
        int [] interval = {5,3,1};
        for (int d = 0; d < interval.length; d++) {
            int t = interval[d];
            int gap = t;
            for (int i = 0; i < num.length; i++) {
                int temp = num[i];
                int j = i - gap;
                for (; j >= 0 && num[j] > temp; j -= gap) {
                        num[j + gap] = num[j];
                }
                num[j + gap] = temp;
            }
        }


        for (int i = 0; i < num.length; i++) {
            System.out.print("  " + num[i]);
        }
    }
}
