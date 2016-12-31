import java.util.ArrayList;

public class RefundUser {
	String buyerUserName;
	String sellerUserName;
	private final String TRANSACTION_CODE = "05";
	UserStorage userStorage;
	DailyTransaction transactionFile;
	
	public RefundUser (String buyerUserName, String sellerUserName) {
		this.buyerUserName = buyerUserName;
		this.sellerUserName = sellerUserName;
		userStorage = new UserStorage();
		transactionFile = new DailyTransaction();
	}
	//performs the refund. If there isn't enough credit in the seller or couldn't find the given buyer or seller, return false,
	//else return true
	public boolean performRefund (double amountOfCredit) {
		ArrayList<User> users = userStorage.retrieveAllUsers();
		for (int i = 0; i < users.size(); i++) {
			if (buyerUserName.equals(users.get(i).getUserName())) {
				for (int j = 0; j < users.size(); j++) {
					if (sellerUserName.equals(users.get(j).getUserName())) {
						if (amountOfCredit > Double.parseDouble(users.get(j).getCredit()))
							return false;
						else {
							users.get(i).setCredit("" + (Double.parseDouble(users.get(i).getCredit()) + amountOfCredit));
							users.get(j).setCredit("" + (Double.parseDouble(users.get(j).getCredit()) - amountOfCredit));
							userStorage.addUsers(users);
							transactionFile.addRefundTransaction(new Refund (TRANSACTION_CODE, buyerUserName, sellerUserName,
									amountOfCredit + ""));
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
