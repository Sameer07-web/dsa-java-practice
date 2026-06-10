import java.util.*;

public class EncodeAndDecodeStrings {

    // Encode a list of strings into a single string
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length())
                   .append("#")
                   .append(str);
        }

        return encoded.toString();
    }

    // Decode the encoded string back into a list
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {
            int j = i;

            while (s.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(s.substring(i, j));

            String word = s.substring(j + 1, j + 1 + len);

            result.add(word);

            i = j + 1 + len;
        }

        return result;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings solution = new EncodeAndDecodeStrings();

        List<String> input = Arrays.asList("hello", "world", "java");

        String encoded = solution.encode(input);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = solution.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}