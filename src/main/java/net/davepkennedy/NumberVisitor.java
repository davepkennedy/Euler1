package net.davepkennedy;

public interface NumberVisitor {
    boolean accept (int number);
    void process (int number);
    int getTotal();
}
