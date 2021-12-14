package model;

public class User {

    private String studentId;
    private String password;
    private String fullName;

    public User() {
        this("", "", "");
    }

    public User(String studentId, String password) {
        this(studentId, password, "");
    }

    public User(String studentId, String password, String fullName) {
        this.studentId = studentId;
        this.password = password;
        this.fullName = fullName;
    }

    public String getStudentId() {
        return studentId;
    }
    
     public int getStudentIdToInt() {
        return Integer.parseInt(studentId);
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
