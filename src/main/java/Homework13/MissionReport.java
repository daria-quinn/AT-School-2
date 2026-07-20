package Homework13;

import java.util.List;
import java.util.Objects;

/**
 * Отчёт о миссии.
 */
public class MissionReport {

    private final String missionName;
    private final List<Alien> capturedAliens;
    private final int squadSize;

    public MissionReport(String missionName, List<Alien> capturedAliens, int squadSize) {
        this.missionName = missionName;
        this.capturedAliens = capturedAliens;
        this.squadSize = squadSize;
    }

    public String getMissionName() {
        return missionName;
    }

    public List<Alien> getCapturedAliens() {
        return capturedAliens;
    }

    public int getSquadSize() {
        return squadSize;
    }

    @Override
    public String toString() {
        return String.format(
                "Миссия: %s%nПоймано пришельцев: %d%nРазмер отряда: %d",
                missionName,
                capturedAliens.size(),
                squadSize);
    }

    /** Для сравнения двух отчётов по содержимому */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MissionReport)) return false;
        MissionReport that = (MissionReport) o;
        return squadSize == that.squadSize &&
                Objects.equals(missionName, that.missionName) &&
                Objects.equals(capturedAliens, that.capturedAliens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(missionName, capturedAliens, squadSize);
    }
}
