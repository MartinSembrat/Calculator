package calculator.mathObjectsClass;

public class RealNumber {
    private float realNumber;

    public float getRealNumber() {
        return realNumber;
    }

    public RealNumber(float realNumber) {
        this.realNumber = realNumber;
    }

    @Override
    public String toString() {
        return "RealNumber{" +
                "realNumber=" + realNumber +
                '}';
    }
}