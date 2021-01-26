package JVM;

public class TestStack {
    private static String test(long a, String b) {
        byte[] bytes = new byte[6 * 1024 * 1024];
        String str = a + b;
        System.gc();
        return str;
    }
}
