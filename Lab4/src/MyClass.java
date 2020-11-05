class MyClass implements Comparable<MyClass> {
    private int value;
    MyClass(int v) { value = v; }
    @Override
    public String toString(){
        return Integer.toString(value);
    }
    @Override
    public int compareTo(MyClass my) {
        return Integer.compare(value,my.value);
    }
}
