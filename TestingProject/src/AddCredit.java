import java.util.ArrayList;

public class AddCredit {

	private String amountOfCredit;
	private final String TRANSACTION_TYPE = "06";
	private User user;
	//model objects
	private DailyTransaction transactionFile;
	private UserStorage userStorage;
	
	
	
	public AddCredit (User user) {
		this.user = user;
		transactionFile = new DailyTransaction ();
		userStorage = new UserStorage ();
	}
	
	public boolean performAddingCredit (String amountCredit) {
		ArrayList<User> users = userStorage.retrieveAllUsers();
		for (int i = 0; i < users.size(); i++) {
			if (user.getUserName().equals(users.get(i).getUserName())) {
				users.get(i).setCredit("" + (Double.parseDouble(users.get(i).getCredit()) + Double.parseDouble(amountCredit)));
				userStorage.addUsers(users);
				transactionFile.addCommonTransaction(new CommonTransaction (user, TRANSACTION_TYPE));
				return true;
						
					
			}
		}
		return false;
	}
	
}