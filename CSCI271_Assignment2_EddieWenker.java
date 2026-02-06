/*************************************************************************
* Assignment 2 CSCI 271-001 Spring 2026
*
* Author: Eddie Wenker
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: February 5, 2026
*
* Purpose
* 
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

public class CSCI271_Assignment2_EddieWenker {
        public static void main(String[] args){

        Fraction f1 = new Fraction(6, 24);
        System.out.println("6/24 = " + f1);

        Fraction f2 = new Fraction(6, -24);
        System.out.println("6/-24 = " + f2);

        Fraction f3 = new Fraction(10, 5);
        System.out.println("10/5 = " + f3);

        Fraction f4 = new Fraction(-30, -90);
        System.out.println("-30/-90 = " + f4);

        Fraction f5 = new Fraction(0, 8);
        System.out.println("0/8 = " + f5);

        Fraction f6 = new Fraction(0, -25);
        System.out.println("0/-25 = " + f6);

        Fraction f7 = new Fraction(5, 0);
        System.out.println("5/0 = " + f7);

        Fraction f8 = new Fraction(-12, 0);
        System.out.println("-12/0 = " + f8);

        Fraction f9 = new Fraction(0, 0);
        System.out.println("0/0 = " + f9);

        Fraction f10 = new Fraction(-0, 0);
        System.out.println("-0/0 = " + f10);

        Fraction f11 = new Fraction(-33, 57);
        System.out.println("-33/57 = " + f11);

        Fraction n = new Fraction(16);
        Fraction b = new Fraction(3,5).add(new Fraction(7));
        Fraction c = new Fraction(6,7);
        System.out.println("\n16 / (3/5 + 7) * (6/7) = ");
        Fraction results = c.multiply(n.divide(b));
        System.out.println(results + "\n"); 

        System.out.println(f1 + " + " + f4 + " = " + f1.add(f4));
        System.out.println(f1 + " - " + f4 + " = " + f1.subtract(f4));
        System.out.println(f1 + " * " + f4 + " = " + f1.multiply(f4));
        System.out.println(f1 + " / " + f4 + " = " + f1.divide(f4));
        System.out.println(f11 + " / " + f4 + " = " + f11.divide(f4));
        System.out.println("Inverse of: " + f2 + " = " + f2.negate());
        System.out.println("Inverse of: " + f7 + " = " + f7.negate());
        System.out.println("Inverse of: " + f8 + " = " + f8.negate());
        System.out.println("Inverse of: " + f9 + " = " + f9.negate());
        System.out.println(f2 + " to the power of 4 = " + f2.pow(4));
        System.out.println(f2 + " to the power of 0 = " + f2.pow(0));
        System.out.println(f11 + " to the power of 3 = " + f11.pow(3));
        System.out.println(f4 + " to the power of -2 = " + f4.pow(-2));
        }
}
