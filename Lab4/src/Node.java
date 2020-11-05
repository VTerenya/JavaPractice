public class Node<T extends Comparable<T>> {
    public T value;
    public Node<T> left;
    public Node<T> right;

    Node(T value){
        this.value = value;
        right = null;
        left = null;
    }
    Node(Node<T> node){
        right = node.right;
        left = node.left;
        value = node.value;
    }
}
