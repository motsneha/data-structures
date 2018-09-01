class Test2 {
    static int count = 0;

    Test2() {
        count++;
    }
    public static void main(String arr[]) {
        Test2 t1 = new Test2();
        Test2 t2 = new Test2();
        Test2 t3 = new Test2();
        System.out.println("Total " + count + " objects created");
    }
}