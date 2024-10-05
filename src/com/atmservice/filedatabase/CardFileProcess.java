package com.atmservice.filedatabase;
import java.util.List;
import com.atmservice.module.Card;
import java.util.Map;

public interface CardFileProcess extends ClearFileProcess,AddFileProcess
{
    List<Card> readCardFile() throws Exception;  
    void writeCardFile(Card card) throws Exception;
    void modifyCardFile(Map<Long,Card> cards) throws Exception;
}
