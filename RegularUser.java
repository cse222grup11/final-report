
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

    private SLNode<E>[] search (E target) {
        SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
        SLNode<E> current = head;
        for (int i = current.links.length‐1; i >= 0; i‐‐) {
        while (current.links[i] != null
        && current.links[i].data.compareTo(target) < 0) {
        current = current.links[i];
        }
        pred[i] = current;
        }
        return pred;
       }


}
