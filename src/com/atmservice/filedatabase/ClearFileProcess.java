package com.atmservice.filedatabase;
import java.io.IOException;
import java.io.FileWriter;

interface  ClearFileProcess 
{
    default void clearFileContent(String filePath) throws IOException 
    {
       try (FileWriter writer = new FileWriter(filePath)) 
       {
           writer.write(""); 
       }
   }
}
