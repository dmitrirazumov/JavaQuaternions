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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof VectorQuaternion) {
            final VectorQuaternion other = (VectorQuaternion) obj;
            return (Math.abs(x - other.x) < 1.0e-3) && (Math.abs(y - other.y) < 1.0e-3) &&
                    (Math.abs(z - other.z) < 1.0e-3);
        }
        return false;
    }
}