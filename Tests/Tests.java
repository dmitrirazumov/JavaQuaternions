import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

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
        assertEquals(new Quaternion(2.0, -3.0, -4.0, -1.0), new Quaternion(2.0, 3.0, 4.0, 1.0).conjugate());
        assertEquals(new Quaternion(1.95, -3.28, -4.999, -1.214), new Quaternion(1.95, 3.28, 4.999, 1.214).conjugate());
        assertEquals(new Quaternion(0.0, -2.0, -8.9, -1.78), new Quaternion(0.0, 2.0, 8.9, 1.78).conjugate());
    }

    @Test
    public void plus() throws Exception {
        assertEquals(new Quaternion(2.0, 3.0, 6.0, 4.0), new Quaternion(1.0, 1.5, 3.0, 2.0).plus(new Quaternion(1.0, 1.5, 3.0, 2.0)));
        assertEquals(new Quaternion(0.0, 0.8, 3.6, 8.0), new Quaternion(0.0, 0.4, 1.8, 4.0).plus(new Quaternion(0.0, 0.6, 1.6, 2.8)));
        assertEquals(new Quaternion(10.4738, 72.5186, 6.4912, 8.0), new Quaternion(5.2369, 36.2593, 3.2456, 4.0).plus(new Quaternion(5.0527, 20.0257, 0.0, 2.219)));
    }

    @Test
    public void minus() throws Exception {
        assertEquals(new Quaternion(1.0, 1.5, 3.0, 2.0), new Quaternion(2.0, 3.0, 6.0, 4.0).minus(new Quaternion(1.0, 1.5, 3.0, 2.0)));
        assertEquals(new Quaternion(0.0, 0.4, 1.8, 4.0), new Quaternion(0.0, 1.0, 3.4, 6.8).minus(new Quaternion(0.0, 0.6, 1.6, 2.8)));
        assertEquals(new Quaternion(5.2369, 36.2593, 3.2456, 4.0), new Quaternion(10.2896, 56.285, 3.2456, 6.219).minus(new Quaternion(5.0527, 20.0257, 0.0, 2.219)));
    }

    @Test
    public void scalarMember() throws Exception {
        assertEquals(new Quaternion(4.0, 6.0, 12.0, 8.0), new Quaternion(2.0, 3.0, 6.0, 4.0).scalarMember(2.0));
        assertEquals(new Quaternion(1.0, 1.0, 0.0, 7.0), new Quaternion(0.5, 0.5, 0.0, 3.5).scalarMember(2.0));
        assertEquals(new Quaternion(6.829515, 2.58157912, 9.581951, 5.152050), new Quaternion(1.70737875, 0.64539478, 2.39548775, 1.2880125).scalarMember(4.0));
    }

    @Test
    public void multiply() throws Exception {
        assertEquals(new Quaternion(-34.0, 58.0, -20.0, 18.0), new Quaternion(2.0, 5.0, 6.0, 2.0).multiply(new Quaternion(2.0, 2.0, 2.0, 8.0)));
        assertEquals(new Quaternion(-146303.5862, -5343.379099999999, 12701.211299999999, 82657.65927999999), new Quaternion(20.512, 123.567, 214.245, 12.12).multiply(new Quaternion(1.0, 6.7, 678.42, 12.22)));
        assertEquals(new Quaternion(0.0, 0.0, 0.0, 0.0), new Quaternion(0.0, 0.0, 0.0, 0.0).multiply(new Quaternion(0.0, 0.0, 0.0, 0.0)));
    }

    @Test
    public void division() throws Exception {
        assertEquals(new Quaternion(0.25, 0.25, 0.25, 0.25), new Quaternion(2.0, 2.0, 2.0, 2.0).division(new Quaternion(2.0, 2.0, 2.0, 2.0)));
    }

    @Test
    public void scalar() throws Exception {
        assertEquals(new Quaternion(1.0, 0.0, 0.0, 0.0), new Quaternion(1.0, 1.0, 1.0, 1.0).scalar());
        assertEquals(new Quaternion(-0.2, 0.0, 0.0, 0.0), new Quaternion(-0.2, 0.2, 0.2, 0.2).scalar());
    }

    @Test
    public void vector() throws Exception {
        assertEquals(new Quaternion(0.0, 0.0, 0.0, 1.0), new Quaternion(1.0, 1.0, 1.0, 1.0).vector());
        assertEquals(new Quaternion(0.0, 0.0, 0.0, 0.2), new Quaternion(-0.2, 0.2, 0.2, 0.2).vector());
    }

    @Test
    public void axisRotateAngle() throws Exception {
        assertEquals(new Quaternion(0.0, 0.0, 2.0, 3.0), Quaternion.axisRotateAngle(new VectorQuaternion(0.0, 2.0, 3.0), 0.0));
        assertEquals(new Quaternion(25.0, 33.32, 28.0, -3.0), Quaternion.axisRotateAngle(new VectorQuaternion(33.32, 28.0, -3.0), 25.0));
        assertEquals(new Quaternion(0.0, 0.0, 0.0, -1.0), Quaternion.axisRotateAngle(new VectorQuaternion(0.0, 0.0, -1.0), 0.0));
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
