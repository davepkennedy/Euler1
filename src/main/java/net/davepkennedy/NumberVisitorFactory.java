package net.davepkennedy;

public class NumberVisitorFactory {
    private NumberVisitorFactory () {}
    private static final NumberVisitorFactory INSTANCE = new NumberVisitorFactory();

    public static NumberVisitorFactory getInstance () {
        return INSTANCE;
    }

    public NumberVisitor getVisitor (int multiplesOf) {
        return new NumberVisitorImpl(multiplesOf);
    }

    private static class NumberVisitorImpl implements NumberVisitor {
        int multiplesOf;
        int total;

        public NumberVisitorImpl (int multiplesOf) {
            this.multiplesOf = multiplesOf;
        }

        @Override
        public boolean accept(int number) {
            return (number % multiplesOf == 0);
        }

        @Override
        public void process(int number) {
            total += number;
        }

        @Override
        public int getTotal() {
            return total;
        }
    }
}
