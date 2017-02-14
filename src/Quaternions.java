/**
 * Created by bigbo on 09.02.2017.
 */

//Класс "Кватернионы"
public final class Quaternions {

    //Свойства класса
    private double x0, x1, x2, x3; //Вещественные числа


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
        double k3 = x0 * other.x2 - x1 * other.x3 + x2 * other.x0 + x3 * other.x1;
        double k4 = x0 * other.x3 + x1 * other.x2 - x2 * other.x1 + x3 * other.x0;
        return new Quaternions(k1, k2, k3, k4);
    }

    //Деление
    public Quaternions division(Quaternions other) {
        double denominator = norm();
        return new Quaternions(x0 / denominator, -x1 / denominator, -x2 / denominator, -x3 / denominator);
    }

    //Скаляр
    public Quaternions scalar(Quaternions other) {
        return new Quaternions(x0, 0.0, 0.0, 0.0);
    }
}
