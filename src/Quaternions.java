
public final class Quaternions {

    private double x0, x1, x2, x3;

    //Создание кватерниона
    public Quaternions(double x0, double x1, double x2, double x3) {
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
    public Quaternions conjugate() {
        return new Quaternions(x0, -x1, -x2, -x3);
    }

    //Сумма
    public Quaternions plus(Quaternions other) {
        return new Quaternions(x0 + other.x0, x1 + other.x1, x2 + other.x2, x3 + other.x3);
    }

    //Разность
    public Quaternions minus(Quaternions other) {
        return new Quaternions(x0 - other.x0, x1 - other.x1, x2 - other.x2, x3 - other.x3);
    }

    //Умножение на скаляр
    public Quaternions scalarMember(double a) {
        if (a != 1) {
            x0 *= a;
            x1 *= a;
            x2 *= a;
            x3 *= a;
        }
        return this;
    }

    //Умножение
    public Quaternions multiply(Quaternions other) {
        double k1 = x0 * other.x0 - x1 * other.x1 - x2 * other.x2 - x3 * other.x3;
        double k2 = x0 * other.x1 + x1 * other.x0 + x2 * other.x3 - x3 * other.x2;
        double k3 = x0 * other.x2 - x1 * other.x3 + x2 * other.x0 + x3 *  other.x1;
        double k4 = x0 * other.x3 + x1 * other.x2 - x2 * other.x1 + x3 * other.x0;
        return new Quaternions(k1, k2, k3, k4);
    }

    //Деление (обращение)
    public Quaternions division() {
        double denominator = norm();
        return new Quaternions(x0 / denominator, -x1 / denominator, -x2 / denominator, -x3 / denominator);
    }

    //Скалярная часть
    public Quaternions scalar(Quaternions other) {
        return new Quaternions(x0, 0.0, 0.0, 0.0);
    }

    //Векторная часть
    public Quaternions vector(Quaternions other) {
        return new Quaternions(0.0, 0.0, 0.0, x3);
    }

    //Создание оси и угла поворота
    public Quaternions AxisRotateAngle(VectorQuat axis, double rotateAngle) {
        double a = Math.sin(rotateAngle / 2);
        double w = Math.cos(rotateAngle / 2);
        double i = axis.x * a;
        double j = axis.y * a;
        double k = axis.z * a;
        return this;
    }

    //Возваращение угла от данного кватерниона
    public double returnAngle() {
        return 2 * Math.acos(x0);
    }

    //Возвращение оси от данного кватерниона
    public VectorQuat returnAxis() {
        double anglePart = Math.sin(Math.acos(x0));
        double x = x1 / anglePart;
        double y = x2 / anglePart;
        double z = x3 / anglePart;
        return new VectorQuat(x, y, z);
    }

    //overrides
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Quaternions) {
            Quaternions other = (Quaternions) obj;
            return (Math.abs(x0 - other.x0) < 1.0e-5) && (Math.abs(x1 - other.x1) < 1.0e-5) &&
                    (Math.abs(x2 - other.x2) < 1.0e-5) && (Math.abs(x3 - other.x3) < 1.0e-5);
        }
        return false;
    }

    @Override
    public int hashCode() {
        long x0Long = Double.valueOf(x0).longValue();
        long x1Long = Double.valueOf(x1).longValue();
        long x2Long = Double.valueOf(x2).longValue();
        long x3Long = Double.valueOf(x3).longValue();
        long longResult = x0Long;
        longResult = 17 * longResult + x1Long;
        longResult = 17 * longResult + x2Long;
        longResult = 17 * longResult + x3Long;
        int result = (int)  longResult;
        return result;
    }

    @Override
    public String toString() {

        return String.format(x0 + " + " + x1 + "i + " + x2 + "j + " + x3 + "k");
    }
}
