import java.util.ArrayList;

public class Login {
	
	private String userName;
	private UserStorage userStorage;
	
	public Login (String userName) {
		setUserName (userName);
		userStorage = new UserStorage();
	}
	
	//a function that returns false if the user exists in the user.txt file
	public boolean isExist () {
		ArrayList<User> users = userStorage.retrieveAllUsers();
		for (int i = 0; i < users.size(); i++) {
			if (userName.equals(users.get(i).getUserName()))
					return true;
		}
		return false;
	}
	
	public User getUser () {
		ArrayList<User> users = userStorage.retrieveAllUsers();
		for (int i = 0; i < users.size(); i++) {
			if (userName.equals(users.get(i).getUserName()))
					return users.get(i);
		}
		return null;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
