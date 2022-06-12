import java.util.Random;

public class SkipList<T extends Comparable<? super T>> implements SkippableList<T> {

    private final SkipNode<T> head = new SkipNode<>(null);
    private final Random rand = new Random();
    protected boolean flag = false;
  
    @Override
    public void insert(T data) {
      SkipNode<T> skipNode = new SkipNode<>(data);
      for (int i = 0; i < LEVELS; i++) {
        if (rand.nextInt((int) Math.pow(2, i)) == 0) {
          //insert with prob = 1/(2^i)
          insert(skipNode, i);
        }
      }
    }
  
    @Override
    public boolean delete(T target) {
      System.out.println("Deleting " + target);
      SkipNode<T> victim = search(target, true);
      if (victim == null) return false;
      victim.data = null;
  
      for (int i = 0; i < LEVELS; i++) {
        head.refreshAfterDelete(i);
      }
  
      System.out.println("deleted...");
      return true;
    }
  
    @Override
    public SkipNode<T> search(T data) {
      return search(data, true);
    }
  
    @Override
    public void print() {
      for (int i = LEVELS-1; i >= 0 ; i--) {
        head.print(i);
      }
      System.out.println();
    }
  
    private void insert(SkipNode<T> SkipNode, int level) {
      head.insert(SkipNode, level);
    }
  
    private SkipNode<T> search(T data, boolean print) {
      SkipNode<T> result = null;
      for (int i = LEVELS-1; i >= 0; i--) {
        if ((result = head.search(data, i, print)) != null) {
          if (print) {
            System.out.println("Found " + data.toString() + " at level " + i + ", so stopped" );
            System.out.println();
            flag = true;
          }
          break;
        }
      }
  
      return result;
    }
  
    public static void main(String[] args) {
      SkipList<Integer> sl = new SkipList<>();
      int[] data = {4,2,7,0,9,1,3,7,3,4,5,6,0,2,8};
      for (int i : data) {
        sl.insert(i);
      }
  
      sl.print();
      sl.search(4);
  
      sl.delete(4);
  
      System.out.println("Inserting 10");
      sl.insert(10);
      sl.print();
      sl.search(10);
    }
  
  }