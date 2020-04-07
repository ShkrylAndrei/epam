package shkryl.task12.chat;

import shkryl.task12.chat.exception.NoExistingSmsException;
import shkryl.task12.chat.exception.NoFreeSpaceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//Может статическим класс сделать подумать
public class Chat {
    private List<String> chatSmsList = Collections.synchronizedList(new ArrayList<>());
    private List<String> smsBuffer = Collections.synchronizedList(new ArrayList<>());
    private final int capacity = 25;


    public synchronized boolean addSms(String text){

        if (chatSmsList.size() < capacity){
            chatSmsList.add(text);
            return true;
        }else{
            smsBuffer.add(text);
            System.out.println(text+" добавлено в буфер");
            return false;
        }
    }

    public synchronized String readSms(){
        if(chatSmsList.size()>0) {
            String sms = chatSmsList.remove(0);
            if(smsBuffer.size()!=0){
                chatSmsList.add(smsBuffer.remove(0));
            }
            return sms;
        }
        throw new NoExistingSmsException("Нет сообщений для считывания");
    }

    public synchronized void updateSms(){
        if(chatSmsList.size()>0) {
            int randomIndex = new Random().nextInt(chatSmsList.size());
            String text = chatSmsList.get(randomIndex);
            System.out.println("Изменено: "+text);
            chatSmsList.set(randomIndex, text + " modified");
        }

    }


}
