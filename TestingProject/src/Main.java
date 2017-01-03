import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		if (args.length != 0) {
			login(args, 0);
			System.exit(1);
		}
		login ();
	}
	//handles UI routing for login, and call underlying Login business logic
	public static void login () {
		Scanner input = new Scanner (System.in);
		while (true) {
			System.out.println("enter username");
			String userName = input.nextLine();
			Login login = new Login (userName);
			if (login.isExist()) {
				User user = login.getUser();
				switch (user.getType()) {
					case "AA":
						admin (user);
						break;
					case "FS":
						fullStandard (user);
						break;
					case "BS":
						buyStandard (user);
						break;
					case "SS":
						sellStandard (user);
						break;
					default:
						System.out.println("invalid input, bye");
				}
			}
			else {
				System.out.println("invalid user name");
				continue;
			}
		}
	}
	public static void login (String args[], int pos) {
		String userName = args[pos];
		pos++;
		Login login = new Login (userName);
		if (login.isExist()) {
			User user = login.getUser();
			switch (user.getType()) {
				case "AA":
					admin (user);
					break;
				case "FS":
					fullStandard (user, args, pos);
					break;
				case "BS":
					buyStandard (user, args, pos);
					break;
				case "SS":
					sellStandard (user, args, pos);
					break;
				default:
					System.out.println("invalid input, bye");
			}
		}
		else {
			System.out.println("invalid user name");
		}
	}
	//handles UI routing for admin
	public static void admin (User user) {
		Scanner input = new Scanner (System.in);
		while (true) {
			System.out.println("please enter 0 for creating a user, 1 for deleting a user,");
			System.out.println("2 for refund, 3 for addcredit, and 4 for logout");
			String userInput = input.nextLine();
			switch (userInput) {
				case "0":
					create(user);
					break;
				case "1":
					delete(user);
					break;
				case "2":
					refund(user);
					break;
				case "3":
					addCredit(user);
					break;
				case "4":
					logout(user);
					break;
			}
		}
	}
	public static void admin (User user, String args [], int pos) {
		String userInput = args [pos];
		switch (userInput) {
			case "0":
				create(user, args, pos + 1);
				break;
			case "1":
				delete(user, args, pos + 1);
				break;
			case "2":
				refund(user, args, pos + 1);
				break;
			case "3":
				addCredit(user, args, pos + 1);
				break;
			case "4":
				logout(user);
				break;
		}
	}
	//handles UI routing for users with full standard privlages
	public static void fullStandard (User user) {
		Scanner input = new Scanner (System.in);
		while (true) {
			System.out.println("please enter 0 for buying, 1 for adding credit, 2 for selling,"
					+ "\n and 2 for logging out");
			String userInput = input.nextLine();
			switch (userInput) {
				case "0":
					buy(user);
					break;
				case "1":
					addCredit(user);
					break;
				case "2":
					sell(user);
					break;
				case "3":
					logout(user);
					break;
			}
		}
	}
	public static void fullStandard (User user, String args [], int pos) {
		String userInput = args[pos];
		switch (userInput) {
			case "0":
				buy(user, args, pos + 1);
				break;
			case "1":
				addCredit(user, args, pos + 1);
				break;
			case "2":
				sell(user, args, pos + 1);
				break;
			case "3":
				logout(user);
				break;
		}
	}
	//handles UI routing for buy standard prevlages
	public static void buyStandard (User user) {
		Scanner input = new Scanner (System.in);
		while (true) {
			System.out.println("please enter 0 for buying, 1 for adding credit, and 2 for logging out");
			String userInput = input.nextLine();
			switch (userInput) {
				case "0":
					buy(user);
					break;
				case "1":
					addCredit(user);
					break;
				case "2":
					logout(user);
					break;
			}
		}
	}
	public static void buyStandard (User user, String args [], int pos) {
		String userInput = args[pos];
		switch (userInput) {
			case "0":
				buy(user, args, pos + 1);
				break;
			case "1":
				addCredit(user, args, pos + 1);
				break;
			case "2":
				logout(user);
				break;
		}
	}
	//handles UI routing for sell standard prevlages
	public static void sellStandard (User user) {
		Scanner input = new Scanner (System.in);
		while (true) {
			System.out.println("please enter 0 for selling, 1 for adding credit, and 2 for logging out");
			String userInput = input.nextLine();
			switch (userInput) {
				case "0":
					sell(user);
					break;
				case "1":
					addCredit(user);
					break;
				case "2":
					logout(user);
					break;
			}
		}
	}
	public static void sellStandard (User user, String args [], int pos) {
		String userInput = args[pos];
		switch (userInput) {
			case "0":
				sell(user, args, pos + 1);
				break;
			case "1":
				addCredit(user, args, pos + 1);
				break;
			case "2":
				logout(user);
				break;
		}
	}
	//handles UI routing for create, and call underlying Login business logic
	public static void create (User user) {
		Scanner input = new Scanner (System.in);
		String userName, userType;
		System.out.println ("enter user name");
		userName = input.nextLine();
		System.out.println ("enter user type");
		userType = input.nextLine();
		CreateUser createUser = new CreateUser (new User (userType, userName, "0"));
		if (createUser.addNewUser())
			System.out.println("success");
		else
			System.out.println("failure");
		admin(user);
	}
	public static void create (User user, String args [], int pos) {
		String userName, userType;
		userName = args[pos];
		pos++;
		userType = args[pos];
		pos++;
		CreateUser createUser = new CreateUser (new User (userType, userName, "0"));
		if (createUser.addNewUser())
			System.out.println("success");
		else
			System.out.println("failure");
		logout(user);
	}
	//handles UI routing for logout, and terminate the program
	public static void logout (User user) {
		System.exit(0);
	}
	//handles UI routing for deleting, and call underlying Login business logic
	public static void delete (User user) {
		Scanner input = new Scanner (System.in);
		System.out.println ("enter the username of the account to be deleted");
		String userName = input.nextLine();
		DeleteUser delete = new DeleteUser (new User ("", userName, ""));
		if (delete.deleteUser())
			System.out.println("success");
		else
			System.out.println("user does not exist");
		admin (user);
	}
	public static void delete (User user, String args[], int pos) {
		String userName = args[pos];
		DeleteUser delete = new DeleteUser (new User ("", userName, ""));
		if (delete.deleteUser())
			System.out.println("success");
		else
			System.out.println("user does not exist");
		admin (user);
	}
	//handles UI routing for selling, and call underlying Login business logic
	public static void sell (User user) {
		Scanner input = new Scanner (System.in);
		String eventTitle, numOfTickets, salePrice;
		System.out.println ("enter the sale price");
		salePrice = input.nextLine();
		System.out.println ("enter the event title");
		eventTitle = input.nextLine();
		System.out.println ("enter the number of tickets");
		numOfTickets = input.nextLine();
		Sell sell = new Sell(new User (user.getType(), user.getUserName(), user.getCredit()), eventTitle, salePrice, numOfTickets);
		if (sell.createEvent())
			System.out.println("success");
		else
			System.out.println("failure");
		sellStandard(user);
	}
	public static void sell (User user, String args [], int pos) {
		String eventTitle, numOfTickets, salePrice;
		salePrice = args[pos];
		pos++;
		eventTitle = args[pos];
		pos++;
		numOfTickets = args[pos];
		pos++;
		Sell sell = new Sell(new User (user.getType(), user.getUserName(), user.getCredit()), eventTitle, salePrice, numOfTickets);
		if (sell.createEvent())
			System.out.println("success");
		else
			System.out.println("failure");
		logout(user);
	}
	//handles UI routing for buying, and call underlying Login business logic
	public static void buy (User user) {
		Scanner input = new Scanner (System.in);
		String sellerUserName, eventTitle, numOfTickets;
		System.out.println ("enter the seller username");
		sellerUserName = input.nextLine();
		System.out.println ("enter the event title");
		eventTitle = input.nextLine();
		System.out.println ("enter the number of tickets");
		numOfTickets = input.nextLine();
		Buy buy = new Buy (sellerUserName, numOfTickets, eventTitle);
		System.out.println("the price is " + buy.retrievePrice()
				+ "\ntype 0 for yes and 1 for no");
		String output = input.nextLine();
		if (output.equals("0")) {
			if (buy.addOperationToTransactionFile())
				System.out.println("success");
			else
				System.out.println("failure, check the correctness of the event name");
		}
		if (user.getType().equals("FS"))
			fullStandard(user);
		else
			buyStandard(user);
	}
	public static void buy (User user, String args [], int pos) {
		String sellerUserName, eventTitle, numOfTickets;
		sellerUserName = args[pos];
		pos++;
		eventTitle = args[pos];
		pos++;
		numOfTickets = args[pos];
		pos++;
		Buy buy = new Buy (sellerUserName, numOfTickets, eventTitle);
		String output = args[pos];
		pos++;
		if (output.equals("0")) {
			if (buy.addOperationToTransactionFile())
				System.out.println("success");
			else
				System.out.println("failure, check the correctness of the event name");
		}
		logout(user);
	}
	//handles UI routing for refund, and call underlying Login business logic
	public static void refund (User user) {
		Scanner input = new Scanner (System.in);
		String buyerUserName, sellerUserName;
		double amountOfCredit;
		System.out.println ("enter the buyer username");
		buyerUserName = input.nextLine();
		System.out.println ("enter the seller username");
		sellerUserName = input.nextLine();
		System.out.println ("enter the amount of credit");
		amountOfCredit = input.nextDouble();
		RefundUser refundUser = new RefundUser (buyerUserName, sellerUserName);
		if (refundUser.performRefund(amountOfCredit))
			System.out.println("success");
		else
			System.out.println("failed, could be due to low seller credit, or invalid usernames");
		admin(user);
	}
	public static void refund (User user, String args [], int pos) {
		String buyerUserName, sellerUserName;
		double amountOfCredit;
		buyerUserName = args[pos];
		pos++;
		sellerUserName = args[pos];
		pos++;
		amountOfCredit = Double.parseDouble(args[pos]);
		RefundUser refundUser = new RefundUser (buyerUserName, sellerUserName);
		if (refundUser.performRefund(amountOfCredit))
			System.out.println("success");
		else
			System.out.println("failed, could be due to low seller credit, or invalid usernames");
		logout(user);
	}
	//handles UI routing for adding credit, and call underlying Login business logic
	public static void addCredit (User user) {
		Scanner input = new Scanner (System.in);
		String amountOfCredit;
		if (user.getType().equals("AA")) {
			String userName;
			System.out.println("enter username");
			userName = input.nextLine();
			System.out.println("enter amount of credit to be added");
			amountOfCredit = input.nextLine();
			AddCredit addCredit = new AddCredit (new User ("AA", userName, amountOfCredit));
			if (addCredit.performAddingCredit(amountOfCredit))
				System.out.println("success");
			else
				System.out.println("failure");
			admin(user);
		}
		else {
			System.out.println("enter amount of credit to be added");
			amountOfCredit = input.nextLine();
			AddCredit addCredit = new AddCredit (user);
			if (addCredit.performAddingCredit(amountOfCredit))
				System.out.println("success");
			else
				System.out.println("failure");
			return;
		}
	}
	public static void addCredit (User user, String args [], int pos) {
		String amountOfCredit;
		if (user.getType().equals("AA")) {
			String userName;
			userName = args[pos];
			pos++;
			amountOfCredit = args[pos];
			pos++;
			AddCredit addCredit = new AddCredit (new User ("AA", userName, amountOfCredit));
			if (addCredit.performAddingCredit(amountOfCredit))
				System.out.println("success");
			else
				System.out.println("failure");
			admin(user);
		}
		else {
			amountOfCredit = args[pos];
			pos++;
			AddCredit addCredit = new AddCredit (user);
			if (addCredit.performAddingCredit(amountOfCredit))
				System.out.println("success");
			else
				System.out.println("failure");
			logout(user);
		}
	}
}
