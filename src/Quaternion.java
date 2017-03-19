
public final class Quaternion {

    private final double x0;
    private final double x1;
    private final double x2;
    private final double x3;


    //Создание кватерниона
    double[][] matrix;

    public Quaternion(double x0, double x1, double x2, double x3) {
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
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
    public double[][] conjugate() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrix[i][j] > 0 && i != j) {
                    matrix[i][j] = -(matrix[i][j]);
                }
            }
        }
        return matrix;
    }

    //Сумма
    public double[][] plus(Quaternion other) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = matrix[i][j] + other.matrix[i][j];
            }
        }
        return matrix;
    }

    //Разность
    public double[][] minus(Quaternion other) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = matrix[i][j] - other.matrix[i][j];
            }
        }
        return matrix;
    }

    //Умножение на скаляр
    public double[][] scalarMember(double a) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = matrix[i][j] * a;
            }
        }
        return matrix;
    }

    //Умножение
    public double[][] multiply(Quaternion other) {
        final double k1 = matrix[0][0] * other.matrix[0][0] - matrix[1][0] * other.matrix[1][0] - matrix[2][0] * other.matrix[2][0] - matrix[3][0] * other.matrix[3][0];
        final double k2 = matrix[0][0] * other.matrix[1][0] + matrix[1][0] * other.matrix[0][0] + matrix[2][0] * other.matrix[3][0] - matrix[3][0] * other.matrix[2][0];
        final double k3 = matrix[0][0] * other.matrix[2][0] - matrix[1][0] * other.matrix[3][0] + matrix[2][0] * other.matrix[0][0] + matrix[3][0] * other.matrix[1][0];
        final double k4 = matrix[0][0] * other.matrix[3][0] + matrix[1][0] * other.matrix[2][0] - matrix[2][0] * other.matrix[1][0] + matrix[3][0] * other.matrix[0][0];
        Quaternion a = new Quaternion(k1, k2, k3, k4);
        return a.matrix;
    }

    //Деление (обращение умножения)
    public double[][] division(Quaternion other) {
        final double denominator = other.matrix[0][0] * other.matrix[0][0] + other.matrix[1][0] * other.matrix[1][0] + other.matrix[2][0] * other.matrix[2][0] + other.matrix[3][0] * other.matrix[3][0];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = matrix[i][j] * (other.matrix[i][j] / denominator);
            }
        }
        return matrix;
    }

    //Скалярная часть
    public double[][] scalar() {
        //return new Quaternion(x0, 0.0, 0.0, 0.0);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    //Векторная часть
    public double[][] vector() {
        //return new Quaternion(0.0, 0.0, 0.0, x3);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j != 3 - i) matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    //Создание кватерниона по оси и углу поворота
    public static double[][] axisRotateAngle(VectorQuaternion axis, double rotateAngle) {
        final double w = rotateAngle;
        final double i = axis.returnX();
        final double j = axis.returnY();
        final double k = axis.returnZ();
        Quaternion b = new Quaternion(w, i, j, k);
        return b.matrix;
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
