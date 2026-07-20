package Homework13;

import java.util.Objects;

/**
 * Описание пришельца.
 */
public class Alien {

    private final String name;        // имя пришельца
    private final String planet;      // планета происхождения
    private final int dangerLevel;    // уровень опасности (1‑10)

    public Alien(String name, String planet, int dangerLevel) {
        this.name = name;
        this.planet = planet;
        this.dangerLevel = dangerLevel;
    }

    public String getName() {
        return name;
    }

    public String getPlanet() {
        return planet;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    /** Два пришельца считаются одинаковыми, если совпадают имя и планета */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alien)) return false;
        Alien alien = (Alien) o;
        return Objects.equals(name, alien.name) &&
                Objects.equals(planet, alien.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet);
    }

    @Override
    public String toString() {
        return String.format("Alien{name='%s', planet='%s', dangerLevel=%d}",
                name, planet, dangerLevel);
    }
}
