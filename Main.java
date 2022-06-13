//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.List;
//import java.util.Queue;
//import java.util.Scanner;
import java.util.*;

import javax.management.MBeanOperationInfo;
import javax.naming.InitialContext;

//import java.io.File;
import java.io.*;
public class Main {
	private static final String USERDB = "userDB.dat";
	private static final String MOVIEDB = "movieDB.dat";
	private static final String REPORTDB = "reportDB.dat";

	private static ArrayList<Regular_User> userDB;
	private static ArrayList<Movie> movieDB;
	private static ArrayList<Report> reports;

	private static Scanner sc;

	private static Regular_User usr;


	/**
	 * Yapılacaklar:
	 * 		1- update_UserDB fonksiyonu yazılacak
	 * 		2- javadoc yorumlar yazılacak
	 * 		3- veri yapılarını daha uygunlarıyla değiştirebilirsin (mesela ortadan silme işlemi yapacaksak stack ve queue anlamsız)
	 * 		4- test yapılacak
	 * @throws IOException 
	 * */

	public static void main(String[] args) throws IOException {
		sc = new Scanner(System.in);
		initialize();
		update_movieDB();
		openPage();
		/*Regular_User user = new Regular_User();
		user.setEmail("erdalBakkal@gtu.edu.tr"); 
		user.add_to_watchlist("new1 in watchlist");
		user.add_to_favourites("new1 in favorites");
		user.add_to_history("new1 in history");
		user.update_UserDB();*/
	//	user.update_UserDB_favorites();
	//	user.update_UserDB_history();
		/*
		try {
			fill_watchlist_queue();
			fill_favourites_list();
			fill_history_stack();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			add_to_watchlist("Don't let the kids hear, don't let the kids hear, don't let the kids hear, don't let the kids hear");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(String s : que)
			System.out.println(s);
*/
		
	}



	private static void openPage(){
		System.out.println("Welcome to Jetflix");
		System.out.println("1. Admin Login");
		System.out.println("2. User Login");
		System.out.println("3. Don't Have an Account? Sign Up!");
		System.out.println("4. Exit");
		System.out.print("Select: ");
		while(true){
			int select = readInput();
			switch(select){
				case 1:
					adminLogin();
					return;
				case 2:
					break;
				case 3: 
					break;
				case 4:
					update_UserDB();
					update_movieDB();
					update_reportDB();
					System.out.println("See you!");
					return;
				default:
					System.out.print("You have pressed a wrong button. Select again: ");

			}
		}
	}

	private static void adminLogin(){
		String username, passwrd;
		while(true){
			System.out.print("Enter username: ");
			sc.nextLine();
			username = sc.nextLine();
			System.out.print("Enter password: ");
			passwrd = sc.nextLine();
			if(username.equals("admin") && passwrd.equals("admin")){
				adminMenu();
				return;
			}
			System.out.println("Wrong username/password. Try again.");
		}


	}

	private static void adminMenu(){
		while(true){
			System.out.println("Welcome to Admin Menu");
			System.out.println("1. Review Reports");
			System.out.println("2. Add Movie to Database");
			System.out.println("3. Delete Movie from Database");
			System.out.println("4. Edit Movie from Database");
			System.out.println("5. Logout");
			System.out.println("Current movies:");
			for(int i = 0; i < movieDB.size(); i++){
				System.out.println(movieDB.get(i).get_show_id());
			}
			System.out.print("Selection: ");
			int selection = readInput();
			switch(selection){
				case 1:
					reviewReports();
					break;
				case 2:
					addMovie();
					break;
				case 3:
					deleteMovie();
					break;
				case 4:
					return;
				case 5:
					return;
			}
		}	
	}

	private static void reviewReports(){
		System.out.println("Here are the list of reports: ");
		for(int i = 0; i < reports.size(); i++){
			System.out.println("Report " + i+1);
			printReportData(reports.get(i));
		}
		System.out.println("Select Report ID: ");
		System.out.println("Press 0 to return to menu: ");
		int select = readInput();
		if(select == 0){
			return;
		}
		if(select < 0 || select >= reports.size()){
			System.out.println("Invalid selection");
			return;
		}
		System.out.println("Select action");
		System.out.println("1. Ban User");
		System.out.println("2. Delete Comment");
		System.out.println("3. Dismiss");
		System.out.print("Select: ");
		select = readInput();
		switch(select){
			case 1:
				userDB.remove(reports.get(select - 1).getReported_user());
				reports.remove(reports.get(select - 1));
				update_UserDB();
				update_movieDB();
				update_reportDB();
				System.out.println("User is banned. Press any key to continue.");
				sc.nextLine();
				break;
			case 2:
				Movie m = reports.get(select - 1).get_commented_movie();
				for(int i = 0; i < movieDB.size(); i++){
					if(movieDB.get(i).equals(m)){
						movieDB.remove(i);
						break;
					}
				}
				reports.remove(reports.get(select - 1));
				update_movieDB();
				update_reportDB();
				System.out.println("Comment is deleted. Press any key to continue.");
				sc.nextLine();
				break;
			case 3:
				reports.remove(reports.get(select - 1));
				update_reportDB();
				System.out.println("Report is dismissed. Press any key to continue.");
				sc.nextLine();
				break;
		}
	}

	private static void addMovie(){
		Movie mov = new Movie();
		System.out.print("Enter Movie Name: ");
		sc.nextLine(); mov.set_show_id(sc.nextLine());
		System.out.print("Enter Movie Director: ");
		mov.set_director(sc.nextLine());
		System.out.print("Enter Movie Cast: ");
		mov.set_cast(sc.nextLine());
		System.out.print("Enter Movie Country: ");
		mov.set_country(sc.nextLine());
		System.out.print("Enter Movie Description: ");
		mov.set_description(sc.nextLine());
		System.out.print("Enter Movie Release Date: ");
		mov.set_release_date(sc.nextInt());
		System.out.print("Enter Movie Duration: ");
		mov.set_duration(sc.nextInt());
		System.out.print("Enter Movie IMDB Score ");
		mov.set_IMDB_score(sc.nextFloat());
		System.out.print("Enter Movie Rating: ");
		mov.set_rating(sc.nextFloat());
		movieDB.add(mov);
		update_movieDB();
		System.out.println("The movie is added to database");
		printMovieData(mov);
		System.out.println("Press any key to return to Admin menu.");
		sc.nextLine();sc.nextLine();
	}

	private static void deleteMovie(){
		String s;
		System.out.print("Enter the name of the movie: ");
		sc.nextLine();
		s = sc.nextLine();
		for(int i = 0; i < movieDB.size(); i++){
			if(movieDB.get(i).get_show_id().equals(s)){
				movieDB.remove(i);
				update_movieDB();
				System.out.println("Movie is deleted. Press any key to continue.");
				sc.nextLine();
				break;
			}
		}
	}

	private static void printMovieData(Movie mov){
		System.out.println("Name: " + mov.get_show_id());
		System.out.println("Director: " + mov.get_director());
		System.out.println("Cast: " + mov.get_cast());
		System.out.println("Country: " + mov.get_country());
		System.out.println("Description: " + mov.get_description());
		System.out.println("Release Date: " + mov.get_release_date());
		System.out.println("Duration: " + mov.get_duration());
		System.out.println("IMDB Score: " + mov.get_IMDB_score());
		System.out.println("Rating: " + mov.get_rating());
	}

	private static void printReportData(Report rep){
		System.out.println("Reporting: " + rep.getReported_user().getName() + " " + rep.getReported_user().getSurname());
		System.out.println("Reported by:" + rep.getReporting_user().getName() + " " + rep.getReporting_user().getSurname());
		System.out.println("Commented Movie: " + rep.get_commented_movie().get_show_id());
		System.out.println("Comment: " + rep.getReported_comment().getComment_text());
	}

	private static int readInput(){
        int input;
        try {
            input = sc.nextInt();
            return input;
        } 
        catch (Exception InputMismatchException) {
            sc.nextLine();
            return 0;
        }
    }
	
	@SuppressWarnings("unchecked")
	private static void initialize(){
		userDB = new ArrayList<Regular_User>();
		movieDB = new ArrayList<Movie>();
		reports = new ArrayList<Report>();
		//Movie
		try{
			FileInputStream fis = new FileInputStream(MOVIEDB);
			ObjectInputStream ois = new ObjectInputStream(fis);

            movieDB = (ArrayList<Movie>) ois.readObject();
            ois.close();
		}
		catch(IOException ex){
			try{
				FileOutputStream fos = new FileOutputStream(MOVIEDB);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(movieDB);
				oos.close();
			}
			catch(IOException e){
				System.out.println("Error: Movie Database File Write");
				return;
			}
		}
		catch(ClassNotFoundException ex){
		}
		//Report
		try{
			FileInputStream fis = new FileInputStream(REPORTDB);
			ObjectInputStream ois = new ObjectInputStream(fis);

            reports = (ArrayList<Report>) ois.readObject();
            ois.close();
		}
		catch(IOException ex){
			try{
				FileOutputStream fos = new FileOutputStream(REPORTDB);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(reports);
				oos.close();
			}
			catch(IOException e){
				System.out.println("Error: Report Database File Write");
				return;
			}
		}
		catch(ClassNotFoundException ex){
		}
		//User
		try{
			FileInputStream fis = new FileInputStream(USERDB);
			ObjectInputStream ois = new ObjectInputStream(fis);

            userDB = (ArrayList<Regular_User>) ois.readObject();
            ois.close();
		}
		catch(IOException ex){
			try{
				FileOutputStream fos = new FileOutputStream(USERDB);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(userDB);
				oos.close();
			}
			catch(IOException e){
				System.out.println("Error: Movie Database File Write");
				return;
			}
		}
		catch(ClassNotFoundException ex){
		}
	}

	private static void update_UserDB(){
		try{
			FileOutputStream fos = new FileOutputStream(USERDB);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userDB);
			oos.close();
		}
		catch(IOException e){
			System.out.println("Error: Movie Database File Write");
			return;
		}
	}

	private static void update_movieDB(){
		try{
			FileOutputStream fos = new FileOutputStream(MOVIEDB);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(movieDB);
			oos.close();
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println("Error: Movie Database File Write");
			return;
		}
	}

	private static void update_reportDB(){
		try{
			FileOutputStream fos = new FileOutputStream(REPORTDB);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(reports);
			oos.close();
		}
		catch(IOException e){
			System.out.println("Error: Report Database File Write");
			return;
		}
	}


}
