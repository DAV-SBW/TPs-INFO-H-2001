package Exo2;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DateTest {
    @Test
    public void testIncrementSimple() {
        Date d = new Date(1,1,2012);
        d.increment();
        assertEquals(2,d.getDay());
        assertEquals(1,d.getMonth());
        assertEquals(2012,d.getYear());
    }

    @Test
    public void testIncrementEndMonth() {
        Date d = new Date(31,1,2012);
        d.increment();
        assertEquals(1, d.getDay());
        assertEquals(2, d.getMonth());
        assertEquals(2012, d.getYear());
    }

    @Test
    public void testIncrementEndYear() {
        Date d = new Date(31,12,2012);
        d.increment();
        assertEquals(1, d.getDay());
        assertEquals(1, d.getMonth());
        assertEquals(2013, d.getYear());
    }
    @Test(expected=RuntimeException.class)
    public void testConstructorInvalidMonth(){
        new Date(1,-1,2012);
    }
    @Test(expected=RuntimeException.class)
    public void testConstructorInvalidMonth1(){
        new Date(1,0,2012);
    }
    @Test(expected=RuntimeException.class)
    public void testConstructorInvalidMonth2(){
        new Date(1,13,2012);
    }
    @Test
    public void testConstructorValid(){
        Date d = new Date(16,2,2012);
        assertNotNull(d);
    }

    @Test
    public void testFebruaryLeapYear2012(){
        Date d = new Date(29,02,2012);
        assertNotNull(d);
        d.increment();
        assertEquals(1, d.getDay());
        assertEquals(3, d.getMonth());
    }
    @Test
    public void testFebruaryLeapYear2000(){
        Date d = new Date(29,02,2000);
        assertNotNull(d);
    }
    @Test(expected=RuntimeException.class)
    public void testFebruaryLeapYear1900(){
        new Date(29,02,1900);
    }

    @Test
    public void testFebruary2012Increment(){
        Date d = new Date(29,02,2012);
        d.increment();
        assertEquals(1, d.getDay());
        assertEquals(3, d.getMonth());
    }
    @Test
    public void testFebruary1900Increment(){
        Date d = new Date(28,02,1900);
        d.increment();
        assertEquals(1, d.getDay());
        assertEquals(3, d.getMonth());
    }
    @Test
    public void testToString(){
        Date d = new Date(1,03,2012);
        assertEquals("Jeudi 1 Mars 2012 le 61 ième jour de l'année",d.toString());
    }

    @Test
    public void testWriteToFile(){
        Date d = new Date(1,03,2012);
        d.writeToFile("test.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader("test.txt"));
            String test = in.readLine();
            assertEquals("Jeudi 1 Mars 2012 le 61 ième jour de l'année", test);
        } catch (FileNotFoundException e) {
            fail();
        } catch (IOException e) {
            fail();
        }
        //TODO : il faudrait supprimer le fichier test.txt
    }

    @Test(expected=RuntimeException.class)
    public void testSetYearLeapToNotLeap(){
        Date d = new Date(29,02,2012);
        d.setYear(2011);
    }
    /* TODO : ajouter des tests pour aller plus loin !:
     *
     * Tester un changement de mois.
        Par exemple new Date(31,01,2012).setMonth(2) -> Exception
     *
     *
     * Tester dayOfYear() (faire un cas également les années bisextiles)
     *
     * Tester dayOfWeek()
     */
}
