package lab2;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCrossover extends AbstractCrossover<double[]> {
    protected MyCrossover() {
        super(1);
    }

    protected List<double[]> mate(double[] p1, double[] p2, int i, Random random) {
        ArrayList children = new ArrayList();

        // your implementation:
        double[] c1 = new double[p1.length];
        double[] c2 = new double[p1.length];
        double alpha = 0.4;
        for (int k = 0; k < p1.length; k++) {
                c1[k] = alpha * p1[k] + (1 - alpha) * p2[k];
                c2[k] = alpha * p2[k] + (1 - alpha) * p1[k];
        }

        children.add(c1);
        children.add(c2);
        return children;
    }
}
