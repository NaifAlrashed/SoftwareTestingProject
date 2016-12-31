import java.util.ArrayList;

public class Logout {
	public void presentDailyTransactionFile (ArrayList<String> transactions) {
		for (int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i));
		}
	}
}
