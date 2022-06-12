
import java.util.List;

public class RegularUser {

    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;

    SLNode<Movie> favourities;

    static class SLNode<E>
    {
        SLNode<E> []links;
        E data;
        SLNode (int m ,E data)
        {   
            links = (SLNode<E>[]) new SLNode[m];
            this.data = data;
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
	

    

}
