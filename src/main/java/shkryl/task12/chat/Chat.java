package shkryl.task12.chat;

import shkryl.task12.chat.exception.NoExistingSmsException;
import shkryl.task12.chat.exception.NoFreeSpaceException;

import java.util.ArrayList;
import java.util.List;

//Может статическим класс сделать подумать
public class Chat {
    private List<String> sms = new ArrayList<>();
    private static int currentSms = 0;
    private static final int barrierForSms = 25;


    public Boolean addOneSms(String text){

        if (sms.size()<=barrierForSms){
            sms.add(text);
            currentSms++;

            return true;
        }else{

            throw new NoFreeSpaceException("Хранилище смс переполнено, нельзя добавить новое");
        }
    }

    public String readOneSms(){
        if (currentSms==0){
            throw new NoExistingSmsException("В хранилище нет ни одного SMS, операция чтения невозможна");
        }else{
            String returnSms = sms.get(currentSms);
            sms.remove(currentSms);
            currentSms--;
            return  returnSms;
        }
    }

    public Boolean updateOneSms(){
        //Пока не знаю
        //запоминаем индекс меняем и сохраняем, но другие потоки могут уже убить это сообщение, как быть???
        return true;
    }


}
