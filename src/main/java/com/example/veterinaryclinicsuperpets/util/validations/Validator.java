package com.example.veterinaryclinicsuperpets.util.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

  private static final String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
  private static final String phoneNumRegex = "^(\\+)?(359|0)8[789]\\d{1}(|-| )\\d{3}(|-| )\\d{3}$";
  private static final String userNameRegex =
      "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
  private static final String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
  private static final Pattern emailPattern = Pattern.compile(emailRegex);
  private static final Pattern phoneNumPattern = Pattern.compile(phoneNumRegex);
  private static final Pattern usernamePattern = Pattern.compile(userNameRegex);
  private static final Pattern passwordPattern = Pattern.compile(passwordRegex);

  public static boolean validateEmail(String email) {
    Matcher emailMatcher = emailPattern.matcher(email);
    return emailMatcher.matches();
  }

  public static boolean validatePhoneNum(String phoneNum) {
    Matcher phoneNumMatcher = phoneNumPattern.matcher(phoneNum);
    return phoneNumMatcher.matches();
  }

  public static boolean validateUsername(String username) {
    Matcher phoneNumMatcher = usernamePattern.matcher(username);
    return phoneNumMatcher.matches();
  }

  public static boolean validatePassword(String password) {
    // Minimum eight characters, at least one letter and one number
    Matcher passwordMatcher = passwordPattern.matcher(password);
    return passwordMatcher.matches();
  }
}
