
package model;


public class User {
    private String student_id;
    private String password;
    private String full_name;

    public User() {
        this("", "", "");
    }

    
    public User(String student_id, String password, String full_name) {
        this.student_id = student_id;
        this.password = password;
        this.full_name = full_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    
    
    
}
