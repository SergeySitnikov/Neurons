package entities;

public enum ProtocolType {
    TCP(0),
    ICMP(1),
    UDP(2);
    private final double value;
    ProtocolType(double i) {
        this.value = i;
    }


    public double getValue() {
        return value;
    }
}
