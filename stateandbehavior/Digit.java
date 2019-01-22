package stateandbehavior;

public class Digit {
    int base, value;

    public Digit(int base) {
        this.base = base;
        this.value = 0;
    }
    public boolean increment () {
        if ( this.value + 1 >= this.base ) {
            this.value = 0;
            return true;
        }
        this.value += 1;
        return false;
    }

    public int getValue() {
        return this.base;
    }
    public String toString() {
        if (value > 9) {
            int charValue = value + 87;
            String s = "" + (char)charValue;
            return s; 
        }
        else {
            return "" + value;
        }
    }
    public static void main(String[] args) {
        Digit myDigit = new Digit(5);
        System.out.println(myDigit.increment());
        System.out.println(myDigit.increment());
        System.out.println(myDigit.increment());
        System.out.println(myDigit.getValue());
        System.out.println(myDigit.increment());
        System.out.println(myDigit.increment());
        System.out.println(myDigit.getValue());
        System.out.println(myDigit.increment());
        System.out.println(myDigit.getValue());
        System.out.println(myDigit);
    }
}
