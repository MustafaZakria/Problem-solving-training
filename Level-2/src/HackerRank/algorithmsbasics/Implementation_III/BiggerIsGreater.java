package HackerRank.algorithmsbasics.Implementation_III;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class Result17 {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        int index1 = -1,
                index2 = -1;
        for(int i = w.length() - 2; i >= 0; i--){
            int minDistance = Integer.MAX_VALUE;
            index1 = i;
            for(int j = w.length() - 1; j > i; j--) {
                if(w.charAt(index1) < w.charAt(j) && w.charAt(j) - w.charAt(index1) < minDistance) {
                    index2 = j;
                    minDistance = w.charAt(index2) - w.charAt(index1);
                }
            }
            if(index2 != -1) {
                break;
            }
        }
        if(index2 == -1) {
            return "no answer";
        }
        String result = "";
        if(index1 > 0) {
            result += w.substring(0, index1);
        }
        result += w.charAt(index2);
        if(index2 != (w.length() - 1)){
            StringBuilder reversedString = new StringBuilder();
            reversedString.append(w.substring(index2 + 1));
            result += reversedString.reverse();
        }
        result += w.charAt(index1);
        if(index2 - index1 > 0){
            StringBuilder reversedString = new StringBuilder();
            reversedString.append(w, index1 + 1, index2);
            result += reversedString.reverse();
        }
        return result;
    }

}

public class BiggerIsGreater {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result17.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
