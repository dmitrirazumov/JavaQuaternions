public final class VectorQuat {

    public final double x;
    public final double y;
    public final double z;

    public VectorQuat(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("%2f %2f %2f", x, y, z);
    }
}