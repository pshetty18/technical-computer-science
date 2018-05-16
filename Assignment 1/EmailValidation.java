/*
Pratish Shetty: 01709610
Stanley Young-Harry: 
Yubo Li: 01692497
*/

package emailvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class EmailValidation {

    public static void main(String[] args) {
        // TODO code application logic here
        String[] cases = {"bre2z@umassd.edu", "Edu5e@gmail.com", "spa7@UMAsSD.EdU", "Lou_3a@GMaIl.cOm", "samsmithumassd.edu", "lion4it@umassd.edu@gmail.com", "flip25@gmail.com", "c573409@umassd.edu", "f*b#@umassd.edu", "educationint@live.com"};
        for (int i = 0; i < 10; i++){
            if (validateEmailAddress(cases[i])){
                System.out.println("The email address '" + cases[i] + "' is valid");
            }
        }
    }  

    static boolean validateEmailAddress (String emailAddress) {
        //to check if the address is *******@*********
        Pattern pattern = Pattern.compile("@");
        String[] words = pattern.split(emailAddress);
        if (words.length != 2) {
            System.out.println(emailAddress + " is not an email address!");
            return false;
        }
        //to check if the local part start with {a-Z} and has 5-10 character
        String local = getLocalPart(emailAddress);
        pattern = Pattern.compile("[a-zA-Z]{1}[a-zA-Z_0-9]{4,9}");
        Matcher matcher = pattern.matcher(local); 
        if (!matcher.matches()){
            System.out.println("The local part of the email address '" + emailAddress + "' is invalid");
            return false;
        }

        if (isUmassdAccount(emailAddress) || isGmailAccount(emailAddress)){
            return true;
        } else {
            System.out.println("The domain part of the email address '" + emailAddress + "' is invalid");
            return false;
        }
    }

    static String getLocalPart (String emailAddress) {
        Pattern pattern = Pattern.compile("@");
        String[] words = pattern.split(emailAddress);
        return words[0];
    }

    static boolean isUmassdAccount (String emailAddress) {
        Pattern pattern = Pattern.compile("@");
        String[] words = pattern.split(emailAddress);
        String domain = words[1];
        pattern = Pattern.compile("umassd.edu", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(domain); 
        if (matcher.matches()){
            return true;
        } else return false;
    }

    static boolean isGmailAccount (String emailAddress) {
        Pattern pattern = Pattern.compile("@");
        String[] words = pattern.split(emailAddress);
        String domain = words[1];
        pattern = Pattern.compile("gmail.com", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(domain); 
        if (matcher.matches()){
            return true;
        } else return false;
    }
}

    
    

