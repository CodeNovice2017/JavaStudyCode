package JavaSE.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @project_name: JavaStudyCode
 * @description:
 * @creat_user: CodeChase
 * @creat_date: 2022/9/28
 **/
public class PatternMatcherStudy {

    private final static String DIVISION_OPERATIONS = "([\\/]{1})";

    private final static String MUTI_OPERATIONS = "([\\*]{1})";

    public static void func(){
        Pattern pattern = Pattern.compile("(\\{\\d+\\})" +DIVISION_OPERATIONS+"(\\{\\d+\\})"+ MUTI_OPERATIONS +"(\\d+)");
        String formula = "{0} / {1} *10000";
        formula = formula.replaceAll("\\s", "");
        if(pattern.matcher(formula).matches()){
            Matcher matcher = pattern.matcher(formula);
            System.out.println(matcher.groupCount());
            if(matcher.find()){
                System.out.println(matcher.group(0));
                System.out.println(matcher.group(1));
                System.out.println(matcher.group(2));
                System.out.println(matcher.group(3));
                System.out.println(matcher.group(4));
                System.out.println(matcher.group(5));
            }else{
                return;
            }
        }
    }
}
