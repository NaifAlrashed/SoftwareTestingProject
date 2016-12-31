
public class BuySell extends DailyTransaction {
	private String eventName;
	private String sellerUserName;
	private String numOfTickets;
	private String pricePerTicket;
	
	public BuySell (String transactionCode, String sellerUserName, String numOfTickets, String eventName,
			String pricePerTicket) {
		super (transactionCode);
		setSellerUserName(sellerUserName);
		setNumOfTickets(numOfTickets);
		setPricePerTicket(pricePerTicket);
		setEventName (eventName);
	}
	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}
	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	/**
	 * @return the sellerUserName
	 */
	public String getSellerUserName() {
		return sellerUserName;
	}
	/**
	 * @param sellerUserName the sellerUserName to set
	 */
	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}
	/**
	 * @return the numOfTickets
	 */
	public String getNumOfTickets() {
		return numOfTickets;
	}
	/**
	 * @param numOfTickets the numOfTickets to set
	 */
	public void setNumOfTickets(String numOfTickets) {
		this.numOfTickets = numOfTickets;
	}
	/**
	 * @return the pricePerTicket
	 */
	public String getPricePerTicket() {
		return pricePerTicket;
	}
	/**
	 * @param pricePerTicket the pricePerTicket to set
	 */
	public void setPricePerTicket(String pricePerTicket) {
		this.pricePerTicket = pricePerTicket;
	}
}
