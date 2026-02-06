/*************************************************************************
* Fraction Class for Assignment 2 CSCI 271-001 Spring 2026
*
* Author: Eddie Wenker
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: February 5, 2026
*
* Purpose
* This is a Fraction class that has a constructor for creating fractions 
* with no parameters, one parameter, or two parameters. The Fraction will 
* be constructed in its most simplified form using GCD. The class includes methods
* for adding, subtracting, multiplying, dividing, negating, and exponentiating
* fractions using multiple functions. The class also handles special cases 
* such as zero denominators (infinity and NaN).
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

// Fraction class to represent and manipulate fractions
public class Fraction {
    
    // Instance Variables for creating a Fraction
    private long numerator;
    private long denominator;

    public Fraction() { // Default constructor creates fraction 0/1
        this.numerator = 0; //this. notation to refer to instance variable not paramets
        this.denominator = 1;
    }

    public Fraction(long numerator) { // Constructor for one long variable (numerator is given) and creates a whole number
        this.numerator = numerator;
        this.denominator = 1;
    }

    // This constructor creates a correctly reduced fraction using GCD 
    public Fraction(long numerator, long denominator) { // Constructor for two long variables (numerator and denominator are given)

        long gcd = gcd(numerator, denominator); // Call gcd function to get greatest common divisor of numerator and denominator
        this.numerator = numerator / gcd; // Reduce numerator by dividing by gcd
        // If denominator is negative, make numerator negative and denominator positive
        if (denominator < 0)
        {
            this.numerator = -this.numerator; // Already simplified numerator negated
            this.denominator = -denominator / gcd;
        }
        else // Normal case where denominator is positive
        {
            this.denominator = denominator / gcd;
        }

    }

    /*****************************<toString>****************************
    * Description: When we print Fractions, toString is automaticaly called
    * and we are overwriting the default toString method.
    *   
    * Parameters: no parameters.
    *
    * Pre: The Fraction object exists.
    *
    * Post: The Fraction will print in the reduced form (numerator/denominator).
    * Special cases such as whole numbers, infinity, and NaN are also handled.
    *
    * Returns: Returns a string representation of the fraction.
    *
    * Called by: Is called when a Fraction is printed.
    * Calls: N/A.
    ************************************************************************/
    @Override //override annotation to indicate we are overriding the default toString method
    public String toString() {
        //Don't need this. notation because no parameters
        if (denominator == 0) // Handle special cases for infinity and NaN (something over 0)
        {
            if (numerator == 0) // 0/0 case returns Not a Number
                return "NaN";
            else if (numerator > 0) // Positive infinity case (any fraction with positive numerator and 0 denominator)
                return "Infinity";
            else // Negative infinity case (any fraction with negative numerator and 0 denominator)
                return "-Infinity";
        }
        else if (numerator != 0 && denominator == 1) // If the fraction is a whole number, just return the numerator
            return Long.toString(numerator);
        else // Normal case, return numerator/denominator in string form
            return numerator + "/" + denominator;
    }

    /*****************************<gcd>****************************
    * Description: This function private static meaning it will only
    * be accessible within the Fraction class and is used to compute the greatest common divisor.
    *
    * Parameters: a long n (numerator) and a long d (denominator).
    *
    * Pre: The parameters n and d are legal long values of a fraction.
    *
    * Post: It will return the correct positive greatest common divisor of n and d.
    *
    * Returns: Returns a long value representing the greatest common divisor of n and d.
    *
    * Called by: The Fraction constructor with two parameters that needs to reduce fractions.
    * Calls: N/A.
    ************************************************************************/
    private static long gcd(long n, long d) {
        if (n < 0) 
            n = -n; // Make n non-negative
        if (d < 0)
            d = -d; // Make d non-negative (gcd is always non-negative)
        //while loop to implement Euclidean algorithm - keeps finding remainders until d is 0
        // in which then the gcd is found and stored in n
        while (d != 0)
        {
                long remainder = n % d; //long to store remainder of n divided by d each loop iteration
                n = d;
                d = remainder;
        }
        if (n == 0) //gcd(0,0) is undefined but we will return 1 to avoid division by zero
            n = 1;
        return n; //return gcd which is stored in n
    }

    /*****************************<divide>****************************
    * Description: Divides this fraction by another fraction.
    *
    * Parameters: a Fraction f (the divisor)
    *
    * Pre: The Fraction getting divided and the divisor are both valid fractions.
    *
    * Post: Returns a new Fraction that is the result of dividing this fraction by f.
    * Special cases such as division by zero are handled appropriately and will be printed 
    * as all other fractions because they are reconstructed when returned and printed (toString()).
    *
    * Returns: A new constructed fraction after the division is performed.
    *
    * Called by: N/A.
    * Calls: N/A.
    ************************************************************************/
    public Fraction divide(Fraction f) {
        return new Fraction(this.numerator * f.denominator, this.denominator * f.numerator);
    }

    /*****************************<multiply>****************************
    * Description: Multiplies this fraction by another fraction.
    *
    * Parameters: a Fraction f (the multiplier)
    *
    * Pre: The Fraction getting multiplied and the multiplier are both valid fractions.
    *
    * Post: Returns a new Fraction that is the result of multiplying this fraction by f.
    * Special cases such as multiplication by zero are handled appropriately and will be printed 
    * as all other fractions because they are reconstructed when returned and printed (toString()).
    *
    * Returns: A new constructed fraction after the multiplication is performed.
    *
    * Called by: N/A.
    * Calls: N/A.
    ************************************************************************/
    public Fraction multiply(Fraction f) {
        return new Fraction(this.numerator * f.numerator, this.denominator * f.denominator);
    }

    /*****************************<subtract>****************************
    * Description: Subtracts another fraction from this fraction.
    *
    * Parameters: a Fraction f (the fraction doing the subtracting)
    *
    * Pre: The Fraction getting subtracted from and the subtractor are both valid fractions.
    *
    * Post: Returns a new Fraction that is the result of subtracting f from this fraction.
    * Special cases such as subtraction by zero are handled appropriately and will be printed 
    * as all other fractions because they are reconstructed when returned and printed (toString()).
    *
    * Returns: A new constructed fraction after the subtraction is performed.
    *
    * Called by: N/A.
    * Calls: N/A.
    ************************************************************************/
    public Fraction subtract(Fraction f) {
        return new Fraction(this.numerator * f.denominator - f.numerator * this.denominator, this.denominator * f.denominator);
    }

    /*****************************<add>****************************
    * Description: Adds another fraction to this fraction.
    *
    * Parameters: a Fraction f (the addend)
    *
    * Pre: The Fraction getting added to and the addend are both valid fractions.
    *
    * Post: Returns a new Fraction that is the result of adding f to this fraction.
    * Special cases such as addition by zero are handled appropriately and will be printed 
    * as all other fractions because they are reconstructed when returned and printed (toString()).
    *
    * Returns: A new constructed fraction after the addition is performed.
    *
    * Called by: N/A.
    * Calls: N/A.
    ************************************************************************/
    public Fraction add(Fraction f) {
        return new Fraction(this.numerator * f.denominator + f.numerator * this.denominator, this.denominator * f.denominator);
    }

    /*****************************<negate>****************************
    * Description: Returns the negation of this fraction.
    *
    * Parameters: None
    *
    * Pre: The Fraction is a valid fraction.
    *
    * Post: Returns a new Fraction that is the negation of this fraction.
    * Special cases such as negation of zero are handled appropriately and will be printed 
    * as all other fractions because they are reconstructed when returned and printed (toString()).
    *
    * Returns: A new constructed fraction after the negation is performed.
    *
    * Called by: N/A.
    * Calls: N/A.
    ************************************************************************/
    public Fraction negate() {
        if (this.numerator > 0 && this.denominator == 0)
            return new Fraction(-1, 0);
        else if (this.numerator < 0 && this.denominator == 0)
            return new Fraction(1, 0);
        else
            return new Fraction(-this.numerator, this.denominator);
    }

    /*****************************<pow>****************************
    * Description: Raises this fraction to the power of n.
    *
    * Parameters: an int n (the exponent)
    *
    * Pre: The Fraction is a valid fraction.
    *
    * Post: Returns a new Fraction that is this fraction raised to the power of n.
    * Special cases such as raising zero to a negative power are handled appropriately and will be printed 
    * as all other fractions because they are reconstructed when returned and printed (toString()).
    *
    * Returns: A new constructed fraction after the exponentiation is performed.
    *
    * Called by: N/A.
    * Calls: The pow function in Math class that takes in what is being exponentiated and the exponent.
    ************************************************************************/
    public Fraction pow(int n) {
        if (n > 0)
            return new Fraction((long)Math.pow(this.numerator, n), (long)Math.pow(this.denominator, n));
        else if (n == 0)
            return new Fraction(1);
        else
            return new Fraction((long)Math.pow(this.denominator, -n), (long)Math.pow(this.numerator, -n));
    }
}