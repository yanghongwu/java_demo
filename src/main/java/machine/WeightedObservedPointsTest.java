package machine;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

/**
 * Created by yanghongwu on 2018/4/26.
 */
public class WeightedObservedPointsTest {
    public static void main(String[] args) {
        final WeightedObservedPoints obs = new WeightedObservedPoints();
        obs.add(-3, 4);
        obs.add(-2, 2);
        obs.add(-1, 3);
        obs.add(0, 0);
        obs.add(1, -1);
        obs.add(2, -2);
        obs.add(3, -5);

        // Instantiate a third-degree polynomial fitter.
        final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(3);

        // Retrieve fitted parameters (coefficients of the polynomial function).
        final double[] coeff = fitter.fit(obs.toList());
        for (double c : coeff) {
            System.out.println(c);
        }
    }
}
