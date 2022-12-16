package pairmatching.repository;

import pairmatching.domain.CourseType;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewMatchResult;
import pairmatching.util.CrewFileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {

    public List<CrewMatchResult> loadMatchedCrew(CourseType course) {
        List<Crew> crews = CrewFileReader.read(course)
                .stream()
                .map(crew -> new Crew(course, crew))
                .collect(Collectors.toList());
        return matchCrew(crews);
    }

    private List<CrewMatchResult> matchCrew(List<Crew> shuffledCrews) {
        int crewsSize = shuffledCrews.size();
        List<CrewMatchResult> crewMatchResults = new ArrayList<>();
        for (int currentCrew = 0; currentCrew < crewsSize - 1; currentCrew += 2) {
            CrewMatchResult newCrewMatch = new CrewMatchResult();
            newCrewMatch.joinCrew(shuffledCrews.get(currentCrew));
            newCrewMatch.joinCrew(shuffledCrews.get(currentCrew + 1));
            crewMatchResults.add(newCrewMatch);
        }

        if (crewsSize % 2 == 1) {
            crewMatchResults.get(crewMatchResults.size() - 1)
                    .joinCrew(shuffledCrews.get(crewsSize - 1));
        }
        return crewMatchResults;
    }
}
