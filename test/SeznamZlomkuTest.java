package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.*;

public class SeznamZlomkuTest {
    private SeznamZlomku seznam;

    @BeforeEach
    void setUp() {
        seznam = new SeznamZlomku();
    }

    @Test
    void pridatZlomek() {
        Zlomek z = new Zlomek(1, 2);
        seznam.pridatZlomek(z);
        Zlomek result = seznam.vratZlomek(0);
        assertEquals(1, result.getCitatel(), "Chybny citatel");
        assertEquals(2, result.getJmenovatel(), "Chybny jmenovatel");
    }

    @Test
    void odebratZlomek() {
        Zlomek z1 = new Zlomek(1, 2);
        Zlomek z2 = new Zlomek(3, 4);
        seznam.pridatZlomek(z1);
        seznam.pridatZlomek(z2);
        seznam.odebratZlomek(0);
        Zlomek result = seznam.vratZlomek(0);
        assertEquals(3, result.getCitatel(), "Chybny citatel");
        assertEquals(4, result.getJmenovatel(), "Chybny jmenovatel");
    }

    @Test
    void krat() {
        Zlomek a = new Zlomek(3, 4);
        Zlomek b = new Zlomek(4, 5);
        Zlomek c = a.krat(b);
        assertEquals(12, c.getCitatel(), "Chybny citatel");
        assertEquals(20, c.getJmenovatel(), "Chybny jmenovatel");
    }

    @Test
    void deleno() {
        Zlomek a = new Zlomek(3, 4);
        Zlomek b = new Zlomek(4, 5);
        Zlomek c = a.deleno(b);
        assertEquals(15, c.getCitatel(), "Chybny citatel");
        assertEquals(16, c.getJmenovatel(), "Chybny jmenovatel");
    }

    @Test
    void plus() {
        Zlomek a = new Zlomek(1, 2);
        Zlomek b = new Zlomek(1, 3);
        Zlomek c = a.plus(b);
        assertEquals(5, c.getCitatel(), "Chybny citatel");
        assertEquals(6, c.getJmenovatel(), "Chybny jmenovatel");
    }

    @Test
    void minus() {
        Zlomek a = new Zlomek(1, 2);
        Zlomek b = new Zlomek(1, 3);
        Zlomek c = a.minus(b);
        assertEquals(1, c.getCitatel(), "Chybny citatel");
        assertEquals(6, c.getJmenovatel(), "Chybny jmenovatel");
    }

    @Test
    void zkratit() {
        Zlomek z = new Zlomek(10, 20).zkratit();
        assertEquals(1, z.getCitatel(), "Chybny citatel");
        assertEquals(2, z.getJmenovatel(), "Chybny jmenovatel");
    }
}
