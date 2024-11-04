package bai_tap.Validate_phonenumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String PHONE_REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
    public PhoneNumber() {
        pattern = Pattern.compile(PHONE_REGEX);
    }
    public boolean validate(String phoneNumber) {
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
