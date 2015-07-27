
public class CardDeck {

	public static void main(String[] args)
	{
		Cards pack = new Cards();

		pack.InitDeck();

		pack.ShuffleDeck();
		System.out.println("With value: " + pack.GetCardValue(pack.Draw()));
		System.out.println("With value: " + pack.GetCardValue(pack.Draw()));

		// Shuffle again with less cards in deck.
		pack.ShuffleDeck();
		System.out.println("With value: " + pack.GetCardValue(pack.Draw()));
		System.out.println("With value: " + pack.GetCardValue(pack.Draw()));

		System.out.println("Draw remaining cards until all have been dealt...");
		while(pack.GetCardValue(pack.Draw()) > 0);

		// Attempt shuffle with no cards in deck.
		pack.ShuffleDeck();
	}

}
