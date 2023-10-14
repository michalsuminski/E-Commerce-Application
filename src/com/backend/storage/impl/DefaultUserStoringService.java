package src.com.backend.storage.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import src.com.backend.enteties.Product;
import src.com.backend.enteties.User;
import src.com.backend.enteties.impl.DefaultProduct;
import src.com.backend.enteties.impl.DefaultUser;
import src.com.backend.storage.UserStoringService;

public class DefaultUserStoringService implements UserStoringService{

	@Override
	public void saveUser(User user) {
		String currentDirectory = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "finaltask";
		Path filePath = Paths.get(currentDirectory, "users.txt");
		String stringUser = String.valueOf(user.getId()) +  "," + user.getFirstName() + "," + user.getLastName() + "," + user.getEmail() + "," + user.getPassword();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toString(), true))) {  // true oznacza tryb append - czyli nie nadpisywanie a dodawanie
            writer.write(stringUser);
            writer.newLine();
            System.out.println("String has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}

	@Override
	public List<User> loadUsers() {
		String currentDirectory = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "finaltask";
		Path filePath = Paths.get(currentDirectory, "users.txt");
		if (!Files.exists(filePath)) {
			return null;
		}
		try {
			List<String[]> listOfUsersString = Files.readAllLines(filePath).stream().map(line -> line.split(",")).toList(); // tworze sobie z linii tablice id,nazwa,typ,cena
			List<User> listOfUsers = new ArrayList<User>();
			if(listOfUsersString.isEmpty()) {
				return listOfUsers;
			}
			for(String[] userInStringArray : listOfUsersString) {
				listOfUsers.add(new DefaultUser(Integer.parseInt(userInStringArray[0]), userInStringArray[1], userInStringArray[2], userInStringArray[3], userInStringArray[4]));
			}
			return listOfUsers;
		} catch (IOException e) {
            e.printStackTrace();
        }
		return null;  // musiałem dodać bo inaczej krzyczy, że missing return statement
	}

}
