import java.util.Deque;
import java.util.LinkedList;

public class DequeueTest {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(2);
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
    }
}
