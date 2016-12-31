import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AvailableTicketsStorage {
	private String eventName;
	private String sellerUserName;
	private String numOfTicketsForSale;
	private String pricePerTicket;
	
	//file path and name
	private final File fileName = new File ("/Users/naifalrashed/Desktop/testing-projectTestingProject/storage/available-tickets.txt");
	
	//for reading files
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String line;
	
	//for writing files
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	
	public AvailableTicketsStorage() {
		
	}
	public AvailableTicketsStorage (String eventName, String sellerUserName, String numOfTicketsForSale,
			String pricePerTicket) {
		setEventName(eventName);
		setSellerUserName(sellerUserName);
		setNumOfTicketsForSale(numOfTicketsForSale);
		setPricePerTicket(pricePerTicket);
	}
	
	public ArrayList<AvailableTicketsStorage> getAllAvailableTickets () {
		
		ArrayList<AvailableTicketsStorage> availableTickets = new ArrayList<AvailableTicketsStorage>();
        try {
            
            fileReader = new FileReader(fileName.getAbsoluteFile());

            bufferedReader = new BufferedReader(fileReader);
            
            String eventName;
            String sellerUserName;
            String numOfTicketsForSale;
            String pricePerTicket;
            
            while((line = bufferedReader.readLine()) != null) {
            	eventName = line.substring(0, 19);
            	sellerUserName = line.substring(19, 36);
            	numOfTicketsForSale = line.substring(36, 39);
            	pricePerTicket = line.substring(39, 46);
                
                eventName = eventName.trim();
                sellerUserName = sellerUserName.trim();
                numOfTicketsForSale = numOfTicketsForSale.trim();
                pricePerTicket = pricePerTicket.trim();
                AvailableTicketsStorage ticket = new AvailableTicketsStorage (eventName, sellerUserName,
                		numOfTicketsForSale, pricePerTicket);
                availableTickets.add(ticket);
            }
        } 
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName.getAbsolutePath() + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" + fileName + "'"); 
        }
        return availableTickets;
	}
		
	public void storeNewEvent (AvailableTicketsStorage availableTicketsStorage) {
		String eventName = availableTicketsStorage.getEventName();
		String sellerUserName = availableTicketsStorage.getSellerUserName();
		String numOfTicketsForSale = availableTicketsStorage.getNumOfTicketsForSale();
		String pricePerTicket = availableTicketsStorage.getPricePerTicket();
		
		for (int i = eventName.length(); i < 19; i++) {
			eventName += " ";
		}
		
		for (int i = sellerUserName.length(); i < 15; i++) {
			sellerUserName += " ";
		}
		
		for (int i = pricePerTicket.length(); i < 6; i++) {
			pricePerTicket = "0" + pricePerTicket;
		}
		
		for (int i = numOfTicketsForSale.length(); i < 3; i++) {
			numOfTicketsForSale = "0" + numOfTicketsForSale;
		}
		
		String dataToBeStored = eventName + " " + sellerUserName + " " + numOfTicketsForSale + " " +
				pricePerTicket;
		
        try {
            // Assume default encoding.
            fileWriter = new FileWriter(fileName, true);

            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(dataToBeStored);
            bufferedWriter.newLine();

            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
	}
	
	public void storeListOfAvailableTickets (ArrayList<AvailableTicketsStorage> tickets) {
		try {
			PrintWriter writer = new PrintWriter(fileName);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException ex) {
			
		}
		for (int y = 0; y < tickets.size(); y++) {
			AvailableTicketsStorage availableTicketsStorage = tickets.get(y);
			String eventName = availableTicketsStorage.getEventName();
			String sellerUserName = availableTicketsStorage.getSellerUserName();
			String numOfTicketsForSale = availableTicketsStorage.getNumOfTicketsForSale();
			String pricePerTicket = availableTicketsStorage.getPricePerTicket();
			
			for (int i = eventName.length(); i < 19; i++) {
				eventName += " ";
			}
			
			for (int i = sellerUserName.length(); i < 15; i++) {
				sellerUserName += " ";
			}
			
			for (int i = pricePerTicket.length(); i < 6; i++) {
				pricePerTicket = "0" + pricePerTicket;
			}
			
			for (int i = numOfTicketsForSale.length(); i < 3; i++) {
				numOfTicketsForSale = "0" + numOfTicketsForSale;
			}
			
			String dataToBeStored = eventName + " " + sellerUserName + " " + numOfTicketsForSale + " " +
					pricePerTicket;
			
	        try {
	            // Assume default encoding.
	            fileWriter = new FileWriter(fileName, true);

	            bufferedWriter = new BufferedWriter(fileWriter);

	            bufferedWriter.write(dataToBeStored);
	            bufferedWriter.newLine();

	            bufferedWriter.close();
	        }
	        catch(IOException ex) {
	            System.out.println("Error writing to file '" + fileName + "'");
	        }
		}
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
	 * @return the numOfTicketsForSale
	 */
	public String getNumOfTicketsForSale() {
		return numOfTicketsForSale;
	}
	/**
	 * @param numOfTicketsForSale the numOfTicketsForSale to set
	 */
	public void setNumOfTicketsForSale(String numOfTicketsForSale) {
		this.numOfTicketsForSale = numOfTicketsForSale;
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
