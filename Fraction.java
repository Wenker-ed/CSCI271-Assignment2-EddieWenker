public class Fraction {
    
    private long numerator;
    private long denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(long numerator, long denominator) {

        long gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        if (denominator < 0) 
        {
            this.numerator = -this.numerator;
            this.denominator = -denominator / gcd;
            return;
        }
        else
        {
            this.denominator = denominator / gcd;
        }

    }

    public String toString() {
        if (denominator == 0)
        {
            if (numerator == 0)
                return "NaN";
            else if (numerator > 0)
                return "Infinity";
            else 
                return "-Infinity";
        }
        else if (numerator != 0 && denominator == 1)
            return Long.toString(numerator);
        else
            return numerator + "/" + denominator;
    }

    private static long gcd(long a, long b) {
        if (a < 0) 
            a = -a; // Make a non-negative
        // if (b < 0) 
        //     b = -b; // Make b non-negative
        while (b != 0) 
        {
                long remainder = a % b;
                a = b;
                b = remainder;
        }
        if (a == 0) 
            a = 1;
        return a;
    }
}