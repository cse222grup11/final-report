import java.util.ArrayList;
import java.util.List;

public class Premium_User extends Regular_User{
    private List<Movie> downloaded_movies;
    private List<Comment> comments;

    public Premium_User(){
        super();
        downloaded_movies = new ArrayList<Movie>();
        comments = new ArrayList<Comment>();
    }

    public Premium_User(String name, String surname, int age, String email, String password){
        this();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public List<Movie> get_downloaded_movies(){
        return downloaded_movies;
    }

    public boolean add_to_downloaded_movies(Movie mov){
        return downloaded_movies.add(mov);
    }

    public boolean remove_from_downloaded_movies(Movie mov){
        return downloaded_movies.remove(mov);
    }

    public List<Comment> get_comments(){
        return comments;
    }

    public boolean add_to_comments(Comment com){
        return comments.add(com);
    }

    public boolean remove_from_comments(Comment com){
        return comments.remove(com);
    }

    public boolean equals(Regular_User usr){
        return usr instanceof Premium_User && super.equals(usr);
    }




}