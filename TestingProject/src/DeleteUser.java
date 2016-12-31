import java.util.ArrayList;

public class DeleteUser {
	private User user;
	private UserStorage userStorage;
	private DailyTransaction transactionFile;
	private final String TRANSACTION_CODE = "02";
	
	public DeleteUser (User user) {
		setUser(user);
		userStorage = new UserStorage ();
		transactionFile = new DailyTransaction ();
	}
	
	
	//if user exists in file, delete it, add to transaction file, and return true, else return false
	public boolean deleteUser () {
		
		boolean isAvailable = false;
		ArrayList<User> users = userStorage.retrieveAllUsers();
		for (int i = 0; i < users.size(); i++) {
			if (getUser().getUserName().equals(users.get(i).getUserName())) {
				users.remove(i);
				isAvailable = true;
				break;
			}
			if (isAvailable)
				break;
		}
		
		if (isAvailable) {
			userStorage.addUsers(users);
			transactionFile.addCommonTransaction (new CommonTransaction (user, TRANSACTION_CODE));
			return true;
		}
		else
			return false;
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

	/**
	 * @return the userStorage
	 */
	public UserStorage getUserStorage() {
		return userStorage;
	}

	/**
	 * @param userStorage the userStorage to set
	 */
	public void setUserStorage(UserStorage userStorage) {
		this.userStorage = userStorage;
	}

	/**
	 * @return the transactionFile
	 */
	public DailyTransaction getTransactionFile() {
		return transactionFile;
	}

	/**
	 * @param transactionFile the transactionFile to set
	 */
	public void setTransactionFile(DailyTransaction transactionFile) {
		this.transactionFile = transactionFile;
	}

	/**
	 * @return the tRANSACTION_CODE
	 */
	public String getTRANSACTION_CODE() {
		return TRANSACTION_CODE;
	}
}
