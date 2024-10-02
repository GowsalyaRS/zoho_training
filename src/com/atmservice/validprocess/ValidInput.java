package com.atmservice.validprocess;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.atmservice.login.LoginView;

public class ValidInput 
{
    public static boolean isValidPhoneNumber(long phoneNo) 
    {
        Pattern ptrn = Pattern.compile("[6-9][0-9]{9}");
        Matcher  matcher  = ptrn.matcher(""+phoneNo);
        if(!matcher.matches())
        {
            LoginView.alert("Phone number is Invalid");
            return false;
        }
        return true;
    }
    public static boolean isValidName(String name)
    {
        Pattern ptrn = Pattern.compile("[A-Z]*[a-z]+");
        Matcher  matcher  = ptrn.matcher(name);
        if(!matcher.matches())
        {
            LoginView.alert(" Name is Invalid");
            return false;
        }
        return true;
    }
}
