package machine;

/**
 * Created by yanghongwu on 2018/4/27.
 */
public class TheleastsquaremethodTest {

    private static double a;

    private static double b;

    private static int num;

    /**
     * 训练
     *
     * @param x
     * @param y
     */
    public static void train(double x[], double y[]) {
        num = x.length < y.length ? x.length : y.length;
        calCoefficientes(x,y);
    }

    /**
     * a=(NΣxy-ΣxΣy)/(NΣx^2-(Σx)^2)
     * b=y(平均)-a*x（平均）
     * @param x
     * @param y
     * @return
     */
    public static void calCoefficientes (double x[],double y[]){
        double xy=0.0,xT=0.0,yT=0.0,xS=0.0;
        for(int i=0;i<num;i++){
            xy+=x[i]*y[i];
            xT+=x[i];
            yT+=y[i];
            xS+=Math.pow(x[i], 2.0);
        }
        a= (num*xy-xT*yT)/(num*xS-Math.pow(xT, 2.0));
        b=yT/num-a*xT/num;
    }

    /**
     * 预测
     *
     * @param xValue
     * @return
     */
    public static double predict(double xValue) {
        System.out.println("a="+a);
        System.out.println("b="+b);
        return a * xValue + b;
    }

    public static void main(String args[]) {
        double[] x = { 8, 16, 24, 32, 40, 48 };
        double[] y = { 5000, 7000, 15000, 16000, 20000, 30000 };
        TheleastsquaremethodTest.train(x, y);

        System.out.println(TheleastsquaremethodTest.predict(64));
    }

}
