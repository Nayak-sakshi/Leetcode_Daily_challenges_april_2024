public class Main {
    public static void main(String[] args) {
        // Your main method code here
        String input = "Hello World";
        int length = lengthOfLastWord(input);
        System.out.println("Length of last word: " + length);
    }

    public static int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            // handle the space
            if (s.charAt(i) == ' ') {
                if (len == 0) {
                    i--;
                } else {
                    break;
                }
            } else {
                len++;
                i--;
            }

        }
        return len;
    }
}
