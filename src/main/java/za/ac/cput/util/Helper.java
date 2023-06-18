package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }

    public static String generateID(){
        return UUID.randomUUID().toString();
    }

    public static boolean isListEmpty(ArrayList list){

        if(list.isEmpty()){
            return true;
        }

        return false;
    }

    public static boolean isValidEmail(String email){
        EmailValidator ev=EmailValidator.getInstance();
        return ev.isValid(email);


    }

    public static boolean isStringNullOrEmpty(String value){

        if(value.isEmpty() || value.equals("")){
            return true;
        }
        return false;
    }

    public static boolean isListNullOrEmpty(List list){

        if(list.isEmpty()){
            return true;
        }
        return false;
    }

}