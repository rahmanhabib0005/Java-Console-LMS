public class Course {
    private String title;
    private String instructor;
    private String content;
    private String grade;

    public Course(String title) {
        this.title = title;
        this.instructor = "";
        this.content = "";
        this.grade = "N/A";
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toJson() {
        return "{\\\"title\\\":\\\"" + title + "\\\", \\\"instructor\\\":\\\"" + instructor +
               "\\\", \\\"content\\\":\\\"" + content + "\\\", \\\"grade\\\":\\\"" + grade + "\\\"}";
    }
}