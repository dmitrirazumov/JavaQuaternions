
public final class Quaternion {

    //Создание кватерниона
    double[][] matrix;

    public Quaternion(double x0, double x1, double x2, double x3) {
        matrix = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix[i][i] = x0;
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0 || i == 1) matrix[i][3 - i] = -x3;
            else matrix[i][3 - i] = x3;
        }
        matrix[1][0] = x1;
        matrix[0][1] = -x1;
        matrix[2][3] = -x1;
        matrix[3][2] = x1;
        matrix[0][2] = -x2;
        matrix[2][0] = x2;
        matrix[1][3] = x2;
        matrix[3][1] = -x2;
    }

    //Нормирование
    public double norm() {
        return (matrix[0][0] * matrix[0][0] + matrix[0][1] * matrix[0][1] + matrix[0][2] * matrix[0][2] + matrix[0][3] * matrix[0][3]);
    }

    //Модуль
    public double mod() {
        return Math.sqrt(norm());
    }

    //Сопряжение
    public Quaternion conjugate() {
        Quaternion result = new Quaternion(matrix[0][0], matrix[1][0], matrix[2][0], matrix[3][0]);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (result.matrix[i][j] > 0 && i != j) {
                    result.matrix[i][j] = -(result.matrix[i][j]);
                }
            }
        }
        return result;
    }

    //Сумма
    public Quaternion plus(Quaternion other) {
        Quaternion result = new Quaternion(matrix[0][0], matrix[1][0], matrix[2][0], matrix[3][0]);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result.matrix[i][j] = matrix[i][j] + other.matrix[i][j];
            }
        }
        return result;
    }

    //Разность
    public Quaternion minus(Quaternion other) {
        Quaternion result = new Quaternion(matrix[0][0], matrix[1][0], matrix[2][0], matrix[3][0]);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result.matrix[i][j] = matrix[i][j] - other.matrix[i][j];
            }
        }
        return result;
    }

    //Умножение на скаляр
    public Quaternion scalarMember(double a) {
        Quaternion result = new Quaternion(matrix[0][0], matrix[1][0], matrix[2][0], matrix[3][0]);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result.matrix[i][j] = matrix[i][j] * a;
            }
        }
        return result;
    }

    //Умножение
    public Quaternion multiply(Quaternion other) {
        final double k1 = matrix[0][0] * other.matrix[0][0] - matrix[1][0] * other.matrix[1][0] - matrix[2][0] * other.matrix[2][0] - matrix[3][0] * other.matrix[3][0];
        final double k2 = matrix[0][0] * other.matrix[1][0] + matrix[1][0] * other.matrix[0][0] + matrix[2][0] * other.matrix[3][0] - matrix[3][0] * other.matrix[2][0];
        final double k3 = matrix[0][0] * other.matrix[2][0] - matrix[1][0] * other.matrix[3][0] + matrix[2][0] * other.matrix[0][0] + matrix[3][0] * other.matrix[1][0];
        final double k4 = matrix[0][0] * other.matrix[3][0] + matrix[1][0] * other.matrix[2][0] - matrix[2][0] * other.matrix[1][0] + matrix[3][0] * other.matrix[0][0];
        Quaternion result = new Quaternion(k1, k2, k3, k4);
        return result;
    }

    //Деление (обращение умножения)
    public Quaternion division(Quaternion other) {
        Quaternion result = new Quaternion(matrix[0][0], matrix[1][0], matrix[2][0], matrix[3][0]);
        final double denominator = other.matrix[0][0] * other.matrix[0][0] + other.matrix[1][0] * other.matrix[1][0] + other.matrix[2][0] * other.matrix[2][0] + other.matrix[3][0] * other.matrix[3][0];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result.matrix[i][j] = matrix[i][j] * (other.matrix[i][j] / denominator);
            }
        }
        return result;
    }

    //Скалярная часть

    public Quaternion scalar() {
        Quaternion result = new Quaternion(matrix[0][0], matrix[1][0], matrix[2][0], matrix[3][0]);
        result.matrix = matrix;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    result.matrix[i][j] = 0;
                }
            }
        }
        return result;
    }

    //Векторная часть
    public Quaternion vector() {
        //return new Quaternion(0.0, 0.0, 0.0, x3);
        Quaternion result = new Quaternion(matrix[0][0], matrix[1][0], matrix[2][0], matrix[3][0]);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j != 3 - i) result.matrix[i][j] = 0;
            }
        }
        return result;
    }

    //Создание кватерниона по оси и углу поворота
    public static Quaternion axisRotateAngle(VectorQuaternion axis, double rotateAngle) {
        final double w = rotateAngle;
        final double i = axis.returnX();
        final double j = axis.returnY();
        final double k = axis.returnZ();
        Quaternion result = new Quaternion(w, i, j, k);
        return result;
    }

    //Возваращение угла от данного кватерниона
    public double returnAngle() {
        return matrix[0][0];
    }

    //Возвращение оси от данного кватерниона
    public VectorQuaternion returnAxis() {
        return new VectorQuaternion(matrix[1][0], matrix[2][0], matrix[3][0]);
    }

    //overrides
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Quaternion) {
            final Quaternion other = (Quaternion) obj;
            return (Math.abs(matrix[0][0] - other.matrix[0][0]) < 1.0e-5) && (Math.abs(matrix[1][0] - other.matrix[1][0]) < 1.0e-5) &&
                    (Math.abs(matrix[2][0] - other.matrix[2][0]) < 1.0e-5) && (Math.abs(matrix[3][0] - other.matrix[3][0]) < 1.0e-5);
        }
        return false;
    }

    @Override
    public int hashCode() {
        final long x0Long = Double.valueOf(matrix[0][0]).longValue();
        final long x1Long = Double.valueOf(matrix[1][0]).longValue();
        final long x2Long = Double.valueOf(matrix[2][0]).longValue();
        final long x3Long = Double.valueOf(matrix[3][0]).longValue();
        long longResult = x0Long;
        longResult = 17 * longResult + x1Long;
        longResult = 17 * longResult + x2Long;
        longResult = 17 * longResult + x3Long;
        return (int) longResult;
    }

    @Override
    public String toString() {
        return String.format(matrix[0][0] + " + " + matrix[1][0] + "i + " + matrix[2][0] + "j + " + matrix[3][0] + "k");
    }
}
