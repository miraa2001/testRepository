package clinic.main;

public class Service {
	 String name;
	 double price ;

	public Service(String n, double p) {
		name = n;
		price = p;
	}
	
	public void setPrice(double Price) {
		price = Price;
		
	}
	
	public double getPrice() {
		return price;
	}

	
	public void setName(String Name) {
		name = Name;
		
	}
	
	public String getName() {
		return name;
	}
	@Override
	public String toString()
	{
		return name +"  " +price;
	}

}
