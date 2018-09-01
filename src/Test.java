public class Test extends Thread {
    public void run() {
        System.out.println("Hack");
    }

    public void run(String s) {
        System.out.println("Build");
    }

    public static void main(String[] args) {
        int arr[] = new int [2];
        System.out.print(arr);
        new Test().start();
    }
}