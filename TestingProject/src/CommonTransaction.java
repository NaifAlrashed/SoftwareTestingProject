
public class CommonTransaction extends DailyTransaction {
	private User user;
	
	public CommonTransaction(User user, String transactionCode) {
		super (transactionCode);
		setUser(user);
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
