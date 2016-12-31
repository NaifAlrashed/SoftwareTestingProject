import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserStorage {
	

	
	//file path and name
	private final File fileName = new File ("/Users/naifalrashed/Desktop/testing-project/TestingProject/storage/user.txt");
	
	//for reading files
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String line;
	
	//for writing files
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	
	
	//retrieve all users from the file and put them in an array list of users
	public ArrayList<User> retrieveAllUsers () {
		
		ArrayList<User> users = new ArrayList<User>();
        try {
            
            fileReader = new FileReader(fileName.getAbsoluteFile());

            bufferedReader = new BufferedReader(fileReader);
            
            String userName;
            String type;
            String credit;
            
            while((line = bufferedReader.readLine()) != null) {
                userName = line.substring(0, 15);
                type = line.substring(15, 18);
                credit = line.substring(18);
                
                userName = userName.trim();
                type = type.trim();
                credit = credit.trim();
                User user = new User (type, userName, credit);
                users.add(user);
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
        return users;
	}
	
	//save a user to the file
	public void addUser (User user) {
		
		String userName = user.getUserName();
		String credit = user.getCredit();
		String type = user.getType();
		
		for (int i = userName.length(); i < 15; i++) {
			userName += " ";
		}
		
		for (int i = credit.length(); i < 9; i++) {
			credit = "0" + credit;
		}
		
		String dataToBeStored = userName + " " + type + " " + credit;
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
	
	public void addUsers (ArrayList<User> users) {
		try {
			PrintWriter writer = new PrintWriter(fileName);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException ex) {
			System.out.println("failed to delete the file");
		}
		
		for (int y = 0; y < users.size(); y++) {
			String userName = users.get(y).getUserName();
			String credit = users.get(y).getCredit();
			String type = users.get(y).getType();
			
			for (int i = userName.length(); i < 15; i++) {
				userName += " ";
			}
			
			for (int i = credit.length(); i < 9; i++) {
				credit = "0" + credit;
			}
			
			String dataToBeStored = userName + " " + type + " " + credit;
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
	
	

}
