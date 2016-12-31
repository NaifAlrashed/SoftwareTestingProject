import java.util.ArrayList;

public class Buy {
	private String sellerUserName;
	private String numOfTickets;
	private String eventTitle;
	private final String TRANSACTION_CODE = "04";
	
	private DailyTransaction transactionFile;
	private AvailableTicketsStorage availableTickets;
	
	public Buy (String sellerUserName, String numOfTickets,	String eventTitle) {
		this.sellerUserName = sellerUserName;
		this.numOfTickets = numOfTickets;
		this.eventTitle = eventTitle;
		transactionFile = new DailyTransaction ();
		availableTickets = new AvailableTicketsStorage ();
	}
	
	
	//searches for the price per ticket through the event name, then multiply the number of tickets
	//with the price, if event isn't found, return -1
	public double retrievePrice () {
		ArrayList<AvailableTicketsStorage> tickets = availableTickets.getAllAvailableTickets();
		for (int i = 0; i < tickets.size(); i++) {
			if (eventTitle.equals(tickets.get(i).getEventName()))
					return (Double.parseDouble(tickets.get(i).getPricePerTicket()) * Double.parseDouble(numOfTickets));
		}
		return -1;
	}
	
	//a function that adds the purchasing information to the transaction file
	public boolean addOperationToTransactionFile () {
		ArrayList<AvailableTicketsStorage> tickets = availableTickets.getAllAvailableTickets();
		for (int i = 0; i < tickets.size(); i++) {
			if (eventTitle.equals(tickets.get(i).getEventName())) {
				if (Double.parseDouble(numOfTickets) > Double.parseDouble(tickets.get(i).getNumOfTicketsForSale()))
					return false;
				else {
					tickets.get(i).setNumOfTicketsForSale("" + (Double.parseDouble(tickets.get(i).getNumOfTicketsForSale()) - Double.parseDouble(numOfTickets)));
					availableTickets.storeListOfAvailableTickets(tickets);
					transactionFile.addBuySell(new BuySell (TRANSACTION_CODE, sellerUserName,
							numOfTickets, eventTitle, "" + (Double.parseDouble(tickets.get(i).getNumOfTicketsForSale()) - Double.parseDouble(numOfTickets))));
					return true;
				}
			}
		}
		return false;
	}
	
	
}
