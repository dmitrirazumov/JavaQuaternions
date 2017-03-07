public final class VectorQuaternion {

   private final double x;
   private final double y;
   private final double z;

    public VectorQuaternion(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double returnX() {
        return x;
    }

    public double returnY() {
        return y;
    }

    public double returnZ() {
        return z;
    }

    @Override
    public String toString() {
        return String.format("%2f %2f %2f", x, y, z);
    }
}