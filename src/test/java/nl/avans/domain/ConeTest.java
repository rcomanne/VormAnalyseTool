package nl.avans.domain;

import nl.avans.businesslogic.service.ConversionService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConeTest {
    private Shape cone;
    private Cone secondCone;

    @Before
    public void setUp() {
        cone = new Cone(15, 5);
        secondCone = new Cone(5, 15);
    }

    @Test
    public void toStringTest() {
        assertEquals("Kegel 15.0 5.0 1178.1", cone.toString());
    }

    @Test
    public void calculate() {
        assertEquals(ConversionService.staticRound(secondCone.calculate()), secondCone.getVolume(), 0);
    }

}