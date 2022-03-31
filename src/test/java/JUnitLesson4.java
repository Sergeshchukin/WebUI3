import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.jupiter.api.Assertions.assertTrue;


public class JUnitLesson4 {
    int a;
    int b;
    int c;


    @ParameterizedTest
    @CsvSource({"1,2,2", "3,4,5", "9,12,15"})
    @DisplayName("проверки на площадь треугольника")
    public void someTest0(int x, int y, int z) {
        double p = ((float) (x + y + z)) / 2;


        double sumTr = Tr.tr(x, y, z);
        assertTrue(sumTr >= 0, " Это не треугольник");
        assertTrue(Math.abs(sumTr - Math.sqrt(p * (p - x) * (p - y) * (p - z))) <= 0.000001);
    }


    @DisplayName("проверка на прямой угол")
    @Test
    public void someTest1() {
        a = 6;
        b = 8;
        c = 10;
        double sumTr = Tr.tr(a, b, c);
        assertTrue(sumTr >= 0, " Это не треугольник");
        assertTrue(Math.abs(sumTr - 0.5 * a * b) <= 0.000001);
    }

    @DisplayName("Это не треугольник")
    @Test
    public void someTest2() {
        double sumTr = Tr.tr(0, 0, 0);
        assertTrue(sumTr <= 0, " Это не треугольник");
        Assertions.assertEquals(sumTr, -1);
    }

    @DisplayName("Проверка на отрицательные значения")
    @Test
    public void someTest3() {
        double sumTr = Tr.tr(-3, -4, -5);
        assertTrue(sumTr <= 0, " Это не треугольник");
        Assertions.assertEquals(sumTr, -1);
    }

    @DisplayName("Равнобедренный треугольник")
    @Test
    public void someTest4() {
        a = 5;
        b = a;
        c = 2;
        double sumTr = Tr.tr(a, b, c);
        assertTrue(sumTr >= 0, " Это не треугольник");
        assertTrue(Math.abs(sumTr - 0.5 * c * Math.sqrt(a * a - ((double) c * c) / 4)) <= 0.000001);
    }


    @Nested
    @DisplayName("Тесты на логгирование")
    public class MyTest1 {

        private static Logger logger = LoggerFactory.getLogger(MyTest1.class);

        @Test
        void logTest() {
            logger.debug("dubug");
            logger.error("error");
        }
    }

}