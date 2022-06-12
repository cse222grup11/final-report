import java.util.*;
//import java.io.File;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Regular_User {
	String name;
	String surname;
	int age;
	static String email;
	String password;
	Queue<String> que = new LinkedList<String>();
	Stack<String> stack = new Stack<String>();
	List<String> favorites = new LinkedList<String>();
	
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
	
	 Queue<String> get_watchlist(){
		return que;
	}
	//constructorda çağırılacak
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
			que.add(line);

		}
	}
	 boolean add_to_watchlist(String movie) throws IOException{
		//this.update_watch_list(movie);
		return que.add(movie);
	}
	
	//bu veri yapılarını kim seçmiş abi. değiştirebiliyosak değşitirelim. que ve stackten ortalardali elemanları silmek mantıksız
	boolean remove_from_watchlist(String movie){
		Queue<String> q2 = new LinkedList<String>();
		int firstSize = que.size();
		for(int i=0; i<que.size(); ++i){
			String s = que.	poll();
			if(!s.equals(movie)) q2.offer(s);
		}
		for(int i=0; i<q2.size(); ++i)
			que.offer(q2.poll());
		
		if(firstSize-que.size()==1) return true;
		return false;
	}

	//favourites
	List<String> get_favourites(){
		return favorites;
	}
	//constructorda çağırılacak
	private  void fill_favourites_list()throws FileNotFoundException{
		FileInputStream fis=new FileInputStream("UsersDB.txt");       
		Scanner sc=new Scanner(fis);
		String line="";

		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if(line.equals(this.email))
				break;			
		}  
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if(line.equals("favoritiesBegin"))
				break;			
		}
		while(sc.hasNextLine() && !line.equals("##")) {
			line = sc.nextLine();
			if(line.equals("favoritiesEnd"))
				break;			
			favorites.add(line);
		}
	}
	boolean add_to_favourites(String movie) {
		return favorites.add(movie);
	}
	boolean remove_from_favourites(String movie){
		return favorites.remove(movie);
	}
	//history
	Stack<String> get_history(){
		return stack;
	}
	//constructorda çağırılacak
	private  void fill_history_stack()throws FileNotFoundException{
		FileInputStream fis=new FileInputStream("UsersDB.txt");       
		Scanner sc=new Scanner(fis);
		String line="";

		while(sc.hasNextLine()) {
			line = sc.nextLine();	
			if(line.equals(this.email))
				break;			
		}  
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if(line.equals("historyBegin"))
				break;			
		}
		while(sc.hasNextLine() && !line.equals("##")) {
			line = sc.nextLine();
			if(line.equals("historyEnd"))
				break;			
			stack.add(line);
		}
	}
	boolean add_to_history(String movie) {
		if(stack.push(movie) == null) return false;
		return true;
	}

	boolean remove_from_history(String movie){
		Stack<String> s2 = new Stack<String>();
		int firstSize = stack.size();
		for(int i=0; i<stack.size(); ++i){
			String s = stack.pop();
			if(!s.equals(movie)) s2.push(s);
		}
		for(int i=0; i<s2.size(); ++i)
			stack.push(s2.pop());
		
		if(firstSize-stack.size()==1) return true;
		return false;
	}

	/*
		kullanıcı oturumu kapatırken bu fonksiyon çağırılacak ve UserBD dosyasını güncelleyecek
		Henüz olması gerektiği gibi çalışmıyor.
		şu şeklide çalışması lazım:
		user File'ı komple bir buffere'a koyacak. koyarken de şuanki kullanıcının bölümüne geldiğinde 
		bufferı kullanıcının şaunki güncel bilgileriyle (güncel watchlist, favorites, history ile) dolduracağız. Dosyadaki eski bilgilerle değil.
		daha sonra buffer geri kalan diğer kullanıcıların bilgilerini aynen dosyadan alacak. en son buffer'dakileri dosyaya tekrar yazacaz. 

		while(!endoffile)
			dosyayı satır satır oku
			if(satır==this.email){
				buffer.add(satır)
				break;
			}
		while(!satır!="##")
			buffer'a profil bilgilerini koy doğru sırayla (isim \n soyisim \n şifre \n)
			buffer'a watchlisti koy satır satıır (watchlistbegin \n watchlist elemanları \n watchlistend)
			buffer'a favorities'i koy satır satıır (favoritiesBegin \n favorities elemanları \n favoritiesEnd)
			buffer'a history'i koy satır satıır (historyBegin \n history elemanları \n historyEnd)
		buffer.add("##")
		while(!endoffile)
			dosyadan alıp buffer'a koymaya devam et


	*/
	public   void update_UserDB() throws IOException{
		File fis=new File("UsersDB.txt");       
		RandomAccessFile raf = new RandomAccessFile(fis,"rw");
		List<String> buffer = new ArrayList<String>();	// define buffer as  arraylist to hold file's data

		//String weiteThis = movie+"\n";
		String line = "" ;
		
		
		
		//raf.writeBytes(weiteThis);
		//System.out.println(line);
		
		while(!line.equals(this.email)){
			try{
				line = raf.readLine();		
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			/*insert what you read until now to the buffer*/
			 buffer.add(line);
			// System.out.println(buffer);
			 

		}
		
		// up to here the buffer should contain every thing before the id (email)
		
		while(!line.equals("watchlistBegin")) {
			line = raf.readLine();	
			buffer.add(line);
		}
		//To see what que watchlist contains and add them to the old ones into a file
		for(String elem:que){
		//	System.out.println(elem);
			buffer.add(elem);
		}

		RandomAccessFile prevLine = new RandomAccessFile(fis,"rw");
		boolean firstTime = true;
		boolean  add_movie;

		while(!line.equals(null) && !line.equals("watchlistBegin")) {
			
			buffer.add(line);// Add what you read to the buffer
			if(!line.equals("watchlistEnd")) {
				
				prevLine = raf;

				}
			
			else break;
			line = raf.readLine();			
		}
		
		//////////////////////////////////
		// up to here the buffer should contains every thing before the favorites
		
		while(!line.equals("favoritiesBegin")) {
			line = raf.readLine();	
			buffer.add(line);
		}
		//To see what List favorites contains and add them to the old ones into a file
		for(String val : favorites){ 
//			System.out.print(val + " "); 
			buffer.add(val);
			}

		while(!line.equals(null) && !line.equals("favoritiesBegin")) {
			
			buffer.add(line);// Add what you read to the buffer
			if(!line.equals("favoritiesEnd")) {
				
				prevLine = raf;

				}
			
			else break;
			line = raf.readLine();			
		}
		
///////////////////////////////////////////////////
		//////////////////////////////////
		// up to here the buffer should contain every thing before the history
		
		while(!line.equals("historyBegin")) {
			line = raf.readLine();	
			buffer.add(line);
		}
		//To see what List history contains and add them to the old ones into a file
		for(String value : stack){ 
		//	System.out.print(value + " "); 
			buffer.add(value);
			}


		while(!line.equals(null) && !line.equals("historyBegin")) {
			
			buffer.add(line);// Add what you read to the buffer
			if(!line.equals("historyEnd")) {
				
				prevLine = raf;

				}
			
			else break;
			line = raf.readLine();			
		}	
/////////////////////////////////////////////////////////////////		
		
		//this while to continue till end of file
		
		while (line != null) {
			line = raf.readLine();
			//System.out.println(line);
			
			buffer.add(line);
			
		}
		
		

		
		// Write from buffer into file 
		
		Charset charset = Charset.forName("utf-8");
		
		try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("UsersDB.txt"), charset)){
			Iterator<String> it = buffer.iterator();
			while(it.hasNext()) {
				String string = it.next();
		
				if(string == null)
					break;
				bw.append(string);
				bw.newLine();
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//System.out.println("OK!!");
		
		
	}
	

}