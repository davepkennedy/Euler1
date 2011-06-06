package net.davepkennedy;

import java.util.LinkedList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        List<NumberVisitor> visitorList = new LinkedList<NumberVisitor>();
        visitorList.add(NumberVisitorFactory.getInstance().getVisitor(3));
        visitorList.add(NumberVisitorFactory.getInstance().getVisitor(5));

        for (int i = 0; i < 1000; i++) {
            for (NumberVisitor visitor : visitorList) {
                if (visitor.accept(i)) {
                    visitor.process(i);
                    break;
                }
            }
        }

        int total = 0;
        for (NumberVisitor visitor : visitorList) {
            total += visitor.getTotal();
        }

        System.out.println (total);
    }
}
