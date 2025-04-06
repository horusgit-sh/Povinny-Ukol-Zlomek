package model;

public record Zlomek(int citatel, int jmenovatel) {
    public Zlomek {
        if (jmenovatel == 0) {
            throw new ArithmeticException("Jmenovatel nesmi byt 0!");
        }
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


    public int intValue() {
        return citatel / jmenovatel;
    }


    public long longValue() {
        return intValue();
    }


    public float floatValue() {
        return (float) doubleValue();
    }


    public double doubleValue() {
        return ((double) citatel) / jmenovatel;
    }
}
