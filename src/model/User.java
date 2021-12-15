package model;

public class User {

    private int id;
    private String studentId;
    private String password;
    private String fullName;

    public User() {
        this(0, "", "", "");
    }

    public User(int id, String studentId, String password, String fullName) {
        this.id = id;
        this.studentId = studentId;
        this.password = password;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
