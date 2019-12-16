public class Billfold {
	
	private Card card1;
    private Card card2;  
    public void addCard(Card c)    {
       if (card1 == null)
          card1 = c;
       else if (card2 == null)
          card2 = c;
    }
    public String formatCards()    {
    		return "[" + card1.format() + " | " + card2.format() + "]";
    } 
 }