package com.example.veterinaryclinicsuperpets.util.validations;

import com.example.veterinaryclinicsuperpets.repository.AdminRepository;
import com.example.veterinaryclinicsuperpets.repository.OwnerRepository;
import com.example.veterinaryclinicsuperpets.repository.VeterinarianRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Validator {
  private final VeterinarianRepository vetRepository;
  private final OwnerRepository ownerRepository;
  private final AdminRepository adminRepository;

  private static final String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
  private static final String phoneNumRegex = "^(\\+)?(359|0)8[789]\\d{1}(|-| )\\d{3}(|-| )\\d{3}$";
  private static final String userNameRegex =
      "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
  private static final String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
  private static final Pattern emailPattern = Pattern.compile(emailRegex);
  private static final Pattern phoneNumPattern = Pattern.compile(phoneNumRegex);
  private static final Pattern usernamePattern = Pattern.compile(userNameRegex);
  private static final Pattern passwordPattern = Pattern.compile(passwordRegex);

  public Validator(VeterinarianRepository vetRepository, OwnerRepository ownerRepository, AdminRepository adminRepository) {
    this.vetRepository = vetRepository;
    this.ownerRepository = ownerRepository;
    this.adminRepository = adminRepository;
  }

  public boolean validateEmail(String email) throws ValidationException {
    boolean isDuplicateVet = vetRepository.findByEmail(email)!=null;
    boolean isDuplicateOwner = ownerRepository.findByEmail(email)!=null;
    if(!isDuplicateVet  || !isDuplicateOwner){
      throw new ValidationException("This email is already in use!");
    }
    Matcher emailMatcher = emailPattern.matcher(email);
    return emailMatcher.matches();
  }

  public boolean validatePhoneNum(String phoneNum) throws ValidationException {
    boolean isDuplicateVet = vetRepository.findByPhoneNum(phoneNum)!=null;
    boolean isDuplicateOwner = ownerRepository.findByPhoneNum(phoneNum)!=null;
    if(!isDuplicateVet  || !isDuplicateOwner){
      throw new ValidationException("This phone number is already in use!");
    }
    Matcher phoneNumMatcher = phoneNumPattern.matcher(phoneNum);
    return phoneNumMatcher.matches();
  }

  public boolean validateUsername(String username) throws ValidationException {
    boolean isDuplicateVet = vetRepository.findByUsername(username)!=null;
    boolean isDuplicateOwner = ownerRepository.findByUsername(username).isPresent();
    boolean isDuplicateAdmin = adminRepository.findByUsername(username)!=null;
    if(!isDuplicateVet  || !isDuplicateOwner || !isDuplicateAdmin ){
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
