package model;
import java.util.*;


public class SeznamZlomku {
    private List<Zlomek> zlomky;

    public SeznamZlomku() {
        zlomky = new ArrayList<>();
    }

    public void pridatZlomek(Zlomek zlomek) {
        zlomky.add(zlomek);
    }

    public void odebratZlomek(int index) {
        if (index >= 0 && index < zlomky.size()) {
            zlomky.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Neplatny index pro odstraneni.");
        }
    }

    public Zlomek vratZlomek(int index) {
        if (index >= 0 && index < zlomky.size()) {
            return zlomky.get(index);
        } else {
            throw new IndexOutOfBoundsException("Neplatny index pro ziskani zlomku.");
        }
    }

    public void vypisZlomky() {
        if (zlomky.isEmpty()) {
            System.out.println("Seznam je prazdny.");
        } else {
            for (Zlomek z : zlomky) {
                System.out.println(z);
            }
        }
    }

    public Zlomek spoctiSoucet() {
        Zlomek soucet = new Zlomek(0, 1);
        for (Zlomek z : zlomky) {
            soucet = soucet.plus(z);
        }
        return soucet.zkratit();
    }

    public Zlomek spoctiPrumer() {
        if (zlomky.isEmpty()) return new Zlomek(0, 1);
        return new Zlomek(spoctiSoucet().getCitatel(), spoctiSoucet().getJmenovatel() * zlomky.size()).zkratit();
    }
}