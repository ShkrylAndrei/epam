package shkryl.task9.part3.template_method.security;

public abstract class SecuritySystem {
    public final boolean pass(){
        scan();
        find();

        if(result()){
            return true;
        }
        return false;
    }

    //сканируем данные (отпечаток, глаза, лицо...)
    abstract void scan();
    //ищем данные в базе данных
    abstract void find();
    //если такой человек существует, он прошел систему безопасности
    abstract boolean result();
}
