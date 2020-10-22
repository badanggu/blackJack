package blackJack;

import java.util.ArrayList;
import java.util.List;

public class Dealer{
	private List<Integer> myCardPack = new ArrayList<>();
	
	public void addCard(int card) {
		myCardPack.add(card);
	}
	
	public int Playerscore() {
		int sum = 0;
		
		for(Integer e : myCardPack) { sum += e; }
		
		return  sum;
	}

}
