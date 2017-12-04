package src;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String mode;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("Please indicate the operation you want to perform: \n");
            System.out.println("Press 0 to finish the program.");
            System.out.println("Press 1 to to solve the practice exercises.");
            System.out.println("Press 2 to enter the matrices of the TOPSIS problem manually.");
            mode = input.nextLine();

            if (mode.equals("1")) {

                System.out.println("Exercise 1: \n");

                System.out.println("Ideal normalization: ");

                Topsis topsis = new Topsis(4, 4);
                String names[] = new String[]{"Ana", "Tomás", "Juan", "Emma"};
                String criteriaNames[] = new String[]{"Personalidad", "Vida en Extranjero", "Examen", "Experiencia laboral"};

                topsis.criteria = new double[][]{
                        {7, 9, 9, 8},
                        {8, 7, 8, 7},
                        {9, 6, 7, 12},
                        {6, 11, 8, 6},
                };

                topsis.weights = new double[]{0.1, 0.4, 0.3, 0.2};
                topsis.costCriteria = new boolean[]{false, false, false, false};

                topsis.idealNormalization();
                double ranking[] = topsis.TopsisMethod();

                System.out.println();
                System.out.println("Normalized matrix: ");
                for (int i = 0; i < topsis.criteriaNormalization.length; ++i) {
                    for (int j = 0; j < topsis.criteriaNormalization[0].length; ++j) {
                        System.out.print(topsis.criteriaNormalization[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("Matrix after applying weights: ");
                for (int i = 0; i < topsis.criteriaWeights.length; ++i) {
                    for (int j = 0; j < topsis.criteriaWeights[0].length; ++j) {
                        System.out.print(topsis.criteriaWeights[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("Ideal solution: ");
                for (int i = 0; i < criteriaNames.length; ++i) {
                    System.out.println(criteriaNames[i] + ": " + topsis.weightedNormalisedRatings[i].getIdealSolution());
                }
                System.out.println();

                System.out.println("Anti-ideal solution: ");
                for (int i = 0; i < criteriaNames.length; ++i) {
                    System.out.println(criteriaNames[i] + ": " + topsis.weightedNormalisedRatings[i].getAntiIdealSolution());
                }
                System.out.println();

                System.out.println("Distance to ideal solution: ");
                for (int i = 0; i < topsis.idealDistances.length; ++i) {
                    for (int j = 0; j < topsis.idealDistances[0].length; ++j) {
                        System.out.print(topsis.idealDistances[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 0; i < topsis.alternativesIdealDistances.length; ++i) {
                    System.out.println(names[i] + " " + topsis.alternativesIdealDistances[i]);
                }
                System.out.println();

                System.out.println("Distance to anti-ideal solution: ");
                for (int i = 0; i < topsis.antiIdealDistances.length; ++i) {
                    for (int j = 0; j < topsis.antiIdealDistances[0].length; ++j) {
                        System.out.print(topsis.antiIdealDistances[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 0; i < topsis.alternativesAntiIdealDistances.length; ++i) {
                    System.out.println(names[i] + " " + topsis.alternativesAntiIdealDistances[i]);
                }

                System.out.println();
                int bestAlternative = 0;
                System.out.println("Ranking: ");

                for (int i = 0; i < ranking.length; ++i) {
                    System.out.println(names[i] + ": " + ranking[i]);
                    if (ranking[i] > ranking[bestAlternative]) {
                        bestAlternative = i;
                    }
                }

                System.out.println();
                System.out.println("The best alternative is to choose " + names[bestAlternative] + ". \n");


                System.out.println("Distributive normalization: ");

                topsis = new Topsis(4, 4);

                topsis.criteria = new double[][]{
                        {7, 9, 9, 8},
                        {8, 7, 8, 7},
                        {9, 6, 7, 12},
                        {6, 11, 8, 6},
                };

                topsis.weights = new double[]{0.1, 0.4, 0.3, 0.2};
                topsis.costCriteria = new boolean[]{false, false, false, false};


                topsis.distributiveNormalization();
                ranking = topsis.TopsisMethod();

                System.out.println();
                System.out.println("Normalized matrix: ");
                for (int i = 0; i < topsis.criteriaNormalization.length; ++i) {
                    for (int j = 0; j < topsis.criteriaNormalization[0].length; ++j) {
                        System.out.print(topsis.criteriaNormalization[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("Matrix after applying weights: ");
                for (int i = 0; i < topsis.criteriaWeights.length; ++i) {
                    for (int j = 0; j < topsis.criteriaWeights[0].length; ++j) {
                        System.out.print(topsis.criteriaWeights[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("Ideal solution: ");
                for (int i = 0; i < criteriaNames.length; ++i) {
                    System.out.println(criteriaNames[i] + ": " + topsis.weightedNormalisedRatings[i].getIdealSolution());
                }
                System.out.println();

                System.out.println("Anti-ideal solution: ");
                for (int i = 0; i < criteriaNames.length; ++i) {
                    System.out.println(criteriaNames[i] + ": " + topsis.weightedNormalisedRatings[i].getAntiIdealSolution());
                }
                System.out.println();

                System.out.println("Distance to ideal solution: ");
                for (int i = 0; i < topsis.idealDistances.length; ++i) {
                    for (int j = 0; j < topsis.idealDistances[0].length; ++j) {
                        System.out.print(topsis.idealDistances[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 0; i < topsis.alternativesIdealDistances.length; ++i) {
                    System.out.println(names[i] + " " + topsis.alternativesIdealDistances[i]);
                }
                System.out.println();

                System.out.println("Distance to anti-ideal solution: ");
                for (int i = 0; i < topsis.antiIdealDistances.length; ++i) {
                    for (int j = 0; j < topsis.antiIdealDistances[0].length; ++j) {
                        System.out.print(topsis.antiIdealDistances[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 0; i < topsis.alternativesAntiIdealDistances.length; ++i) {
                    System.out.println(names[i] + " " + topsis.alternativesAntiIdealDistances[i]);
                }
                System.out.println();

                bestAlternative = 0;
                System.out.println("Ranking: ");

                for (int i = 0; i < ranking.length; ++i) {
                    System.out.println(names[i] + ": " + ranking[i]);
                    if (ranking[i] > ranking[bestAlternative]) {
                        bestAlternative = i;
                    }
                }

                System.out.println();
                System.out.println("The best alternative is to choose " + names[bestAlternative] + ". \n");

                System.out.println("Exercise 2: ");
                System.out.println("Ideal normalization: ");

                topsis = new Topsis(4, 4);

                topsis.criteria = new double[][]{
                        {160, 40, 175, 3},
                        {130, 28, 200, 2.5},
                        {170, 50, 160, 3.5},
                        {188, 33, 189, 3},
                };

                topsis.weights = new double[]{0.6, 0.2, 0.1, 0.1};
                topsis.costCriteria = new boolean[]{true, false, false, false};
                names = new String[] {"M4-A4", "AK-47", "M16", "SCAR-L"};


                topsis.idealNormalization();
                ranking = topsis.TopsisMethod();

                System.out.println();
                System.out.println("Normalized matrix: ");
                for (int i = 0; i < topsis.criteriaNormalization.length; ++i) {
                    for (int j = 0; j < topsis.criteriaNormalization[0].length; ++j) {
                        System.out.print(topsis.criteriaNormalization[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("Matrix after applying weights: ");
                for (int i = 0; i < topsis.criteriaWeights.length; ++i) {
                    for (int j = 0; j < topsis.criteriaWeights[0].length; ++j) {
                        System.out.print(topsis.criteriaWeights[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("Ideal solution: ");
                for (int i = 0; i < criteriaNames.length; ++i) {
                    System.out.println(criteriaNames[i] + ": " + topsis.weightedNormalisedRatings[i].getIdealSolution());
                }
                System.out.println();

                System.out.println("Anti-ideal solution: ");
                for (int i = 0; i < criteriaNames.length; ++i) {
                    System.out.println(criteriaNames[i] + ": " + topsis.weightedNormalisedRatings[i].getAntiIdealSolution());
                }
                System.out.println();

                System.out.println("Distance to ideal solution: ");
                for (int i = 0; i < topsis.idealDistances.length; ++i) {
                    for (int j = 0; j < topsis.idealDistances[0].length; ++j) {
                        System.out.print(topsis.idealDistances[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 0; i < topsis.alternativesIdealDistances.length; ++i) {
                    System.out.println(names[i] + " " + topsis.alternativesIdealDistances[i]);
                }
                System.out.println();

                System.out.println("Distance to anti-ideal solution: ");
                for (int i = 0; i < topsis.antiIdealDistances.length; ++i) {
                    for (int j = 0; j < topsis.antiIdealDistances[0].length; ++j) {
                        System.out.print(topsis.antiIdealDistances[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 0; i < topsis.alternativesAntiIdealDistances.length; ++i) {
                    System.out.println(names[i] + " " + topsis.alternativesAntiIdealDistances[i]);
                }
                System.out.println();

                bestAlternative = 0;
                System.out.println("Ranking: ");

                for (int i = 0; i < ranking.length; ++i) {
                    System.out.println(names[i] + ": " + ranking[i]);
                    if (ranking[i] > ranking[bestAlternative]) {
                        bestAlternative = i;
                    }
                }

                System.out.println();
                System.out.println("The best alternative is to choose " + names[bestAlternative] + ". \n");

                System.out.println("Exercise 2: ");
                System.out.println("Distributive normalization: ");

                topsis = new Topsis(4, 4);

                topsis.criteria = new double[][]{
                        {160, 40, 175, 3},
                        {130, 28, 200, 2.5},
                        {170, 50, 160, 3.5},
                        {188, 33, 189, 3},
                };

                topsis.weights = new double[]{0.6, 0.2, 0.1, 0.1};
                topsis.costCriteria = new boolean[]{true, false, false, false};


                topsis.distributiveNormalization();
                ranking = topsis.TopsisMethod();

                System.out.println();
                System.out.println("Normalized matrix: ");
                for (int i = 0; i < topsis.criteriaNormalization.length; ++i) {
                    for (int j = 0; j < topsis.criteriaNormalization[0].length; ++j) {
                        System.out.print(topsis.criteriaNormalization[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("Matrix after applying weights: ");
                for (int i = 0; i < topsis.criteriaWeights.length; ++i) {
                    for (int j = 0; j < topsis.criteriaWeights[0].length; ++j) {
                        System.out.print(topsis.criteriaWeights[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("Ideal solution: ");
                for (int i = 0; i < criteriaNames.length; ++i) {
                    System.out.println(criteriaNames[i] + ": " + topsis.weightedNormalisedRatings[i].getIdealSolution());
                }
                System.out.println();

                System.out.println("Anti-ideal solution: ");
                for (int i = 0; i < criteriaNames.length; ++i) {
                    System.out.println(criteriaNames[i] + ": " + topsis.weightedNormalisedRatings[i].getAntiIdealSolution());
                }
                System.out.println();

                System.out.println("Distance to ideal solution: ");
                for (int i = 0; i < topsis.idealDistances.length; ++i) {
                    for (int j = 0; j < topsis.idealDistances[0].length; ++j) {
                        System.out.print(topsis.idealDistances[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 0; i < topsis.alternativesIdealDistances.length; ++i) {
                    System.out.println(names[i] + " " + topsis.alternativesIdealDistances[i]);
                }
                System.out.println();

                System.out.println("Distance to anti-ideal solution: ");
                for (int i = 0; i < topsis.antiIdealDistances.length; ++i) {
                    for (int j = 0; j < topsis.antiIdealDistances[0].length; ++j) {
                        System.out.print(topsis.antiIdealDistances[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 0; i < topsis.alternativesAntiIdealDistances.length; ++i) {
                    System.out.println(names[i] + " " + topsis.alternativesAntiIdealDistances[i]);
                }
                System.out.println();

                bestAlternative = 0;
                System.out.println("Ranking: ");

                for (int i = 0; i < ranking.length; ++i) {
                    System.out.println(names[i] + ": " + ranking[i]);
                    if (ranking[i] > ranking[bestAlternative]) {
                        bestAlternative = i;
                    }
                }

                System.out.println();
                System.out.println("The best alternative is to choose " + names[bestAlternative] + ". \n");

            } else if (mode.equals("2")) {

                int numberOfCriteria, numberOfAlternatives;
                String data;
                String[] criteriaNames, alternativeNames;

                do {
                    System.out.println("Please enter the criteria's names by separating each name with ';':");
                    data = input.nextLine();
                    criteriaNames = data.split(";");
                    numberOfCriteria = criteriaNames.length;
                    if (data.equals("")) {
                        System.out.println("Please introduce at least one name. \n");
                    }
                } while (numberOfCriteria == 0);

                System.out.println();
                double[] weights = new double[numberOfCriteria];

                for (int i = 0; i < numberOfCriteria; ++i) {
                    do {
                        System.out.println("Please enter the weight of the criteria " + criteriaNames[i]);
                        if (!StringUtils.isNumeric(data) || Integer.parseInt(data) < 0) {
                            boolean valid = false;
                            do {
                                data = input.nextLine();
                                if (data.contains("/")) {
                                    String[] parts = data.split("/");
                                    valid = parts.length == 2 && StringUtils.isNumeric(parts[0]) && StringUtils.isNumeric(parts[1]);
                                } else {
                                    if (StringUtils.isNumeric(data) || data.split("\\.").length == 2) {
                                        valid = true;
                                    } else {
                                        System.out.println("Please enter a valid number.");
                                    }
                                }
                            } while (!valid);
                            if (data.contains("/")) {
                                String[] parts = data.split("/");
                                weights[i] = Double.valueOf(parts[0]) / Double.valueOf(parts[1]);
                            } else {
                                weights[i] = Double.parseDouble(data);
                            }
                        }
                    } while (data.equals(""));
                }

                System.out.println();
                boolean[] costCriteria = new boolean[numberOfCriteria];

                for (int i = 0; i < numberOfCriteria; ++i) {
                    do {
                        System.out.println("Is the criteria " + criteriaNames[i] + " a cost criteria?");
                        System.out.println("Type 'y' if yes or 'n' if not.");
                        data = input.nextLine();
                        if (data.equals("y")) {
                            costCriteria[i] = true;
                        }
                        if (data.equals("n")) {
                            costCriteria[i] = false;
                        }
                    } while (!data.equals("y") && !data.equals("n"));
                }

                System.out.println();

                do {
                    System.out.println("Please enter the alternative's names by separating each name with ';':");
                    data = input.nextLine();
                    alternativeNames = data.split(";");
                    numberOfAlternatives = alternativeNames.length;
                    if (data.equals("")) {
                        System.out.println("Please introduce at least one name. \n");
                    }
                } while (numberOfAlternatives == 0);

                Topsis topsis = new Topsis(numberOfCriteria, numberOfAlternatives);
                double[][] comparisionMatrix = new double[numberOfAlternatives][numberOfCriteria];

                for (int i = 0; i < numberOfCriteria; ++i) {
                    String values[];
                    boolean validValues;
                    do {
                        validValues = true;
                        System.out.println("Please enter row " + (i + 1) + " of the comparision matrix by separating each value with ';': \n");
                        values = input.nextLine().split(";");

                        if (values.length != numberOfCriteria) {
                            validValues = false;
                            System.out.println("The number of values should be " + numberOfCriteria + ".");
                        } else {
                            for (String value : values) {
                                if (StringUtils.isNumeric(value) && (Double.parseDouble(value) < 0.0)) {
                                    validValues = false;
                                    System.out.println("All the values must be positive.");
                                } else if (!StringUtils.isNumeric(value)) {
                                    if (value.contains("\\.")) {
                                        String[] parts = value.split("\\.");
                                        validValues = parts.length == 2 && StringUtils.isNumeric(parts[0]) && StringUtils.isNumeric(parts[1]);
                                    } else if (value.contains("/")) {
                                        String[] parts = value.split("/");
                                        validValues = parts.length == 2 && StringUtils.isNumeric(parts[0]) && StringUtils.isNumeric(parts[1]);
                                    } else {
                                        validValues = false;
                                        System.out.println("Please enter a valid number.");
                                    }
                                }
                            }
                        }
                    } while (!validValues);

                    for (int j = 0; j < numberOfCriteria; ++j) {
                        if (!values[j].contains("/")) {
                            comparisionMatrix[i][j] = Double.parseDouble(values[j]);
                        } else {
                            String[] parts = values[j].split("/");
                            comparisionMatrix[i][j] = Double.valueOf(parts[0]) / Double.valueOf(parts[1]);
                        }
                    }
                }

                double[][] auxMatrix = comparisionMatrix.clone();

                topsis.criteria = comparisionMatrix;
                topsis.costCriteria = costCriteria;
                topsis.weights = weights;
                System.out.println("Ideal normalization: ");

                topsis.idealNormalization();
                double ranking[] = topsis.TopsisMethod();

                System.out.println();
                System.out.println("Normalized matrix: ");
                for (int i = 0; i < topsis.criteriaNormalization.length; ++i) {
                    for (int j = 0; j < topsis.criteriaNormalization[0].length; ++j) {
                        System.out.print(topsis.criteriaNormalization[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("Matrix after applying weights: ");
                for (int i = 0; i < topsis.criteriaWeights.length; ++i) {
                    for (int j = 0; j < topsis.criteriaWeights[0].length; ++j) {
                        System.out.print(topsis.criteriaWeights[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("Ideal solution: ");
                for (int i = 0; i < criteriaNames.length; ++i) {
                    System.out.println(criteriaNames[i] + ": " + topsis.weightedNormalisedRatings[i].getIdealSolution());
                }
                System.out.println();

                System.out.println("Anti-ideal solution: ");
                for (int i = 0; i < criteriaNames.length; ++i) {
                    System.out.println(criteriaNames[i] + ": " + topsis.weightedNormalisedRatings[i].getAntiIdealSolution());
                }
                System.out.println();

                System.out.println("Distance to ideal solution: ");
                for (int i = 0; i < topsis.idealDistances.length; ++i) {
                    for (int j = 0; j < topsis.idealDistances[0].length; ++j) {
                        System.out.print(topsis.idealDistances[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 0; i < topsis.alternativesIdealDistances.length; ++i) {
                    System.out.println(alternativeNames[i] + " " + topsis.alternativesIdealDistances[i]);
                }
                System.out.println();

                System.out.println("Distance to anti-ideal solution: ");
                for (int i = 0; i < topsis.antiIdealDistances.length; ++i) {
                    for (int j = 0; j < topsis.antiIdealDistances[0].length; ++j) {
                        System.out.print(topsis.antiIdealDistances[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 0; i < topsis.alternativesAntiIdealDistances.length; ++i) {
                    System.out.println(alternativeNames[i] + " " + topsis.alternativesAntiIdealDistances[i]);
                }

                System.out.println();
                int bestAlternative = 0;
                System.out.println("Ranking: ");

                for (int i = 0; i < ranking.length; ++i) {
                    System.out.println(alternativeNames[i] + ": " + ranking[i]);
                    if (ranking[i] > ranking[bestAlternative]) {
                        bestAlternative = i;
                    }
                }

                System.out.println();
                System.out.println("The best alternative is to choose " + alternativeNames[bestAlternative] + ". \n");


                System.out.println("Distributive normalization: ");

                topsis = new Topsis(numberOfCriteria, numberOfAlternatives);

                topsis.criteria = auxMatrix;

                topsis.weights = weights;
                topsis.costCriteria = costCriteria;

                topsis.distributiveNormalization();
                ranking = topsis.TopsisMethod();

                System.out.println();
                System.out.println("Normalized matrix: ");
                for (int i = 0; i < topsis.criteriaNormalization.length; ++i) {
                    for (int j = 0; j < topsis.criteriaNormalization[0].length; ++j) {
                        System.out.print(topsis.criteriaNormalization[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("Matrix after applying weights: ");
                for (int i = 0; i < topsis.criteriaWeights.length; ++i) {
                    for (int j = 0; j < topsis.criteriaWeights[0].length; ++j) {
                        System.out.print(topsis.criteriaWeights[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("Ideal solution: ");
                for (int i = 0; i < criteriaNames.length; ++i) {
                    System.out.println(criteriaNames[i] + ": " + topsis.weightedNormalisedRatings[i].getIdealSolution());
                }
                System.out.println();

                System.out.println("Anti-ideal solution: ");
                for (int i = 0; i < criteriaNames.length; ++i) {
                    System.out.println(criteriaNames[i] + ": " + topsis.weightedNormalisedRatings[i].getAntiIdealSolution());
                }
                System.out.println();

                System.out.println("Distance to ideal solution: ");
                for (int i = 0; i < topsis.idealDistances.length; ++i) {
                    for (int j = 0; j < topsis.idealDistances[0].length; ++j) {
                        System.out.print(topsis.idealDistances[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 0; i < topsis.alternativesIdealDistances.length; ++i) {
                    System.out.println(alternativeNames[i] + " " + topsis.alternativesIdealDistances[i]);
                }
                System.out.println();

                System.out.println("Distance to anti-ideal solution: ");
                for (int i = 0; i < topsis.antiIdealDistances.length; ++i) {
                    for (int j = 0; j < topsis.antiIdealDistances[0].length; ++j) {
                        System.out.print(topsis.antiIdealDistances[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 0; i < topsis.alternativesAntiIdealDistances.length; ++i) {
                    System.out.println(alternativeNames[i] + " " + topsis.alternativesAntiIdealDistances[i]);
                }
                System.out.println();

                bestAlternative = 0;
                System.out.println("Ranking: ");

                for (int i = 0; i < ranking.length; ++i) {
                    System.out.println(alternativeNames[i] + ": " + ranking[i]);
                    if (ranking[i] > ranking[bestAlternative]) {
                        bestAlternative = i;
                    }
                }

                System.out.println();
                System.out.println("The best alternative is to choose " + alternativeNames[bestAlternative] + ". \n");
            }
        } while (!mode.equals("0"));
    }
}


