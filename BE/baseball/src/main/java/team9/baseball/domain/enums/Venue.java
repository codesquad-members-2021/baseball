package team9.baseball.domain.enums;

public enum Venue {
    AWAY,
    HOME;

    public Halves getHalves() {
        if (this == Venue.AWAY) {
            return Halves.TOP;
        }
        return Halves.BOTTOM;
    }
}
