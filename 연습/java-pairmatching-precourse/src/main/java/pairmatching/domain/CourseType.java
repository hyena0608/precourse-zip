package pairmatching.domain;

import java.util.Arrays;

import static pairmatching.global.GlobalExceptionMessage.COURSE_TYPE_FIND_EXCEPTION;

public enum CourseType {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    CourseType(String name) {
        this.name = name;
    }

    public static CourseType from(String name) {
        return Arrays.stream(CourseType.values())
                .filter(course -> course.name.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(COURSE_TYPE_FIND_EXCEPTION.getMessage()));
    }

    public String getName() {
        return name;
    }

    public boolean isBackEnd() {
        return this == BACKEND;
    }

    public boolean isFrontEnd() {
        return this == FRONTEND;
    }
}
