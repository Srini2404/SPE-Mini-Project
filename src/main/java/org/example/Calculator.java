package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Calculator {
    private static final Logger logger = Logger.getLogger(String.valueOf(Calculator.class));

    public static double add(double n1, double n2) {
        logger.info("Starting Add Operation");
        double res = n1 + n2;
        logger.info("Ending Add Operation");
        return res;
    }
    // Hello This is for testing
    public static double multiply(double n1, double n2) {
        logger.info("Starting Multiply Operation");
        double res = n1 * n2;
        logger.info("Ending Multiply Operation");
        return res;
    }

    public static int factorial(int n1) throws IllegalArgumentException {
        logger.info("Starting Factorial Operation");
        if (n1 < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        int res = 1;
        for (int i = 1; i <= n1; i++) {
            res *= i;
        }

        logger.info("Ending Factorial Operation");
        return res;
    }

    public static double squareRoot(double n1) throws IllegalArgumentException {
        logger.info("Starting Square Root Operation");
        if (n1 < 0) {
            throw new IllegalArgumentException("Square root of negative number is not defined.");
        }

        double res = Math.sqrt(n1);
        logger.info("Ending Square Root Operation");
        return res;
    }

    public static double naturalLog(double n1) throws IllegalArgumentException {
        logger.info("Starting Natural Logarithm Operation");
        if (n1 <= 0) {
            throw new IllegalArgumentException("Natural logarithm is only defined for positive numbers.");
        }

        double res = Math.log(n1);
        logger.info("Ending Natural Logarithm Operation");
        return res;
    }

    public static double power(double base, double exponent) {
        logger.info("Starting Power Operation");
        double res = Math.pow(base, exponent);
        logger.info("Ending Power Operation");
        return res;
    }

    public static void main(String[] args) {
        logger.info("Start of Execution");
        Scanner sc = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            try {
                System.out.println("-------- Welcome to Calculator Program - SPE ---------");
                System.out.println("\n-------- Please Enter the Operation Code: ------------");
                System.out.println("1. Addition");
                System.out.println("2. Multiplication");
                System.out.println("3. Factorial");
                System.out.println("4. Square Root");
                System.out.println("5. Natural Logarithm (ln(x))");
                System.out.println("6. Power (x^b)");
                System.out.println("7. Exit\n");

                int operation = sc.nextInt();

                if (operation == 1) {
                    System.out.print("Please Enter 2 numbers to be added: ");
                    double num1 = sc.nextDouble();
                    double num2 = sc.nextDouble();
                    System.out.println("The Final Result is: " + add(num1, num2));
                } else if (operation == 2) {
                    System.out.print("Please Enter 2 numbers to be multiplied: ");
                    double num1 = sc.nextDouble();
                    double num2 = sc.nextDouble();
                    System.out.println("The Final Result is: " + multiply(num1, num2));
                } else if (operation == 3) {
                    System.out.print("Please Enter an integer whose factorial you want to calculate: ");
                    int intNum = sc.nextInt();
                    System.out.println("The Final Result is: " + factorial(intNum));
                } else if (operation == 4) {
                    System.out.print("Please Enter a number whose square root you want to calculate: ");
                    double num1 = sc.nextDouble();
                    System.out.println("The Final Result is: " + squareRoot(num1));
                } else if (operation == 5) {
                    System.out.print("Please Enter a number to calculate its natural logarithm (ln(x)): ");
                    double num1 = sc.nextDouble();
                    System.out.println("The Final Result is: " + naturalLog(num1));
                } else if (operation == 6) {
                    System.out.print("Please Enter the base number: ");
                    double base = sc.nextDouble();
                    System.out.print("Please Enter the exponent: ");
                    double exponent = sc.nextDouble();
                    System.out.println("The Final Result is: " + power(base, exponent));
                } else if (operation == 7) {
                    System.out.println("Thanks for Using Calculator Program - BYE");
                    continueLoop = false;
                } else {
                    System.out.println("Invalid operation code! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.next();  // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        logger.info("Exiting Calculator Program");
        sc.close();
    }
}
