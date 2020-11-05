public class Tree<T extends Comparable<T>> {
    private Node<T> head;
    private int size = 0;

    Tree() {
        head = null;
    }

    public void add(T value) {
        size++;
        Node h = head;
        if (h == null) {
            head = new Node(value);
        } else {
            for (; ; ) {
                if (h.value.compareTo(value) >= 0) {
                    if (h.left == null) {
                        h.left = new Node(value);
                        break;
                    }
                    h = h.left;
                } else {
                    if (h.right == null) {
                        h.right = new Node(value);
                        break;
                    }
                    h = h.right;
                }
            }
        }
    }

    public boolean find(T value) {
        boolean flag = false;
        Node<T> h = head;
        while (h != null) {
            if (h.value.compareTo(value) == 0) {
                flag = true;
                return flag;
            } else if (h.value.compareTo(value) > 0) {
                h = h.left;
            } else {
                h = h.right;
            }
        }
        return flag;
    }

    class Both {
        Node<T> q;
        Node<T> p;

        Both(Node<T> a, Node<T> b) {
            q = a;
            p = b;
        }
    }

    private Both findNode(T value, Node<T> p) {
        Node<T> q = head;
        p = null;

        while (q != null) {
            int result = q.value.compareTo(value);

            if (result > 0) {
                p = q;
                q = q.left;
            } else if (result < 0) {
                p = q;
                q = q.right;
            } else {
                break;
            }
        }
        Both both = new Both(q, p);
        return both;
    }

    public boolean delete(T value) {
        Node<T> q = null;
        Node<T> p = null;
        //находим удаляемый узел
        Both both = new Both(q, p);
        both = findNode(value, p);
        q = both.q;
        p = both.p;
        if (q == null) {
            return false;
        }
        size--;
        if (q.right == null) { //1
            if (p == null) {
                head = q.left;
            } else {
                int result = p.value.compareTo(q.value);
                if (result > 0) {
                    p.left = q.left;
                } else if (result < 0) {
                    p.right = q.left;
                }
            }
        } else if (q.right.left == null) { //2
            q.right.left = q.left;
            if (p == null) {
                head = q.right;
            } else {
                int result = p.value.compareTo(q.value);
                if (result > 0) {
                    p.left = q.right;
                } else if (result < 0) {
                    p.right = q.right;
                }
            }
        } else { //3 случай
            Node<T> mostLeftCurrent = q.right.left;
            Node<T> mostLeftParent = q.right;
            while (mostLeftCurrent.left != null) {
                mostLeftParent = mostLeftCurrent;
                mostLeftCurrent = mostLeftCurrent.left;
            }
            mostLeftParent.left = mostLeftCurrent.right;
            mostLeftCurrent.left = q.left;
            mostLeftCurrent.right = q.right;
            if (p == null) {
                head = mostLeftCurrent;
            } else {
                int result = p.value.compareTo(q.value);
                if (result > 0) {
                    p.left = mostLeftCurrent;
                } else if (result < 0) {
                    p.right = mostLeftCurrent;
                }
            }
        }
        return true;
    }

    //root-left-right
    private void Rlr(Node<T> n) {
        System.out.print(n.value.toString() + " ");
        if (n.left != null) Rlr(n.left);
        if (n.right != null) Rlr(n.right);
    }

    void printRlr() {
        Rlr(head);
        System.out.println();
    }

    //left-right-root
    private void lrR(Node<T> n) {
        if (n.left != null) lrR(n.left);
        if (n.right != null) lrR(n.right);
        System.out.print(n.value.toString() + " ");
    }

    void printLrR() {
        lrR(head);
        System.out.println();
    }

    //left-root-right
    private void lRr(Node<T> n) {
        if (n.left != null) lRr(n.left);
        System.out.print(n.value.toString() + " ");
        if (n.right != null) lRr(n.right);
    }

    void printLRr() {
        lRr(head);
        System.out.println();
    }
}
