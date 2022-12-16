package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewMatchResult {

    private final List<Crew> crews = new ArrayList<>();

    public void joinCrew(Crew crew) {
        crews.add(crew);
    }

    @Override
    public String toString() {
        return crews.stream()
                .map(Crew::toString)
                .collect(Collectors.joining(" : "));
    }
}
