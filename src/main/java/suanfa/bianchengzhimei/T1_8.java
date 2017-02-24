package suanfa.bianchengzhimei;

/**
 * Created by yanghongwu on 17-1-8.
 */
public class T1_8 {

    public static void main(String[] args) {
//        System.out.println(fangfa1());
        int nPerson[] = {0,1,2,3,1,2,4,1};
        fangfa1(nPerson, 7);

        System.out.println("-----------------------------");

        System.out.println(fangfa2(1,7,nPerson));
        System.out.println("-----------------------------");
        fangfa3();

        System.out.println("---->>>>>>>>>>>");
        fangfa4();
    }


    public static int fangfa1(int[] nPerson, int N) {
        int nFloor, nMinFloor = 0;
        int nTargetFloor = -1;

        for (int i = 1; i <= N; i++) {

            System.out.println("当前楼层：" + i);
            nFloor = 0;

            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                nFloor += nPerson[j] * Math.abs(i - j);
            }
//
//            for (int j = i + 1; j <= N; j++) {
//                nFloor += nPerson[j] * (j - i);
//            }

            if (nTargetFloor == -1 || nMinFloor > nFloor) {
                nMinFloor = nFloor;
                nTargetFloor = i;
            }
            System.out.println("目标楼层：" + nTargetFloor);
            System.out.println("总共楼层数：" + nMinFloor);

        }

        return nTargetFloor;

    }

    public static int fangfa2(int start, int end, int[] nPerson) {

        int nTargetFloor = -1;
        int nMinFloor = 0;
        int N1,N2,N3 ,i;
        int N = end - start;

        for(N1 = 0, N2 = nPerson[start], N3 = 0, i = start + 1; i <= end; i++) {
            N3 += nPerson[i];
            nMinFloor += nPerson[i] * (i - 1);
        }

        for (int j = start + 1; j <= end; j++) {
            if (N1 + N2 < N3) {
                nTargetFloor = j;
                nMinFloor += N1 + N2 - N3;
                N1 += N2;
                N2 = nPerson[j];
                N3 -= nPerson[j];
            } else {
                break;
            }
        }

        System.out.println("目标楼层：" + nTargetFloor);
        System.out.println("总共楼层数：" + nMinFloor);

        return nTargetFloor;
    }

    public static void fangfa3() {

        int nPerson[] = {0,0,2,0,2,2,6,3,1,3};
        System.out.println(fangfa2(1,3,nPerson));
        System.out.println(fangfa2(4,6,nPerson));
        System.out.println(fangfa2(7,9,nPerson));



    }


    public static void fangfa4(){

        int nPerson[] = {0,0,2,0,2,2,6,3,1,3};
        int nFloor,nMinFloor = -1,nTargetFloor = 0;
        int N = 9;
        for (int i = 1; i <= N; i++) {
            for (int i2 = 2; i2 <= N; i2++) {
                for (int i3 = 3; i3 <= N; i3++) {
                    int min = 0;
                    int minFloor = 0;
                    for (int j = 1; j <= N; j++) {
                        if (j == i || j == i2 || j == i3) continue;
                        int min1 = Math.abs(j - i);
                        int min2 = Math.abs(j - i2);
                        int min3 = Math.abs(j - i3);

                        if (min1 < min2) {
                            min = min1;
                        } else {
                            min = min2;
                        }

                        if (min3 < min) {
                            min = min3;
                        }
                        minFloor = minFloor + nPerson[j] * min;
                    }

                    if (nMinFloor == -1 || minFloor < nMinFloor) {
                        nMinFloor = minFloor;
                        System.out.println("楼层1：" + i);
                        System.out.println("楼层2：" + i2);
                        System.out.println("楼层3：" + i3);
                        System.out.println("楼层总数：" + nMinFloor);
                        System.out.println("-------->>>>----------");
                    }
                }
            }

        }
    }

}
