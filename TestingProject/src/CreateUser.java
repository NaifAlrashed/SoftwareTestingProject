import java.util.ArrayList;

public class CreateUser {
	private User user;
	private UserStorage userStorage;
	private DailyTransaction transactionFile;
	private final String TRANSACTION_CODE = "01";
	
	public CreateUser (User user) {
		this.user = user;
		userStorage = new UserStorage ();
		transactionFile = new DailyTransaction ();

	}
	//a helper method to addNewUser to check whether the user to be added is in the users file
	private boolean isValidUser () {
		ArrayList<User> users = userStorage.retrieveAllUsers();
		for (int i = 0; i < users.size(); i++) {
			if (getUser().getUserName().equals(users.get(i).getUserName()))
					return false;
		}
		return true;
	}
	//if user is not in file, add user to file and return true, else return false
	public boolean addNewUser () {
		if (isValidUser()) {
			System.out.println(user.getUserName());
			userStorage.addUser(user);
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
	
	

}
