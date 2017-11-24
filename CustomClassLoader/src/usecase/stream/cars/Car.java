package usecase.stream.cars;

public class Car
{
	public boolean isAutomatic() {
		return isAutomatic;
	}
	public void setAutomatic(boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
	}
	public int getMfgYear() {
		return mfgYear;
	}
	public void setMfgYear(int mfgYear) {
		this.mfgYear = mfgYear;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private boolean isAutomatic;
	private int mfgYear;
	private String company;
	private long price;
	private String name;
	
	public Car(boolean isAutomatic, int mfgYear, String company, long price, String name) {
		super();
		this.isAutomatic = isAutomatic;
		this.mfgYear = mfgYear;
		this.company = company;
		this.price = price;
		this.name = name;
	}
	
}
