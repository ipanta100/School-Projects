public class BillfoldTester {
	public static void main(String[] args)
    {
		Billfold b = new Billfold();
		
		IDCard ID1 = new IDCard("Edsger W. Dijkstra", "69420") ;
		DriverLicense DL1 = new DriverLicense("Edsger W. Dijkstra", "12345", 2006) ;
		
		b.addCard(ID1);
		b.addCard(DL1);

		
		Billfold bf = new Billfold();
		DebitCard DB1 = new DebitCard("Edsger W. Dijkstra", "12978", 1234) ;
		DebitCard DB2 = new DebitCard("Edsger W. Dijkstra", "12978", 1234) ;
		
		bf.addCard(DB1);
		bf.addCard(DB2);

	    System.out.println((b.formatCards()));
		if (ID1.equals(DL1))
		    System.out.println("Cards 1 and 2 are same as expected") ;
		else 
		    System.out.println("Surprisingly, cards 1 and 2 are not equal.") ;
		
		System.out.println((bf.formatCards()));
		if ((DB1.equals1(DB2)) && DB1.equals2(DB2))
		    System.out.println("Cards 1 and 2 are same as expected") ;
		else 
		    System.out.println("Surprisingly, cards 1 and 2 are not equal.") ;
    }
}
