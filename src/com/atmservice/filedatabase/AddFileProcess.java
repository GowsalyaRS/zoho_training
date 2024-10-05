package com.atmservice.filedatabase;
import java.io.PrintWriter;
import com.atmservice.login.LoginView;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public interface AddFileProcess 
{
    default void addContent(String heading,String path) throws Exception
    {
        try (PrintWriter file = new PrintWriter(new FileWriter (path,true)))
        {
          file.println(heading);
          file.flush();
        }
        catch(FileNotFoundException e)
        {
           LoginView.alert("File Not Found");
        }
    }
}