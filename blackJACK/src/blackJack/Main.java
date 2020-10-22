package blackJack;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Player player = new Player();
		Dealer dealer = new Dealer();
		Blackjack blackjack = new Blackjack();
		boolean wd;
		boolean set=true;
		
		System.out.println("게임을 시작합니다.");
		
		System.out.println("배팅할 금액을 입력하세요.");
		int bet = sc.nextInt(); 
		player.setWallet(bet);
		sc.nextLine();
		
		System.out.println("카드를 2장씩 받습니다.");
		blackjack.firstGetCard(player, dealer);
		System.out.println("플레이어 카드 : " + player.Playerscore());
		System.out.println("딜러 카드 : " + dealer.Playerscore());
		
		do {
			if (player.Playerscore()>21) { 
				wd = false;
				set = false;
				System.out.println("패배");
				System.out.println("지갑 잔액" + player.getWallet());
				break; 
				}
			
			System.out.println("카드를 받는다. = Y");
			System.out.println("멈춘다 = N");
			
			String select = sc.nextLine();
			
			if(select.equals("Y") || select.equals("y")) {
				blackjack.getCard(player);
				System.out.println("플레이어 카드 : " + player.Playerscore());
				System.out.println("딜러 카드 : " + dealer.Playerscore());
				if(player.Playerscore() > 21) {
					wd = false;
					set = false;
					System.out.println("패배");
					System.out.println("지갑 잔액" + player.getWallet());
				}
			}
			
			else if(select.equals("N") || select.equals("n")) {
				if(dealer.Playerscore()<17) { blackjack.getCard(dealer); System.out.println("딜러 카드 : " + dealer.Playerscore()); }
				if(player.Playerscore() == dealer.Playerscore()) {
					System.out.println("무승부");
					player.reWallet(bet);
					System.out.println("지갑 잔액" + player.getWallet());
				}
					if(player.Playerscore() > dealer.Playerscore()) {
						wd = true;
						set = false;
						System.out.println("승리");
						player.betting(bet, wd);
						System.out.println("지갑 잔액" + player.getWallet());
					}
					
					else {
						wd = false;
						set = false;
						System.out.println("패배");
						System.out.println("지갑 잔액" + player.getWallet());
					}
			}
		
		} while(set);
		
		System.out.println("게임끝");
	
	}

}
