package Thi_md2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final String numberRegex = "^[0]\\d{9}$";

    public static boolean validate(String regex) {
        Pattern pattern = Pattern.compile(numberRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
