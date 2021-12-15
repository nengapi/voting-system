package model;

public class Candidate {
    private String studentId;
    private String name;
    private String policy;
    private long createdAt;

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }
    
    public Candidate() {
        this("", "", "", 0);
    }
    
    public Candidate(String student_id, String name, String policy, long create_at) {
        this.studentId = student_id;
        this.name = name;
        this.policy = policy;
        this.createdAt = create_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Candidate{" + "studentId=" + studentId + ", name=" + name + ", policy=" + policy + '}';
    }
    
    
}
