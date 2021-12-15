package model;

public class Candidate {
    private String student_id, name, create_at;
    
    public Candidate() {
        this("", "");
    }
    
    public Candidate(String student_id, String name) {
        this.student_id = student_id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    
}
