import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/** A Movie Class for representing Movie.
 * Comments class has to be implemented!!
 * Essential setters and getters methods have been implemented!
 * Set Structure used!
 *  @author Alperen and Kaan
*/

public class Movie implements Serializable{
  private String show_id;
  private String genre;
  private String director;
  private String cast;
  private String country;
  private String description;

  private int release_date;
  private int age_limit;
  private int duration;

  private float imdb_score;
  private float rating;

  private Set<Comment> comments = new HashSet<Comment>();

  public Movie(){

  }

  public Movie(String show_id,String genre,String director,String cast,
    String country,String description,int release_date,
    int age_limit,int duration,float imdb_score,float rating){

    this.show_id=show_id;
    this.genre=genre;
    this.director=director;
    this.cast=cast;
    this.country=country;
    this.description=description;
    this.release_date=release_date;
    this.age_limit=age_limit;
    this.duration=duration;
    this.imdb_score=imdb_score;
    this.rating=rating;

  }

  public boolean add_to_comments(Comment com){
    return comments.add(com);
  }

  public boolean remove_from_comments(Comment com){
    return comments.remove(com);
  }
  
  public boolean equals(Movie m){
    if(get_show_id() == m.get_show_id() &&
      get_release_date() == m.get_release_date() &&
      get_genre() == m.get_genre() &&
      get_imdb_score() == m.get_imdb_score() &&
      get_rating() == m.get_rating() &&
      get_age_limit() == m.get_age_limit() &&
      get_duration() == m.get_duration() &&
      get_director() == m.get_director() &&
      get_cast() == m.get_cast() &&
      get_country() == m.get_country() &&
      get_description() == m.get_description() &&
      get_comments().equals(m.get_show_id()) )
      return true;
    
      return false;
  }
  public void set_show_id(String id)
  {
    show_id = id;
  }

  public float get_imdb_score()
  {
    return imdb_score;
  }
  public Set<Comment> get_comments()
  {
    return comments;
  }
  public String get_show_id()
  {
    return show_id;
  }

  public int get_release_date()
  {
    return release_date;
  }
  public void set_release_date(int dt)
  {
    release_date = dt;
  }
  public void set_genre(String gn)
  {
    genre = gn;
  }
  public String get_genre()
  {
    return genre;
  }
  public float get_rating()
  {
    return rating;
  }
  public void set_rating(float rt)
  {
    rating = rt;
  }
  public int get_age_limit()
  {
    return age_limit;
  }
  public void set_age_limit(int ag)
  {
    age_limit = ag;
  }
  
  public int get_duration()
  {
    return duration;
  }
  public void set_duration(int dr)
  {
    duration = dr;
  }
  public String get_director()
  {
    return director;
  }
  public void set_director(String drc)
  {
    director = drc;
  }
  public String get_cast()
  {
    return cast;
  }
  public void set_cast(String cs)
  {
    cast = cs;
  }
  public void set_country(String ct)
  {
    country = ct;
  }
  public String get_country()
  {
    return country;
  }

  public String get_description()
  {
    return description;
  }
  public void set_description(String ss)
  {
    description = ss;
  }

  public float get_IMDB_score()
  {
    return imdb_score;
  }
  public void set_IMDB_score(float sc)
  {
    imdb_score = sc;
  }
}
