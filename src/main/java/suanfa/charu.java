package suanfa;

/**
 * Created by yhw on 02/07/2017.
 */
public class charu {

    public static void main(String[] args) {
        int [] num = {4,6,8,2,34,12,56,57,68,9};
        for (int i = 1; i < num.length; i++) {
            int t = num[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (num[j] > t) {
                    num[j+1] = num[j];
                    num[j] = t;
                }
            }
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print("  " + num[i]);
        }

    }
}
