package bwina.java_social_server.domain.models.userdetail_attributes;

public enum EmploymentType {
    FULLTIME ("Full Time"),
    PARTTIME ("Part Time"),
    INTERNSHIP ("Internship"),
    APPRENTICESHIP ("Apprenticeship"),
    FREELANCE ("Freelance");

    public final String name;

    EmploymentType(String name) {
        this.name = name;
    }
}
