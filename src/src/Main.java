package src;

public class Main {

    public static void main(String[] args) {

        Topsis topsis = new Topsis(4, 4);

        /*topsis.criteria = new double[][]{
                {49, 81, 81, 64},
                {64, 49, 64, 49},
                {81, 36, 64, 81},
                {36, 49, 64, 36},
        };*/

        //topsis.weights = new  double[] {0.1, 0.4, 0.3, 0.2};

        topsis.criteria = new double[][]{
                {7, 9, 9, 8},
                {8, 7, 8, 7},
                {9, 6, 7, 12},
                {6, 11, 8, 6},
                };

        topsis.weights = new  double[] {0.1, 0.4, 0.3, 0.2};
        topsis.costCriteria = new boolean[] {false, false, false, false};

        //topsis.costCriteria = new boolean[] {false, false, false, true};

        topsis.idealNormalization();
        double ranking[] = topsis.TopsisMethod();

        for (int i = 0; i < ranking.length; ++i) {
            System.out.println("Alternative " + (i + 1) + ": " + ranking[i]);
        }

    }
}
