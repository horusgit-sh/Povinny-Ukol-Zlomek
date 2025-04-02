package model;

public class Zlomek extends Number {
    private final int citatel;
    private final int jmenovatel;

    public Zlomek(int citatel, int jmenovatel) {
        if (jmenovatel == 0) {
            throw new ArithmeticException("Jmenovatel nesmi byt 0!");
        }
        this.citatel = citatel;
        this.jmenovatel = jmenovatel;
    }

    public int getCitatel() {
        return citatel;
    }

    public int getJmenovatel() {
        return jmenovatel;
    }


    public Zlomek krat(Zlomek druhy) {
        return new Zlomek(citatel * druhy.citatel, jmenovatel * druhy.jmenovatel);
    }


    public Zlomek deleno(Zlomek druhy) {
        if (druhy.citatel == 0) {
            throw new ArithmeticException("Deleni na nulovy citatel!");
        }
        return new Zlomek(citatel * druhy.jmenovatel, jmenovatel * druhy.citatel);
    }


    public Zlomek plus(Zlomek druhy) {
        int novyCitatel = citatel * druhy.jmenovatel + druhy.citatel * jmenovatel;
        int novyJmenovatel = jmenovatel * druhy.jmenovatel;
        return new Zlomek(novyCitatel, novyJmenovatel);
    }


    public Zlomek minus(Zlomek druhy) {
        int novyCitatel = citatel * druhy.jmenovatel - druhy.citatel * jmenovatel;
        int novyJmenovatel = jmenovatel * druhy.jmenovatel;
        return new Zlomek(novyCitatel, novyJmenovatel);
    }


    public Zlomek zkratit() {
        int a = Math.abs(citatel);
        int b = Math.abs(jmenovatel);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return new Zlomek(citatel / a, jmenovatel / a);
    }

    @Override
    public String toString() {
        return String.format("%d / %d", citatel, jmenovatel);
    }

    @Override
    public int intValue() {
        return citatel / jmenovatel;
    }

    @Override
    public long longValue() {
        return intValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return ((double) citatel) / jmenovatel;
    }
}
