import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(duplicates("Hello world!"));
        System.out.println(duplicates("foobar"));
        System.out.println(duplicates("helicopter"));
        System.out.println(duplicates("birthday"));
        System.out.println(" - ");

        System.out.println(histogram(new int[] {1, 3, 4}, "#"));
        System.out.println(histogram(new int[] {1, 10}, "+"));
        System.out.println(histogram(new int[] {6, 2, 15, 3}, "="));
        System.out.println(" - ");

        System.out.println(primorial(1));
        System.out.println(primorial(2));
        System.out.println(primorial(8));
        System.out.println(" - ");

        System.out.println(capSpace("helloWorld"));
        System.out.println(capSpace("iLoveMyTeapot"));
        System.out.println(capSpace("stayIndoors"));
        System.out.println(" - ");

        System.out.println(isTriplet(3, 4, 5));
        System.out.println(isTriplet(13, 5, 12));
        System.out.println(isTriplet(1, 2, 3));
        System.out.println(" - ");

        System.out.println(littleBig(4));
        System.out.println(littleBig(5));
        System.out.println(littleBig(28));
    }
    public static String duplicates(String str) {
        StringBuilder letters = new StringBuilder("");
        StringBuilder result = new StringBuilder("");
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!letters.toString().contains(String.valueOf(str.charAt(i)))) {
                int counter = 1;
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(i) == str.charAt(j)) {
                        counter++;
                    }
                }
                if (counter > 1) {
                    letters.append(str.charAt(i));
                    count++;
                    if (letters.length() > 1) {
                        result.append(", ");
                    }
                    result.append("\"");
                    result.append(str.charAt(i));
                    result.append("\"");
                    result.append(" = ");
                    result.append(counter);
                }
            }
        }
        if (count <= 1) {
            result = new StringBuilder("");
            result.append(count);
        }
        return result.toString();
    }
    public static String histogram(int[] array, String s) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                result.append(s);
            }
            if (i != array.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
    public static int primorial(int n) {
        int[] array = new int[n];
        array[0] = 2;
        int result = array[0];
        for (int i = 1; i < n; i++) {
            array[i] = array[i - 1] + 1;
                for (int j = 0; j < i; j++) {
                    if (array[i] % array[j] == 0) {
                        array[i]++;
                        j = -1;
                    }
                }
            result *= array[i];
        }
        return result;
    }
//    public static String capSpace(String str) {
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) < 97) {
//                result.append(" ");
//            }
//            result.append(str.charAt(i));
//        }
//        return result.toString().toLowerCase();
//    }
    /**OR**/
    public static String capSpace(String str) {
        StringBuilder result = new StringBuilder();
        String uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < str.length(); i++) {
            if (uppers.contains(String.valueOf(str.charAt(i)))) {
                result.append(" ");
            }
            result.append(str.charAt(i));
        }
        return result.toString().toLowerCase();
    }
    public static boolean isTriplet(int a, int b, int c) {
        int[] array = {a, b, c};
        Arrays.sort(array);
        return array[0] * array[0] + array[1] * array[1] == array[2] * array[2];
    }
    public static int littleBig(int n) {
        int[] array = new int[n];
        array[0] = 5;
        array[1] = 100;
        for (int i = 2; i < n; i++) {
            if (i % 2 == 0) {
                array[i] = array[i - 2] + 1;
            }
            else array[i] = array[i - 2] * 2;
        }
        return array[n - 1];
    }
}