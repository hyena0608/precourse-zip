package pairmatching.util;

import pairmatching.domain.CourseType;
import pairmatching.domain.LevelType;
import pairmatching.domain.Mission;
import pairmatching.domain.MissionType;

import static pairmatching.global.GlobalExceptionMessage.MISSION_PARSER_EXCEPTION;

public class MissionParser {

    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_TYPE_INDEX = 2;

    public static Mission from(String readMission) {
        String[] splitMission = readMission.split(", ");
        validateSplitSize(splitMission);
        CourseType course = CourseType.from(splitMission[COURSE_INDEX]);
        LevelType level = LevelType.from(splitMission[LEVEL_INDEX]);
        MissionType missionType = MissionType.from(splitMission[MISSION_TYPE_INDEX]);
        return new Mission(missionType, course, level);
    }

    private static void validateSplitSize(String[] splitMission) {
        if (splitMission.length != 3) {
            throw new IllegalArgumentException(MISSION_PARSER_EXCEPTION.getMessage());
        }
    }
}
