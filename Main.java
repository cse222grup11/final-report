//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.List;
//import java.util.Queue;
//import java.util.Scanner;
import java.util.*;
//import java.io.File;
import java.io.*;
public class Main {
	/**
	 * Yapılacaklar:
	 * 		1- update_UserDB fonksiyonu yazılacak
	 * 		2- javadoc yorumlar yazılacak
	 * 		3- veri yapılarını daha uygunlarıyla değiştirebilirsin (mesela ortadan silme işlemi yapacaksak stack ve queue anlamsız)
	 * 		4- test yapılacak
	 * @throws IOException 
	 * */

	public static void main(String[] args) throws IOException {
		
		Regular_User user = new Regular_User();
		user.setEmail("erdalBakkal@gtu.edu.tr"); 
		user.add_to_watchlist("new1 in watchlist");
		user.add_to_favourites("new1 in favorites");
		user.add_to_history("new1 in history");
		user.update_UserDB();
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

}
