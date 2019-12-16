public class Card {
    private String name; /* owner */

    public Card() //This is my superclass
    {
        name = "";
    }

    public Card(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public boolean isExpired() {
        return false;
    }

    public String format() {
        return "Card holder: " + name;
    }
    
    public boolean equals(Object other)
    {  
	if (other == null) return false ;
	Card card = (Card) other ;
	return name.equals(card.name) ;
    }
}

class IDCard extends Card {
    //This is one of my subclasses
    private String IDNumber;

    public IDCard(String n, String ID) {
        super(n);
        this.IDNumber = ID;
    }

    public String format() {
        return "(ID)" + super.format() + ", ID NUMBER: " + IDNumber;
    }
    public boolean equals(Object other)
    {  
	if (!super.equals(other)) return false ;
	IDCard card = (IDCard) other ;
	return IDNumber.equals(card.IDNumber) ;
    }
}

class DriverLicense extends IDCard {
    //This is one of my subclasses
    private int ExperationYear;
    
    public DriverLicense(String n, String ID, int EY) {
        super(n, ID);
        this.ExperationYear = EY;
    }

    public String format() {
        return "(DL)" + super.format() + ", EXPERATION YEAR: " + ExperationYear;
    }
    public boolean equals(Object other)
    { 
	if (!super.equals(other)) return false ;
	DriverLicense card = (DriverLicense) other ;
	return ExperationYear == (card.ExperationYear);
    }
}

class DebitCard extends Card {
    //This is one of my subclasses
	private String CardNumber;
	private int Pin;
	
	public DebitCard (String n, String CN, int P) {
		super(n);
		this.CardNumber = CN;
		this.Pin = P;
	}
	
	public String format() {
		return "(DC)" + super.format() + ", CARD NUMBER: " + CardNumber + ", PIN: " + Pin;
	}
	public boolean equals1(Object other)
    { 
	if (!super.equals(other)) return false ;
	DebitCard card = (DebitCard) other ;
	return CardNumber.equals(card.CardNumber);
    }
	public boolean equals2(Object some)
    { 
	if (!super.equals(some)) return false ;
	DebitCard card = (DebitCard) some ;
	return Pin == (card.Pin);
    }
}

