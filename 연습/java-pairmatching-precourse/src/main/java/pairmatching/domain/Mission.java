package pairmatching.domain;

import java.util.Objects;

public class Mission {

    private final MissionType type;
    private final CourseType course;
    private final LevelType level;

    public Mission(MissionType type, CourseType course, LevelType level) {
        this.type = type;
        this.course = course;
        this.level = level;
    }

    public CourseType loadCourse() {
        return this.course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mission)) return false;
        Mission mission = (Mission) o;
        return type == mission.type && course == mission.course && level == mission.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, course, level);
    }
}
