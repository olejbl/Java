package encapsulation;
 
public class Account {
	
    private double balance;
    private double interestRate;
   
    public Account(double n1, double n2) {
			if (n1 < 0 && n2 < 0) {
				throw new IllegalArgumentException();
			}
    		balance = n1; 
    		interestRate = n2;
    }
    
    public void withdraw(double ammount) {
    	if (ammount > balance) {
    		throw new IllegalArgumentException();
    	}
    	balance -= ammount;
    }
    
    public void deposit(double ammount) {
    	if (ammount < 0) {
    		throw new IllegalArgumentException();
    	}
      balance += ammount;
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
    	if (newInterestRate < 0) {
    		throw new IllegalArgumentException();
    	}
    	interestRate = newInterestRate;
    }
    public String toString() {
        return "Balanse: " + balance + ", Rentefot: " + interestRate;
    }
    public static void main(String[] args) {
        Account konto = new Account(100000, 0.1);
        konto.deposit(10000);
        System.out.println(konto);
        konto.setInterestRate(0.1);
        konto.addInterest();
        System.out.println(konto);
    }
}
