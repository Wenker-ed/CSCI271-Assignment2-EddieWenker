public class Fraction {
    
    private long numerator;
    private long denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(long numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction(long numerator, long denominator) {

        long gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        if (denominator < 0) 
        {
            this.numerator = -this.numerator;
            this.denominator = -denominator / gcd;
        }
        else
        {
            this.denominator = denominator / gcd;
        }

    }

    @Override
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

    private static long gcd(long n, long d) {
        if (n < 0) 
            n = -n; // Make n non-negative
        if (d < 0)
            d = -d; // Make d non-negative
        while (d != 0) 
        {
                long remainder = n % d;
                n = d;
                d = remainder;
        }
        if (n == 0) 
            n = 1;
        return n;
    }

    public Fraction divide(Fraction f) {
        return new Fraction(this.numerator * f.denominator, this.denominator * f.numerator);
    }

    public Fraction multiply(Fraction f) {
        return new Fraction(this.numerator * f.numerator, this.denominator * f.denominator);
    }

    public Fraction subtract(Fraction f) {
        return new Fraction(this.numerator * f.denominator - f.numerator * this.denominator, this.denominator * f.denominator);
    }

    public Fraction add(Fraction f) {
        return new Fraction(this.numerator * f.denominator + f.numerator * this.denominator, this.denominator * f.denominator);
    }

    public Fraction negate() {
        if (this.numerator > 0 && this.denominator == 0)
            return new Fraction(-1, 0);
        else if (this.numerator < 0 && this.denominator == 0)
            return new Fraction(1, 0);
        else
            return new Fraction(-this.numerator, this.denominator);
    }

    public Fraction pow(int n) {
        if (n > 0)
            return new Fraction((long)Math.pow(this.numerator, n), (long)Math.pow(this.denominator, n));
        else if (n == 0)
            return new Fraction(1, 1);
        else
            return new Fraction((long)Math.pow(this.denominator, -n), (long)Math.pow(this.numerator, -n));
    }
}