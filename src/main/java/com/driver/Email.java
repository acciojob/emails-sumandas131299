package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){

        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(oldPassword.equals(password)){
            if(check(newPassword)){
                this.password=newPassword;
                System.out.println("Password changed successfully");

            }else{
                System.out.println("new Password is not appropriate , password remain unchanged");
            }
        }else{
            System.out.println("given current Password is not matching , try again");
        }

    }

    private boolean check(String newPassword) {
        if(newPassword.length()<8) return false;
        boolean lower=false,upper = false,digit=false,special = false;
        int i=0;
        while(i<newPassword.length()){
            if(Character.isLowerCase(newPassword.charAt(i))){
                lower=true;
                i++;
            } else if (Character.isUpperCase(newPassword.charAt(i))) {
                upper=true;
                i++;
            } else if (Character.isDigit(newPassword.charAt(i))) {
                digit=true;
                i++;
            } else if (!Character.isLetterOrDigit(newPassword.charAt(i)) && !Character.isWhitespace(newPassword.charAt(i))) {
                special=true;
                i++;
            }
            else{
                return  false;
            }
        }
        if(lower && upper && digit && special ) return  true;
        else return false;

    }
}
