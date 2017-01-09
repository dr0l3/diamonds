import java.util.Arrays;

/**
 * Created by runed on 1/9/2017.
 */
public class Diamonds {
    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWYZ";
    private static String newline = System.lineSeparator();
    private static char fill = ' ';

    public static void main(String[] args) {
        String input = "C";
        String output = diamond(input);
        System.out.println(output);
    }

    private static String diamond(String inputChar){
        if(!alphabet.contains(inputChar.toUpperCase())) {
            return "(╯°□°）╯︵ ┻━┻";
        }
        return diverge("", alphabet.indexOf(inputChar.toUpperCase()), 0);
    }

    /**
     * The upper half of the diamond
     */
    private static String diverge(String acc_string, int max, int acc){
        if(acc == max){
            return converge(acc_string, max, acc);
        } else if(acc == 0){
            String temp = acc_string + spaceString(max) + alphabet.charAt(acc) + newline;
            return diverge(temp, max, acc + 1);
        } else {
            String temp = acc_string + spaceString(max-acc) + alphabet.charAt(acc) + spaceString(acc) + spaceString(acc-1) + alphabet.charAt(acc)+ newline;
            return diverge(temp, max, acc+ 1);
        }
    }

    /**
     * The lower half of the diamond
     */
    private static String converge(String acc_string, int max, int acc){
        if(acc == 0){
            return acc_string + spaceString(max) + alphabet.charAt(acc) + newline;
        } else {
            String temp = acc_string + spaceString(max-acc) + alphabet.charAt(acc) + spaceString(acc) + spaceString(acc-1) + alphabet.charAt(acc)+ newline;
            return converge(temp, max, acc-1);
        }
    }

    private static String spaceString(int n){
        char[] spaces = new char[n];
        Arrays.fill(spaces, fill);
        return new String(spaces);
    }
}
