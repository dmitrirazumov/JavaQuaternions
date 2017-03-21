import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    double[][] matrix1;
    double[][] matrix2;
    double[][] matrix3;
    double[][] matrix4;
    double[][] matrix5;
    double[][] matrix6;
    double[][] matrix7;
    double[][] matrix8;
    double[][] matrix9;
    double[][] matrix10;
    double[][] matrix11;

    @Before
    public void createMatrix() {
        matrix1 = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix1[i][i] = 2.0;
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0 || i == 1) matrix1[i][3 - i] = -1.0;
            else matrix1[i][3 - i] = -1.0;
        }
        matrix1[1][0] = -3.0;
        matrix1[0][1] = -3.0;
        matrix1[2][3] = -3.0;
        matrix1[3][2] = -3.0;
        matrix1[0][2] = -4.0;
        matrix1[2][0] = -4.0;
        matrix1[1][3] = -4.0;
        matrix1[3][1] = -4.0;

        matrix2 = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix2[i][i] = 1.95;
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0 || i == 1) matrix2[i][3 - i] = -1.214;
            else matrix2[i][3 - i] = -1.214;
        }
        matrix2[1][0] = -3.28;
        matrix2[0][1] = -3.28;
        matrix2[2][3] = -3.28;
        matrix2[3][2] = -3.28;
        matrix2[0][2] = -4.999;
        matrix2[2][0] = -4.999;
        matrix2[1][3] = -4.999;
        matrix2[3][1] = -4.999;

        matrix3 = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix3[i][i] = 2.0;
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0 || i == 1) matrix3[i][3 - i] = -4.0;
            else matrix3[i][3 - i] = 4.0;
        }
        matrix3[1][0] = 3.0;
        matrix3[0][1] = -3.0;
        matrix3[2][3] = -3.0;
        matrix3[3][2] = 3.0;
        matrix3[0][2] = -6.0;
        matrix3[2][0] = 6.0;
        matrix3[1][3] = 6.0;
        matrix3[3][1] = -6.0;

        matrix4 = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix4[i][i] = 1.0;
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0 || i == 1) matrix4[i][3 - i] = -2.0;
            else matrix4[i][3 - i] = 2.0;
        }
        matrix4[1][0] = 1.5;
        matrix4[0][1] = -1.5;
        matrix4[2][3] = -1.5;
        matrix4[3][2] = 1.5;
        matrix4[0][2] = -3.0;
        matrix4[2][0] = 3.0;
        matrix4[1][3] = 3.0;
        matrix4[3][1] = -3.0;

        matrix5 = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix5[i][i] = 4.0;
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0 || i == 1) matrix5[i][3 - i] = -8.0;
            else matrix5[i][3 - i] = 8.0;
        }
        matrix5[1][0] = 6.0;
        matrix5[0][1] = -6.0;
        matrix5[2][3] = -6.0;
        matrix5[3][2] = 6.0;
        matrix5[0][2] = -12.0;
        matrix5[2][0] = 12.0;
        matrix5[1][3] = 12.0;
        matrix5[3][1] = -12.0;

        matrix6 = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix6[i][i] = 4.0;
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0 || i == 1) matrix6[i][3 - i] = -8.0;
            else matrix6[i][3 - i] = 8.0;
        }
        matrix6[1][0] = 6.0;
        matrix6[0][1] = -6.0;
        matrix6[2][3] = -6.0;
        matrix6[3][2] = 6.0;
        matrix6[0][2] = -12.0;
        matrix6[2][0] = 12.0;
        matrix6[1][3] = 12.0;
        matrix6[3][1] = -12.0;

        matrix7 = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix7[i][i] = -34.0;
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0 || i == 1) matrix7[i][3 - i] = -18.0;
            else matrix7[i][3 - i] = 18.0;
        }
        matrix7[1][0] = 58.0;
        matrix7[0][1] = -58.0;
        matrix7[2][3] = -58.0;
        matrix7[3][2] = 58.0;
        matrix7[0][2] = 20.0;
        matrix7[2][0] = -20.0;
        matrix7[1][3] = -20.0;
        matrix7[3][1] = 20.0;

        matrix8 = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix8[i][i] = 0.25;
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0 || i == 1) matrix8[i][3 - i] = 0.25;
            else matrix8[i][3 - i] = 0.25;
        }
        matrix8[1][0] = 0.25;
        matrix8[0][1] = 0.25;
        matrix8[2][3] = 0.25;
        matrix8[3][2] = 0.25;
        matrix8[0][2] = 0.25;
        matrix8[2][0] = 0.25;
        matrix8[1][3] = 0.25;
        matrix8[3][1] = 0.25;

        matrix9 = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix9[i][i] = 1.0;
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0 || i == 1) matrix9[i][3 - i] = 0.0;
            else matrix9[i][3 - i] = 0.0;
        }
        matrix9[1][0] = 0.0;
        matrix9[0][1] = 0.0;
        matrix9[2][3] = 0.0;
        matrix9[3][2] = 0.0;
        matrix9[0][2] = 0.0;
        matrix9[2][0] = 0.0;
        matrix9[1][3] = 0.0;
        matrix9[3][1] = 0.0;

        matrix10 = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix10[i][i] = 0.0;
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0 || i == 1) matrix10[i][3 - i] = -1.0;
            else matrix10[i][3 - i] = 1.0;
        }
        matrix10[1][0] = 0.0;
        matrix10[0][1] = 0.0;
        matrix10[2][3] = 0.0;
        matrix10[3][2] = 0.0;
        matrix10[0][2] = 0.0;
        matrix10[2][0] = 0.0;
        matrix10[1][3] = 0.0;
        matrix10[3][1] = 0.0;

        matrix11 = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix10[i][i] = 0.0;
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0 || i == 1) matrix11[i][3 - i] = -3.0;
            else matrix11[i][3 - i] = 3.0;
        }
        matrix11[1][0] = 0.0;
        matrix11[0][1] = -0.0;
        matrix11[2][3] = -0.0;
        matrix11[3][2] = 0.0;
        matrix11[0][2] = -2.0;
        matrix11[2][0] = 2.0;
        matrix11[1][3] = 2.0;
        matrix11[3][1] = -2.0;
    }


    @Test
    public void norm() throws Exception {
        assertEquals(4.0, new Quaternion(1.0, 1.0, 1.0, 1.0).norm(), 1.0e-5);
        assertEquals(39.0, new Quaternion(1.0, 3.0, 2.0, 5.0).norm(), 1.0e-5);
        assertEquals(0.0, new Quaternion(0.0, 0.0, 0.0, 0.0).norm(), 1.0e-5);
        assertEquals(2816.436276, new Quaternion(6.124, 52.1, 3.5, 7.23).norm(), 1.0e-5);
    }

    @Test
    public void mod() throws Exception {
        assertEquals(2.0, new Quaternion(1.0, 1.0, 1.0, 1.0).mod(), 1.0e-5);
        assertEquals(0.0, new Quaternion(0.0, 0.0, 0.0, 0.0).mod(), 1.0e-5);
        assertEquals(5.0, new Quaternion(0.0, 0.0, 0.0, 5.0).mod(), 1.0e-5);
        assertEquals(11.4231431752, new Quaternion(6.25, 1.44, 2.89, 9.0).mod(), 1.0e-3);
    }

    @Test
    public void conjugate() throws Exception {
        assertEquals(matrix1, new Quaternion(2.0, 3.0, 4.0, 1.0).conjugate());
        assertEquals(matrix2, new Quaternion(1.95, 3.28, 4.999, 1.214).conjugate());
    }

    @Test
    public void plus() throws Exception {
        assertEquals(matrix3, new Quaternion(1.0, 1.5, 3.0, 2.0).plus(new Quaternion(1.0, 1.5, 3.0, 2.0)));
    }

    @Test
    public void minus() throws Exception {
        assertEquals(matrix4, new Quaternion(2.0, 3.0, 6.0, 4.0).minus(new Quaternion(1.0, 1.5, 3.0, 2.0)));
    }

    @Test
    public void scalarMember() throws Exception {
        assertEquals(matrix5, new Quaternion(2.0, 3.0, 6.0, 4.0).scalarMember(2.0));
    }

    @Test
    public void multiply() throws Exception {
        assertEquals(matrix7, new Quaternion(2.0, 5.0, 6.0, 2.0).multiply(new Quaternion(2.0, 2.0, 2.0, 8.0)));
    }

    @Test
    public void division() throws Exception {
        assertEquals(matrix8, new Quaternion(2.0, 2.0, 2.0, 2.0).division(new Quaternion(2.0, 2.0, 2.0, 2.0)));
    }

    @Test
    public void scalar() throws Exception {
        assertEquals(matrix9, new Quaternion(1.0, 1.0, 1.0, 1.0).scalar());
    }

    @Test
    public void vector() throws Exception {
        assertEquals(matrix10, new Quaternion(1.0, 1.0, 1.0, 1.0).vector());
    }

    @Test
    public void axisRotateAngle() throws Exception {
        assertEquals(matrix11, Quaternion.axisRotateAngle(new VectorQuaternion(0.0, 2.0, 3.0), 0.0));
    }

    @Test
    public void returnAngle() throws Exception {
        assertEquals(1.0, new Quaternion(1.0, 0.0, 0.0, 0.0).returnAngle(), 1.0e-5);
        assertEquals(-28.5, new Quaternion(-28.5, 56.285, 3.2456, 6.219).returnAngle(), 1.0e-5);
        assertEquals(245.44, new Quaternion(245.44, -2.0, -8.9, -1.78).returnAngle(), 1.0e-5);
    }

    @Test
    public void returnAxis() throws Exception {
        assertEquals(new VectorQuaternion(1.0, 1.0, 1.0), new Quaternion(0.0, 1.0, 1.0, 1.0).returnAxis());
        assertEquals(new VectorQuaternion(56.285, 3.2456, 6.219), new Quaternion(-28.5, 56.285, 3.2456, 6.219).returnAxis());
        assertEquals(new VectorQuaternion(-2.0, -8.9, -1.78), new Quaternion(245.44, -2.0, -8.9, -1.78).returnAxis());
    }
}
