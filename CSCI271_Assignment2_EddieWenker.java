/*************************************************************************
* Assignment 2 CSCI 271-001 Spring 2026
*
* Author: Eddie Wenker
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: February 5, 2026
*
* Purpose
* This program uses a Fraction class to perform arithmetic operations
* on fractions including addition, subtraction, multiplication, division,
* negation, and exponentiation. It also simplifies fractions and handles
* special cases like zero and infinity.
**************************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* Eddie Wenker
*************************************************************************/

// Assignment 2 Test Class Using Fraction Class
public class CSCI271_Assignment2_EddieWenker {
        public static void main(String[] args){

        Fraction f1 = new Fraction(6, 24); // Create fraction 6/24 (normal case)
        System.out.println("6/24 = " + f1); //prints reduced form 1/4

        Fraction f2 = new Fraction(6, -24); // Create fraction 6/-24 (negative denominator case)
        System.out.println("6/-24 = " + f2); //prints reduced form -1/4

        Fraction f3 = new Fraction(10, 5); // Create fraction 10/5 (case with d = 1)
        System.out.println("10/5 = " + f3); // prints reduced form 2 not 2/1

        Fraction f4 = new Fraction(-30, -90); // Create fraction -30/-90 (both negative case)
        System.out.println("-30/-90 = " + f4); // prints reduced form 1/3

        Fraction f5 = new Fraction(0, 8); // Create fraction 0/8 (zero numerator case)
        System.out.println("0/8 = " + f5); // prints 0/1 as per toString method reduced it but still 0

        Fraction f6 = new Fraction(0, -25); // Create fraction 0/-25 (zero numerator with negative denominator case)
        System.out.println("0/-25 = " + f6); // prints 0/1 as per toString method reduced it but still 0

        Fraction f7 = new Fraction(5, 0); // Create fraction 5/0 (infinity case)
        System.out.println("5/0 = " + f7); // prints Infinity as per toString method

        Fraction f8 = new Fraction(-12, 0); // Create fraction -12/0 (negative infinity case)
        System.out.println("-12/0 = " + f8); // prints -Infinity as per toString method

        Fraction f9 = new Fraction(0, 0); // Create fraction 0/0 (NaN case)
        System.out.println("0/0 = " + f9); // prints NaN as per toString method

        Fraction f10 = new Fraction(-0, 0); // Create fraction -0/0 (checking negative NaN case)
        System.out.println("-0/0 = " + f10); // prints NaN as per toString method

        Fraction f11 = new Fraction(-33, 57); // Create fraction -33/57 (normal negative case))
        System.out.println("-33/57 = " + f11); // prints reduced form -11/19

        //This is the example from the beginning of the assignment description and it works correctly even in its complex form
        Fraction n = new Fraction(16);
        Fraction b = new Fraction(3,5).add(new Fraction(7));
        Fraction c = new Fraction(6,7);
        System.out.println("\n16 / (3/5 + 7) * (6/7) = ");
        Fraction results = c.multiply(n.divide(b));
        System.out.println(results + "\n"); 

        System.out.println(f1 + " + " + f4 + " = " + f1.add(f4)); // Addition test
        System.out.println(f1 + " - " + f4 + " = " + f1.subtract(f4)); // Subtraction test
        System.out.println(f1 + " * " + f4 + " = " + f1.multiply(f4)); // Multiplication test
        System.out.println(f1 + " / " + f4 + " = " + f1.divide(f4)); // Division test
        System.out.println(f11 + " / " + f4 + " = " + f11.divide(f4)); // Division test with negatives
        System.out.println("Inverse of: " + f2 + " = " + f2.negate()); // Negation test of a negative fraction
        System.out.println("Inverse of: " + f7 + " = " + f7.negate()); // Negation test of positive infinity
        System.out.println("Inverse of: " + f8 + " = " + f8.negate()); // Negation test of negative infinity
        System.out.println("Inverse of: " + f9 + " = " + f9.negate()); // Negation test of NaN
        System.out.println(f2 + " to the power of 4 = " + f2.pow(4)); // Exponentiation test with positive exponent
        System.out.println(f2 + " to the power of 0 = " + f2.pow(0)); // Exponentiation test with zero exponent
        System.out.println(f11 + " to the power of 3 = " + f11.pow(3)); // Exponentiation test with positive exponent and negative fraction
        System.out.println(f4 + " to the power of -2 = " + f4.pow(-2)); // Exponentiation test with negative exponent
        System.out.println(f11 + " / " + f10 + " = " + f11.divide(f10)); // Division test with NaN
        System.out.println(f11 + " / " + f5 + " = " + f11.divide(f5)); // Division test with zero numerator (prints out as -Infinity because
        //use dividing by 0/1) -11/19 divided by 0/1 = -11/19 * 1/0 = -11/0 = -Infinity
        }
}
