package blackJack;

import java.util.ArrayList;
import java.util.List;

public class Player{
	private List<Integer> myCardPack = new ArrayList<>();
	private int wallet = 20000;
	private int betting = 0;
	
	public void addCard(int card) {
		myCardPack.add(card);
	}
	
	public int Playerscore() {
		int sum = 0;
		
		for(Integer e : myCardPack) { sum += e; }
	
		return  sum;
	}


	public int getWallet() {
		return wallet;
	}

	public void setWallet(int bet) {
		this.wallet -= wallet;
	}
	
	public void reWallet(int bet) {
		this.wallet += wallet;
	}

	public void betting(int bet, boolean wd) {
		if(wd) this.wallet += bet*2;  
	}
	
}
