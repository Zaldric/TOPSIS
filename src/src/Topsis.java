package src;

import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;

class Topsis {

    double[][] criteria;
    double[] weights;
    boolean[] costCriteria;

    Topsis(int numberOfCriteria, int numberOfAlternatives) {

        criteria = new double[numberOfAlternatives][numberOfCriteria];
        weights = new double[numberOfCriteria];
        costCriteria = new boolean[numberOfCriteria];
    }

    /**
     * Calculates the alternative's ranking using the eigenvalue method.
     *
     * @return an array with the alternatives's ranking.
     */
    double[] TopsisMethod() {

        for (int i = 0; i < criteria.length; ++i) {
            for (int j = 0; j < criteria[i].length; ++j) {
                criteria[j][i] *= weights[i];
            }
        }

        WeightedNormalisedRatings weightedNormalisedRatings[] = new WeightedNormalisedRatings[criteria.length];

        for (int i = 0; i < criteria.length; ++i) {

            double max = criteria[0][i], min = criteria[0][i];

            for(int j = 1; j < criteria[i].length; ++j) {
                if (criteria[j][i] > max) {
                    max = criteria[j][i];
                }
                if (criteria[j][i] < min) {
                    min = criteria[j][i];
                }
            }

            if (costCriteria[i]) {
                WeightedNormalisedRatings solutions = new WeightedNormalisedRatings(min, max);
                weightedNormalisedRatings[i] = solutions;
            } else {
                WeightedNormalisedRatings solutions = new WeightedNormalisedRatings(max, min);
                weightedNormalisedRatings[i] = solutions;
            }
        }

        double[] ranking = new double[criteria[0].length];

        for (int i = 0; i < criteria.length; ++i) {

            double idealSum = 0.0, antiIdealSum = 0.0;

            for (int j = 0; j < criteria[i].length; ++j) {
                idealSum += Math.pow((weightedNormalisedRatings[j].getIdealSolution() - criteria[i][j]), 2);
                antiIdealSum += Math.pow((weightedNormalisedRatings[j].getAntiIdealSolution() - criteria[i][j]), 2);
            }

            idealSum = Math.sqrt(idealSum);
            antiIdealSum = Math.sqrt(antiIdealSum);

            ranking[i] = antiIdealSum / idealSum + antiIdealSum;
        }

        return ranking;
    }

    /**
     * Normalizes the comparision matrix using distributive normalization.
     */
    void distributiveNormalization() {

        for (int i = 0; i < criteria.length; ++i) {
            double denominator = 0.0;

            for (int j = 0; j < criteria[i].length; ++j) {
                denominator += criteria[j][i] * criteria[j][i];
            }

            denominator = Math.sqrt(denominator);

            for (int j = 0; j < criteria[i].length; ++j) {
                criteria[j][i] = criteria[j][i] / denominator;
            }
        }
    }

    /**
     * Normalizes the comparision matrix using ideal normalization.
     */
    void idealNormalization() {

        for (int i = 0; i < criteria.length; ++i) {

            double value = criteria[i][0];

            if (costCriteria[i]) {
                for (int j = 1; j < criteria[i].length; ++j) {
                    if (criteria[j][i] < value) {
                        value = criteria[j][i];
                    }
                }

                for (int j = 0; j < criteria[i].length; ++j) {
                    criteria[j][i] = value / criteria[j][i];
                }

            } else {
                for (int j = 1; j < criteria[i].length; ++j) {
                    if (criteria[j][i] > value) {
                        value = criteria[j][i];
                    }
                }

                for (int j = 0; j < criteria[i].length; ++j) {
                    criteria[j][i] = criteria[j][i] / value;
                }
            }


        }
    }

    /**
     * Normalizes the vector by dividing each element by the sum of all vector's elements.
     *
     * @param vector the vector to normalize.
     * @return an array with normalized elements.
     */
    private double[] normalizeVector(double[] vector) {

        double[] normalizedVector = new double[vector.length];
        double sum = 0;

        for (double element : vector) {
            sum += element;
        }

        for (int i = 0; i < vector.length; ++i) {
            normalizedVector[i] = vector[i] / sum;
        }

        return normalizedVector;
    }

    /**
     * Calculates the consistency ratios for the AHP problem.
     *
     * @return the consistency ratio for the matrix.
     */
    double calculateConsistencyRatio() {

        double[] randomIndex = new double[] {0.58, 0.9, 1.12, 1.24, 1.32, 1.41, 1.45, 1.49};

        RealMatrix realMatrix = MatrixUtils.createRealMatrix(criteria);

        EigenDecomposition decomposition = new EigenDecomposition(realMatrix);
        double[] eigenValues = decomposition.getRealEigenvalues();

        int pos = 0;

        for (int i = 1; i < eigenValues.length; ++i) {
            if (eigenValues[i] > eigenValues[pos]) {
                pos = i;
            }
        }

        double consistencyIndex = (eigenValues[pos] - criteria.length) / (criteria.length - 1);

        if (criteria.length <= 3) {
            return consistencyIndex / randomIndex[0];
        }
        return consistencyIndex / randomIndex[criteria.length - 1];
    }
}
