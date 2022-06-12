
import java.util.List;

public class RegularUser {



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
