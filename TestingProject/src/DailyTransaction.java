import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DailyTransaction {
	
	private String transactionCode;
	
	//file path and name
	private final File fileName = new File ("/Users/naifalrashed/Desktop/testing-project/TestingProject/storage/daily-transaction.txt");
	
	//for reading files
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String line;
	
	//for writing files
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	
	public DailyTransaction (String transactionCode) {
		setTransactionCode(transactionCode);
	}
	
	public DailyTransaction () {
	}
	
	public void addRefundTransaction (Refund refund) {
		
		String buyerUserName = refund.getBuyerUserName();
		String sellerUserName = refund.getSellerUserName();
		String credit = refund.getRefundCredit();
		String code = refund.getTransactionCode();
		for (int i = buyerUserName.length(); i < 15; i++) {
			buyerUserName += " ";
		}
		
		for (int i = sellerUserName.length(); i < 15; i++) {
			sellerUserName += " ";
		}
		
		for (int i = credit.length(); i < 9; i++) {
			credit = "0" + credit;
		}
		
		String dataToBeStored = code + " " + buyerUserName + " " + sellerUserName + " " + credit;
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
	
	public void addBuySell (BuySell buySell) {
		String eventName = buySell.getEventName();
		String sellerUserName = buySell.getSellerUserName();
		String numOfTickets = buySell.getNumOfTickets();
		String pricePerTicket = buySell.getPricePerTicket();
		String code = buySell.getTransactionCode();
		for (int i = sellerUserName.length(); i < 15; i++) {
			sellerUserName += " ";
		}
		for (int j = eventName.length(); j < 19; j++) {
			eventName += " ";
		}
		
		for (int i = sellerUserName.length(); i < 15; i++) {
			sellerUserName += " ";
		}
		
		for (int i = numOfTickets.length(); i < 3; i++) {
			numOfTickets = "0" + numOfTickets;
		}
		
		for (int i = pricePerTicket.length(); i < 6; i++) {
			pricePerTicket = "0" + pricePerTicket;
		}
		
		String dataToBeStored = code + " " + eventName + " " + sellerUserName + " " + numOfTickets + " " + pricePerTicket;
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

	public void addCommonTransaction (CommonTransaction commonTransaction) {
		
		String userName = commonTransaction.getUser().getUserName();
		String credit = commonTransaction.getUser().getCredit();
		String type = commonTransaction.getUser().getType();
		String code = commonTransaction.getTransactionCode();
		for (int i = userName.length(); i < 15; i++) {
			userName += " ";
		}
		
		for (int i = credit.length(); i < 9; i++) {
			credit = "0" + credit;
		}
		
		String dataToBeStored = code + " " + userName + " " + type + " " + credit;
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

	/**
	 * @return the transactionCode
	 */
	public String getTransactionCode() {
		return transactionCode;
	}

	/**
	 * @param transactionCode the transactionCode to set
	 */
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	

}
