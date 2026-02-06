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
        System.out.println("6/24 -> " + f1.toString());

        Fraction f2 = new Fraction(6, -24);
        System.out.println("6/-24 -> " + f2.toString());

        Fraction f3 = new Fraction(0, 8);
        System.out.println("0/8 -> " + f3.toString());

        Fraction f4 = new Fraction(10, 5);
        System.out.println("10/5 -> " + f4.toString());

        Fraction f5 = new Fraction(0, 0);
        System.out.println("0/0 -> " + f5.toString());

        Fraction f6 = new Fraction(5, 0);
        System.out.println("5/0 -> " + f6.toString());
    }
    
}
