public class Lab4 {
    public static void main(String[] args) {
        Tree<Integer> t = new Tree<Integer>();
        t.add(5);
        t.add(10);
        //t.add(11);
        t.add(8);
        t.add(7);
        t.add(9);
        t.add(23);
        t.add(30);
//        t.add(19);
//        t.add(22);
//        t.add(15);
//        t.add(17);
//        t.add(16);
//        t.add(18);
//        t.add(10);
//        t.add(5);
//        t.add(4);
//        t.add(7);
//        t.add(8);
        t.printRlr();
        //t.printLRr();
        if(t.delete(10)){
            System.out.print("Element was deleted.");
        }else{
            System.out.print("Not find this element.");
        }
        System.out.println();
        //t.printLRr();
        t.printRlr();
        //t.printLrR();
    }
}
