
public class CardDeck {
	
	public static void main(String[] args)
	{
		Cards pack = new Cards();
		
		pack.ShuffleDeck();
		System.out.println("With value: " + pack.GetCardValue(pack.Draw()));
		System.out.println("With value: " + pack.GetCardValue(pack.Draw()));
		
		// Shuffle again with less cards in deck.
		pack.ShuffleDeck();
		System.out.println("With value: " + pack.GetCardValue(pack.Draw()));
		System.out.println("With value: " + pack.GetCardValue(pack.Draw()));
		
		System.out.println("Draw remaining cards until all have been dealt it...");
		while(pack.GetCardValue(pack.Draw()) > 0);

	}

}