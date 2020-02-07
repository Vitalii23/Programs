package TaskThree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zero {

    public void run(String text) {
        final String subst = "$11$2";
        Pattern p = Pattern.compile("^(.+)0([^0]*)$");
        Matcher m = p.matcher(text);
        String result = m.replaceAll(subst);
        System.out.println("Original number: " + text);
        System.out.println("Substitution result: " + result);
    }
}
