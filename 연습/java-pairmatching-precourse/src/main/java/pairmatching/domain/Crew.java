package pairmatching.domain;

public class Crew {

    private final CourseType course;
    private final String name;

    public Crew(CourseType course, String name) {
        this.course = course;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
