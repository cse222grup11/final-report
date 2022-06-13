
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * update_userDb methodu tekrar gözden geçirilecek!!
 * Watchlist Queue SkipList olarak değiştirildi kontrol edilmesi gerek!!
 * Geri kalan fonksiyonlarda complex bir şey mainde kontrol edilmesi gerek
 * 
 */

public class RegularUser {

    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;

	private SkipList<String> temp = new SkipList<>();
	private List<String> fav = new LinkedList<>();
	private AVLTree<String> buffer = new AVLTree<>();

	public RegularUser()
	{
		name = "NoNameYet";
		surname= "NoSurNameYet";
		age = -1;
		email = "NoEmailYet";
		password = "NoPasswordYet";
	}
	
	public RegularUser(String name,String surname,int age,String email,String password)
	{
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	private void fill_watchlist_queue()throws FileNotFoundException{
		FileInputStream fis=new FileInputStream("UsersDB.txt");       
		Scanner sc=new Scanner(fis);
		String line="";
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if(line.equals(email))
				break;			
		}  
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if(line.equals("watchlistBegin"))
				break;			
		}
		
		while(sc.hasNextLine() && !line.equals("##")) {
			line = sc.nextLine();
			if(line.equals("watchlistEnd"))
				break;			
			temp.insert(line);

		}
	}


    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public SkipList<String> get_watchlist()
	{
		return temp;
	}

	public boolean add_to_watchlist(String movie)
	{   
		if(movie.equals("null"))
		throw new NullPointerException();
		temp.insert(movie);
		return true;
	}

	public boolean remove_from_watchlist(String movie)
	{
		
		temp.delete(movie);
		if(temp.flag)
		{  
			temp.flag = false;
			return true;
		}

		else
		{  
			temp.flag = false;
			return false;
		}
	}
	

	
	public AVLTree<String> get_history()
	{
		return buffer;
	}

	public boolean add_to_history(String movie)
	{
		buffer.add(movie);
		return true;
	}

	public boolean remove_from_history(String movie)
	{
		if(buffer.remove(movie))
		return true;
		
		return false;
	}


	public List<String> get_favourities()
	{
		return fav;
	}
	
	public boolean add_to_favourities(String movie)
	{
		fav.add(movie);

		return true;
	}

	boolean remove_from_favourites(String movie){
		return fav.remove(movie);
	}

    

}
