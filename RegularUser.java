
import java.util.List;

public class RegularUser {

    private String name;
    private String surnmame;
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

    

}
