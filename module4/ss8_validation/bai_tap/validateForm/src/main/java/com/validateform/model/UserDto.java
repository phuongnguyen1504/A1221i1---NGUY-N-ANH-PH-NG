package com.validateform.model;



import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {

//    private int id;
    @NotBlank(message = "Khong duoc de trong")
    @Size(min = 5, max = 45,message = "Do dai ki tu phai tu 5 den 45 ki tu")
    private String firstName;
    @NotBlank(message = "Khong duoc de trong")
    @Size(min = 5, max = 45,message = "Do dai ki tu phai tu 5 den 45 ki tu")
    private String lastName;
    @Pattern(regexp = "^0\\d{9}$",message = "Phai nhap dung 9 so bat dau tu 0")
    private String phone;

    private int age;

    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Mail khong dung dinh dang nhap lai")
    private String mail;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public UserDto() {

    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getAge() < 18) {
            errors.rejectValue("age", "age.forbidden", "Tuoi lon hon 18");
        }

    }
}
