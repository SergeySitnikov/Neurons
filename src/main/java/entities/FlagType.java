package entities;

public enum FlagType {
    OTH(0),
    REJ(1),
    RSTO(2),
    RSTOS0(3),
    RSTR(4),
    S0(5),
    S1(6),
    S2(7),
    S3(8),
    SF(9),
    SH(10);
    private final double value;

    FlagType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
