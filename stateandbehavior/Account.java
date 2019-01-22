package stateandbehavior;
 
public class Account {
    double balance;
    double interestRate;
   
    public void deposit(double addedBalance) {
        if (addedBalance > 0) {
            balance += addedBalance;
        }
    }
    public void addInterest() {
    	if (balance > 0) {
    		balance += (balance * interestRate);
    	}
    }
    public double getBalance() {
    	return balance;
    }
    public double getInterestRate() {
    	return interestRate;
    }
    public void setInterestRate(double newInterestRate) {
    	interestRate = newInterestRate;
    }
    public String toString() {
        return "Balanse: " + balance + ", Rentefot: " + interestRate;
    }
    public static void main(String[] args) {
        Account konto = new Account();
        konto.deposit(10000);
        System.out.println(konto);
        konto.setInterestRate(0.1);
        konto.addInterest();
        System.out.println(konto);
    }
}
