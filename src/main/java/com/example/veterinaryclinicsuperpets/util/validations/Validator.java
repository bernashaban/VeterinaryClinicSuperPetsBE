package com.example.veterinaryclinicsuperpets.util.validations;

import com.example.veterinaryclinicsuperpets.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Validator {
  private final UserRepository repository;

  private static final String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
  private static final String phoneNumRegex = "^(\\+)?(359|0)8[789]\\d{1}(|-| )\\d{3}(|-| )\\d{3}$";
  private static final String userNameRegex =
      "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
  private static final String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
  private static final Pattern emailPattern = Pattern.compile(emailRegex);
  private static final Pattern phoneNumPattern = Pattern.compile(phoneNumRegex);
  private static final Pattern usernamePattern = Pattern.compile(userNameRegex);
  private static final Pattern passwordPattern = Pattern.compile(passwordRegex);

  public Validator(UserRepository repository) {
    this.repository = repository;
  }

  public boolean validateEmail(String email) throws ValidationException {
    boolean isDuplicate = repository.findByEmail(email).isPresent();
    if (isDuplicate) {
      throw new ValidationException("This email is already in use!");
    }
    Matcher emailMatcher = emailPattern.matcher(email);
    return emailMatcher.matches();
  }

  public boolean validatePhoneNum(String phoneNum) throws ValidationException {
    boolean isDuplicate = repository.findByPhoneNum(phoneNum).isPresent();
    if (isDuplicate) {
      throw new ValidationException("This phone number is already in use!");
    }
    Matcher phoneNumMatcher = phoneNumPattern.matcher(phoneNum);
    return phoneNumMatcher.matches();
  }

  public boolean validateUsername(String username) throws ValidationException {
    boolean isDuplicate = repository.findByUsername(username).isPresent();
    if (isDuplicate) {
      throw new ValidationException("This username is already in use!");
    }
    Matcher phoneNumMatcher = usernamePattern.matcher(username);
    return phoneNumMatcher.matches();
  }

  public boolean validatePassword(String password) {
    // Minimum eight characters, at least one letter and one number
    Matcher passwordMatcher = passwordPattern.matcher(password);
    return passwordMatcher.matches();
  }
}
