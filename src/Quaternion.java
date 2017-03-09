
public final class Quaternion {

    private final double x0, x1, x2, x3;

    //Создание кватерниона
    public Quaternion(double x0, double x1, double x2, double x3) {
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    //Нормирование
    public double norm() {
        return (x0 * x0 + x1 * x1 + x2 * x2 + x3 * x3);
    }

    //Модуль
    public double mod() {
        return Math.sqrt(norm());
    }

    //Сопряжение
    public Quaternion conjugate() {
        return new Quaternion(x0, -x1, -x2, -x3);
    }

    //Сумма
    public Quaternion plus(Quaternion other) {
        return new Quaternion(x0 + other.x0, x1 + other.x1, x2 + other.x2, x3 + other.x3);
    }

    //Разность
    public Quaternion minus(Quaternion other) {
        return new Quaternion(x0 - other.x0, x1 - other.x1, x2 - other.x2, x3 - other.x3);
    }

    //Умножение на скаляр
    public Quaternion scalarMember(double a) {
        return new Quaternion(x0 * a, x1 * a, x2 * a, x3 * a);
    }

    //Умножение
    public Quaternion multiply(Quaternion other) {
        final double k1 = x0 * other.x0 - x1 * other.x1 - x2 * other.x2 - x3 * other.x3;
        final double k2 = x0 * other.x1 + x1 * other.x0 + x2 * other.x3 - x3 * other.x2;
        final double k3 = x0 * other.x2 - x1 * other.x3 + x2 * other.x0 + x3 *  other.x1;
        final double k4 = x0 * other.x3 + x1 * other.x2 - x2 * other.x1 + x3 * other.x0;
        return new Quaternion(k1, k2, k3, k4);
    }

    //Деление (обращение умножения)
    public Quaternion division(Quaternion other) {
        final double denominator = (other.x0 * other.x0 + other.x1 * other.x1 + other.x2 * other.x2 + other.x3 * other.x3);
        return new Quaternion(x0 * (other.x0 / denominator), x1 * (other.x1 / denominator), x2 * (other.x2 / denominator), x3 * (other.x3 / denominator));
    }

    //Скалярная часть
    public Quaternion scalar() {
        return new Quaternion(x0, 0.0, 0.0, 0.0);
    }

    //Векторная часть
    public Quaternion vector() {
        return new Quaternion(0.0, 0.0, 0.0, x3);
    }

    //Создание кватерниона по оси и углу поворота
    public static Quaternion axisRotateAngle(VectorQuaternion axis, double rotateAngle) {
        final double w = rotateAngle;
        final double i = axis.returnX();
        final double j = axis.returnY();
        final double k = axis.returnZ();
        return new Quaternion(w, i, j, k);
    }

    //Возваращение угла от данного кватерниона
    public double returnAngle() {
        return x0;
    }

    //Возвращение оси от данного кватерниона
    public VectorQuaternion returnAxis() {
        return new VectorQuaternion(x1, x2, x3);
    }

    //overrides
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Quaternion) {
            final Quaternion other = (Quaternion) obj;
            return (Math.abs(x0 - other.x0) < 1.0e-5) && (Math.abs(x1 - other.x1) < 1.0e-5) &&
                    (Math.abs(x2 - other.x2) < 1.0e-5) && (Math.abs(x3 - other.x3) < 1.0e-5);
        }
        return false;
    }

    @Override
    public int hashCode() {
        final long x0Long = Double.valueOf(x0).longValue();
        final long x1Long = Double.valueOf(x1).longValue();
        final long x2Long = Double.valueOf(x2).longValue();
        final long x3Long = Double.valueOf(x3).longValue();
        long longResult = x0Long;
        longResult = 17 * longResult + x1Long;
        longResult = 17 * longResult + x2Long;
        longResult = 17 * longResult + x3Long;
        return (int) longResult;
    }

    @Override
    public String toString() {
        return String.format(x0 + " + " + x1 + "i + " + x2 + "j + " + x3 + "k");
    }
}
