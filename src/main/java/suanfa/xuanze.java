package suanfa;

/**
 * Created by yhw on 02/08/2017.
 */
public class xuanze {
    public static void main(String[] args) {
        int [] num = {4,6,8,2,34,12,56,57,68,9};

        for (int i = 0; i < num.length; i++) {
            int min = num[i];
            int j = i + 1;
            while (j < num.length) {
                if (min > num[j]) {
                    min = num[j];
                    num[j] = num[i];
                }
                j++;
            }
            num[i] = min;
        }

        for (int i = 0; i < num.length; i++) {
            System.out.print("  " + num[i]);
        }
    }
}
