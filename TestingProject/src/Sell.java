
public class Sell {
	private String eventTitle;
	private String salePrice;
	private String numOfAvailableTickets;
	private User user;
	private DailyTransaction transactionFile;
	private AvailableTicketsStorage ticketsStorage;
	private final String TRANSACTION_CODE = "03";
	
	public Sell (User user, String eventTitle, String salePrice, String numOfAvailableTickets) {
		setUser (user);
		setEventTitle (eventTitle);
		setSalePrice (salePrice);
		setNumOfAvailableTickets(numOfAvailableTickets);
		transactionFile = new DailyTransaction ();
		ticketsStorage = new AvailableTicketsStorage ();
	}
	
	//
	public boolean createEvent () {
		if (user.getType().equals("BS"))
			return false;
		else {
			ticketsStorage.storeNewEvent (new AvailableTicketsStorage (eventTitle, user.getUserName(),
					numOfAvailableTickets, salePrice));
			transactionFile.addBuySell(new BuySell (TRANSACTION_CODE,
					user.getUserName(), numOfAvailableTickets, eventTitle, salePrice));
			return true;
		}
	}
	
	
	/**
	 * @return the eventTitle
	 */
	public String getEventTitle() {
		return eventTitle;
	}
	/**
	 * @param eventTitle the eventTitle to set
	 */
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	/**
	 * @return the salePrice
	 */
	public String getSalePrice() {
		return salePrice;
	}
	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	/**
	 * @return the numOfAvailableTickets
	 */
	public String getNumOfAvailableTickets() {
		return numOfAvailableTickets;
	}
	/**
	 * @param numOfAvailableTickets the numOfAvailableTickets to set
	 */
	public void setNumOfAvailableTickets(String numOfAvailableTickets) {
		this.numOfAvailableTickets = numOfAvailableTickets;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
