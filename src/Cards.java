import java.util.ArrayList;
import java.util.Random;

public class Cards {
	
	public Cards()
	{
		// Card deck object.
		deck = new ArrayList<CardRefs>();
		
		// Create random number generator object.
		randGen = new Random();
	}
	
	public void InitDeck()
	{
		// Make sure deck is empty.
		deck.clear();
		
		// Create unshuffled deck.
		for(CardRefs c : CardRefs.values())
		{
			deck.add(c);
		}		
	}
	
	public void PrintDeck()
	{
		for(CardRefs r : deck)
		{
			System.out.println(r);
		}
	}
	
	public void ShuffleDeck()
	{
		CardRefs[] temp = {CardRefs.EMPTY_DECK, CardRefs.EMPTY_DECK};
		
		for(int i = 0; i < 500000; i++)
		{
			int r = randGen.nextInt(deck.size() - 1);
			temp[0] = deck.get(r);
			
			int s = randGen.nextInt(deck.size() - 1);
			temp[1] = deck.get(s);
			
			// Swap the cards.
			deck.set(r, temp[1]);
			deck.set(s, temp[0]);
		}
	
	}
	
	public CardRefs Draw()
	{
		CardRefs currentCard = deck.get(0);
		
		if(currentCard == CardRefs.EMPTY_DECK)
		{
			System.out.println("Card deck is empty.");
			return CardRefs.EMPTY_DECK;
		}
		
		// We still have cards to draw!
		deck.remove(0); // Remove card from top of deck.
		
		System.out.println("Dealed card: " + currentCard);
		
		return currentCard;
	}
	
	public int GetCardValue(CardRefs card)
	{
		String[] rank = {"_A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "_J", "_Q", "_K"};
		
		for(int i = 0; i < rank.length; i++)
		{
			if(card.toString().contains(rank[i]))
				return cardVals[i];
		}
		
		return 0;
	}
	
	public enum CardRefs { SPADES_A, SPADES2, SPADES3, SPADES4, SPADES5, SPADES6, SPADES7, SPADES8, SPADES9, SPADES10, SPADES_J, SPADES_Q, SPADES_K,
		CLUBS_A, CLUBS2, CLUBS3, CLUBS4, CLUBS5, CLUBS6, CLUBS7, CLUBS8, CLUBS9, CLUBS10, CLUBS_J, CLUBS_Q, CLUBS_K,
		HEARTS_A, HEARTS2, HEARTS3, HEARTS4, HEARTS5, HEARTS6, HEARTS7, HEARTS8, HEARTS9, HEARTS10, HEARTS_J, HEARTS_Q, HEARTS_K,
		DIAMONDS_A, DIAMONDS2, DIAMONDS3, DIAMONDS4, DIAMONDS5, DIAMONDS6, DIAMONDS7, DIAMONDS8, DIAMONDS9, DIAMONDS10, DIAMONDS_J, DIAMONDS_Q, DIAMONDS_K,
		EMPTY_DECK
	};
	
	// Card values assigned to ACE, 2, 3 .. Queen, King.
	private int cardVals[] = {21, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	
	private ArrayList<CardRefs> deck;
	
	private Random randGen;
}
