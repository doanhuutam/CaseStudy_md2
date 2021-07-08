package CaseStudy_md2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenderNum {
private static final String gender="^[Nn][Aa][Mm]+|[Nn][Uu]$";
private static final String status="^[Tt][Rr][Uu][Ee]+|[Ff][Aa][Ll][Ss][Ee]$";

    public GenderNum() {
    }
    public static boolean validate(String regex){
        Pattern pattern=Pattern.compile(gender);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean valida(String rex){
        Pattern pattern=Pattern.compile(status);
        Matcher matcher=pattern.matcher(rex);
        return matcher.matches();
    }

}
