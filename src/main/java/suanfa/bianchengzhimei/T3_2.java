package suanfa.bianchengzhimei;

/**
 * Created by yanghongwu on 17-2-5.
 */
public class T3_2 {

    static class StopMsgException extends RuntimeException {
    }

    public static void main(String[] args) {
//        int line = 10;
//        sf34(line);

        int number[] = {1,3,6,8,1,2,4,3,3,5,9};
        int answer[] = {0,0,0,0,0,0,0,0,0,0,0};
        sf35(number, answer, 0, 11, 10, 0);

    }

    public static void sf34(int limit) {
        String [][]c = {
                {""},
                {""},
                {"A","B","C"},
                {"D","E","F"},
                {"G","H","I"},
                {"J","K","L"},
                {"M","N","O"},
                {"P","Q","R","S"},
                {"T","U","V"},
                {"W","X","Y","Z"}
        };

        int total[] = {1,1,3,3,3,3,3,4,3,4};
        int number[] = {1,3,6,8,1,2,4,3,3,5,9};
        int answer[] = {0,0,0,0,0,0,0,0,0,0,0};

        int line = 0;

        while (true) {
            if (line == limit) break;
            line++;
            for (int i = 0; i < number.length; i++) {
                System.out.print( "," + c[number[i]][answer[i]]);
            }

            System.out.println();
            int k = number.length - 1;
            while (k >= 0) {
                if (answer[k] < total[number[k]] - 1) {
                    answer[k]++;
                    break;
                }
                else {
                    answer[k] = 0; k--;
                }
            }

            if (k < 0) {
                break;
            }
        }

    }


    public static void sf35(int[] number, int[] answer, int index, int n, int limit, Integer line){
        String [][]c = {
                {""},
                {""},
                {"A","B","C"},
                {"D","E","F"},
                {"G","H","I"},
                {"J","K","L"},
                {"M","N","O"},
                {"P","Q","R","S"},
                {"T","U","V"},
                {"W","X","Y","Z"}
        };

        if (line == limit) {
            throw new StopMsgException();
        }
        int total[] = {1,1,3,3,3,3,3,4,3,4};
        if (index == n) {
            for (int i = 0; i < n; i++) {
                System.out.print("," + c[number[i]][answer[i]]);
            }
            System.out.println();
            return;
        }

        for (answer[index] = 0; answer[index] < total[number[index]]; answer[index]++) {
            sf35(number, answer, index + 1, n, limit, line++);
        }

    }
}
