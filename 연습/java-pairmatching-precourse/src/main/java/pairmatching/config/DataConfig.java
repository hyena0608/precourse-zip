package pairmatching.config;

import pairmatching.domain.Mission;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.domain.CourseType.BACKEND;
import static pairmatching.domain.CourseType.FRONTEND;
import static pairmatching.domain.LevelType.*;
import static pairmatching.domain.MissionType.*;

public class DataConfig {

    public static List<Mission> missionDummy() {
        List<Mission> missions = new ArrayList<>();
        missions.add(new Mission(CAR, BACKEND, LEVEL1));
        missions.add(new Mission(LOTTO, BACKEND, LEVEL1));
        missions.add(new Mission(BASEBALL, BACKEND, LEVEL1));
        missions.add(new Mission(BASKET, BACKEND, LEVEL2));
        missions.add(new Mission(PURCHASE, BACKEND, LEVEL2));
        missions.add(new Mission(SUBWAY, BACKEND, LEVEL2));
        missions.add(new Mission(PERFORMANCE, BACKEND, LEVEL4));
        missions.add(new Mission(DEPLOY, BACKEND, LEVEL4));
        missions.add(new Mission(CAR, FRONTEND, LEVEL1));
        missions.add(new Mission(LOTTO, FRONTEND, LEVEL1));
        missions.add(new Mission(BASEBALL, FRONTEND, LEVEL1));
        missions.add(new Mission(BASKET, FRONTEND, LEVEL2));
        missions.add(new Mission(PURCHASE, FRONTEND, LEVEL2));
        missions.add(new Mission(SUBWAY, FRONTEND, LEVEL2));
        missions.add(new Mission(PERFORMANCE, FRONTEND, LEVEL4));
        missions.add(new Mission(DEPLOY, FRONTEND, LEVEL4));
        return missions;
    }
}
