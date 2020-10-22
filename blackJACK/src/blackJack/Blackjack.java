package blackJack;

public class Blackjack {
	
	private String[] cardPack = {"sA", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "sj", "sq", "sk",

								 "dA", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "dj", "dq", "dk",
								
								 "hA", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "hj", "hq", "hk",
								
								 "cA", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10", "cj", "cq", "ck"};
	
	private String[] shuffleCardPack = shuffle(cardPack);
	
	private int cnt = 0;
	
	public String[] shuffle(String[] cardPack) {
		for(int i=0; i<cardPack.length; i++) {
			int x = (int)(Math.random()* cardPack.length);
			int y = (int)(Math.random()* cardPack.length);
			
			String temp = cardPack[x];
			cardPack[x] = cardPack[y];
			cardPack[y] = temp;
			
		}
		
		return cardPack;
	}
	
	public int compareCard(String card) {
		String mycard = card;
		int cardValue = 0;
		if(mycard == "sA" || mycard == "dA" || mycard == "hA" || mycard == "cA") cardValue = 1;
		else if(mycard == "s2" || mycard == "d2" || mycard == "h2" || mycard == "c2") cardValue = 2;
		else if(mycard == "s3" || mycard == "d3" || mycard == "h3" || mycard == "c3") cardValue = 3;
		else if(mycard == "s4" || mycard == "d4" || mycard == "h4" || mycard == "c4") cardValue = 4;
		else if(mycard == "s5" || mycard == "d5" || mycard == "h5" || mycard == "c5") cardValue = 5;
		else if(mycard == "s6" || mycard == "d6" || mycard == "h6" || mycard == "c6") cardValue = 6;
		else if(mycard == "s7" || mycard == "d7" || mycard == "h7" || mycard == "c7") cardValue = 7;
		else if(mycard == "s8" || mycard == "d8" || mycard == "h8" || mycard == "c8") cardValue = 8;
		else if(mycard == "s9" || mycard == "d9" || mycard == "h9" || mycard == "c9") cardValue = 9;
		else if(mycard == "s10"|| mycard == "d10"|| mycard == "h10"|| mycard == "c10") cardValue = 10;
		else if(mycard == "sj" || mycard == "dj" || mycard == "hj" || mycard == "cj") cardValue = 10;
		else if(mycard == "sq" || mycard == "dq" || mycard == "hq" || mycard == "cq") cardValue = 10;
		else if(mycard == "sk" || mycard == "dk" || mycard == "hk" || mycard == "ck") cardValue = 10;
		
		return cardValue;
	}
	
	public void firstGetCard(Player player, Dealer dealer) {
		boolean condiOne = false, condiTwo = false, condiThree = false, condiFour = false, blackJackConditionOne = false;
		
		String firstCard = shuffleCardPack[cnt++];
		if(firstCard.equals("sA") || firstCard.equals("dA") || firstCard.equals("hA") || firstCard.equals("cA")) condiOne = true; else condiOne = false;
		if(firstCard.equals("s10") || firstCard.equals("sj") || firstCard.equals("sq") || firstCard.equals("sk") ||
		   firstCard.equals("d10") ||firstCard.equals("dj") ||firstCard.equals("dq") ||firstCard.equals("dk") ||
		   firstCard.equals("h10") ||firstCard.equals("hj") ||firstCard.equals("hq") ||firstCard.equals("hk") ||
		   firstCard.equals("c10") ||firstCard.equals("cj") ||firstCard.equals("cq") ||firstCard.equals("ck")) condiTwo = true; else condiTwo = false;
		
		String secondCard = shuffleCardPack[cnt++];
		if(secondCard.equals("sA") || secondCard.equals("dA") || secondCard.equals("hA") || secondCard.equals("cA")) condiThree = true; else condiThree = false;
		if(secondCard.equals("s10") || secondCard.equals("sj") || secondCard.equals("sq") || secondCard.equals("sk") ||
		   secondCard.equals("d10") ||secondCard.equals("dj") ||secondCard.equals("dq") ||secondCard.equals("dk") ||
		   secondCard.equals("h10") ||secondCard.equals("hj") ||secondCard.equals("hq") ||secondCard.equals("hk") ||
		   secondCard.equals("c10") ||secondCard.equals("cj") ||secondCard.equals("cq") ||secondCard.equals("ck")) condiFour = true; else condiFour = false; 
		
		if((condiOne == true || condiThree == true) && (condiTwo == true || condiFour == true)) { blackJackConditionOne = true; } else condiOne = false;
		
		if(blackJackConditionOne) {
			if(condiOne) { player.addCard(11); }
			else { player.addCard(compareCard(firstCard)); }
			
			if(condiThree) { player.addCard(11); }
			else { player.addCard(compareCard(secondCard)); }
		}
		
		else {
			player.addCard(compareCard(firstCard));
			player.addCard(compareCard(secondCard));
		}
		
		firstCard = shuffleCardPack[cnt++];
		if(firstCard.equals("sA") || firstCard.equals("dA") || firstCard.equals("hA") || firstCard.equals("cA")) condiOne = true; else condiOne = false;
		if(firstCard.equals("s10") || firstCard.equals("sj") || firstCard.equals("sq") || firstCard.equals("sk") ||
		   firstCard.equals("d10") ||firstCard.equals("dj") ||firstCard.equals("dq") ||firstCard.equals("dk") ||
		   firstCard.equals("h10") ||firstCard.equals("hj") ||firstCard.equals("hq") ||firstCard.equals("hk") ||
		   firstCard.equals("c10") ||firstCard.equals("cj") ||firstCard.equals("cq") ||firstCard.equals("ck")) condiTwo = true; else condiTwo = false;
		
		secondCard = shuffleCardPack[cnt++];
		if(secondCard.equals("sA") || secondCard.equals("dA") || secondCard.equals("hA") || secondCard.equals("cA")) condiThree = true; else condiThree = false;
		if(secondCard.equals("s10") || secondCard.equals("sj") || secondCard.equals("sq") || secondCard.equals("sk") ||
		   secondCard.equals("d10") ||secondCard.equals("dj") ||secondCard.equals("dq") ||secondCard.equals("dk") ||
		   secondCard.equals("h10") ||secondCard.equals("hj") ||secondCard.equals("hq") ||secondCard.equals("hk") ||
		   secondCard.equals("c10") ||secondCard.equals("cj") ||secondCard.equals("cq") ||secondCard.equals("ck")) condiFour = true; else condiFour = false;
		
		if((condiOne == true || condiThree == true) && (condiTwo == true || condiFour == true)) { blackJackConditionOne = true; }
		
		if(blackJackConditionOne) {
			if(condiOne) { dealer.addCard(11); }
			else { dealer.addCard(compareCard(firstCard)); }
			
			if(condiThree) { dealer.addCard(11); }
			else { dealer.addCard(compareCard(secondCard)); }
		}
		
		else {
			dealer.addCard(compareCard(firstCard));
			dealer.addCard(compareCard(secondCard));
		}
	}
	
	
	public void getCard(Player player) {
		player.addCard(compareCard(shuffleCardPack[cnt++]));
	}
	
	public void getCard(Dealer dealer) {
		dealer.addCard(compareCard(shuffleCardPack[cnt++]));
	}

}
