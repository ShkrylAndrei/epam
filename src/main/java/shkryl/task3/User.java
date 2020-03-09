package shkryl.task3;

public class User {
    private String fio;
    private Role role;

    public User(String fio, Role role) {
        this.fio = fio;
        this.role = role;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void greeting(){
        System.out.println("Приветствуем ФИО с ролью " + role);
    }
}

