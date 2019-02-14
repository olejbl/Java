package encapsulation;

public class Nim {
	private int[] piles;
	//private boolean valid = true;
	
	
	public Nim(int pileSize) {
		piles = new int[]{pileSize,pileSize,pileSize};
		System.out.println("Du lagde bunker som ser slik ut: " + piles[0] + piles[1] + piles[2]);
		
	}
	public Nim() {
		piles = new int[] {10,10,10};
	}
	
	public void removePieces(int number,int targetPile) {
		if (isGameOver()) {
			throw new IllegalStateException("State exception, game over");
		}
		if (isValidMove(number,targetPile)) {
			if (!(targetPile == 1 || targetPile == 2 || targetPile == 0)){
				throw new IllegalArgumentException("Du kan kun velge mellom bunke 1,2 eller 0.");
			}
			if (number <= this.piles[targetPile]){
				this.piles[targetPile] -= number;
				System.out.println("Du har trukket fra " + number + " av " + (this.piles[targetPile] + number) +  " brikker fra bunke nr: " + this.piles[targetPile]);
			}
			//else {
			//	System.out.println("Error fordi: " + "targetPile inneholder: " + this.piles[targetPile] + " number: " + number);
			//	throw new IllegalArgumentException("Du kan ikke ta bort fler enn det finnes i pilen!");
			//}
		}
		else {
			throw new IllegalArgumentException("Dette er et ugyldig trekk.");
		}
	}
	
	
	public int getPile(int targetPile) {
		return this.piles[targetPile];
	}
	
	
	public boolean isValidMove(int number,int targetPile) {
		if (isGameOver()) {
			return false;
		}
		//if (piles[0] == 0 || piles[1] == 0 || piles[2] == 0) {
		//	System.out.println("Ugyldig trekk, en av bunkene er tom");
		//	return false;
		//}
		else if (number >= 1 && number <= piles[targetPile] && targetPile >= 0 && targetPile <=3) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	public boolean isGameOver() {
		if (piles[0] <= 0 || piles[1] <= 0 || piles[2] <= 0) {
			System.out.println("Game over");
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean isBoolean() {
		if (piles[0] == 0) {
			System.out.println("Spillet er over.");
			return true;
		}
		else if (piles[1] == 0){
			System.out.println("Spillet er over.");
			return true;
		}
		else if (piles[2] == 0) {
			System.out.println("Spillet er over.");
			return true;		
		}
		return false;
	}
	
	public static void main(String[] args) {
		Nim n1 = new Nim(20);
		n1.getPile(1);
		System.out.println(n1.getPile(1));
	}
	

}
