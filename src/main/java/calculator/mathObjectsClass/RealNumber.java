package calculator.mathObjectsClass;

public class RealNumber implements MathObject {
    private float realNumber;

    public Float getValue() {
        return realNumber;
    }

    public RealNumber(float realNumber) {
        this.realNumber = realNumber;
    }

    @Override
    public String toString() {
        return "RealNumber "+ realNumber;
    }
}