package pairmatching.util;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.CourseType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.global.GlobalExceptionMessage.CREW_RILE_READER_EXCEPTION;

public class CrewFileReader {

    private static final Path BACKEND_PATH = Paths.get("src/main/resources/backend-crew.md");
    private static final Path FRONTEND_PATH = Paths.get("src/main/resources/frontend-crew.md");

    public static List<String> read(CourseType course) {
        List<String> crewNames = new ArrayList<>();
        try {
            if (course.isBackEnd()) {
                crewNames = Files.readAllLines(BACKEND_PATH);
            }
            if (course.isFrontEnd()) {
                crewNames = Files.readAllLines(FRONTEND_PATH);
            }
            return Randoms.shuffle(crewNames);
        } catch (IOException e) {
            throw new IllegalArgumentException(CREW_RILE_READER_EXCEPTION.getMessage());
        }
    }
}
