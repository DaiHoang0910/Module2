package bai_tap.Validate_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String CLASSNAME_REGEX = "^[ACP]\\d{4}[GHIK]$";

    public ClassName() {
        pattern = Pattern.compile(CLASSNAME_REGEX);
    }

    public boolean validate(String className) {
        matcher = pattern.matcher(className);
        return matcher.matches();
    }
}
