package lab2;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {

    double numGen = 1;

    public List<double[]> apply(List<double[]> population, Random random) {
        // initial population
        // need to change individuals, but not their number!

        // your implementation:

        int popSize = population.size();
        int elemLen = population.get(0).length;

        double sigma = 5 / Math.pow(numGen++, 0.5);
        double e;

        for (int i = 0; i < popSize; i++) {
            if (random.nextDouble() > 0.1) {
                double[] element = population.get(i);
                for (int k = 0; k < elemLen; k++) {
                    if (random.nextDouble() > 0.1) {
                        e = element[k] + random.nextGaussian() * sigma;
                        element[k] = Math.max(Math.min(e, 5), -5);
                    } else if (random.nextDouble() > 0.9) {
                        element[k] = random.nextDouble() * 10 - 5;
                    }
                }
            }
        }

        //result population
        return population;
    }
}
