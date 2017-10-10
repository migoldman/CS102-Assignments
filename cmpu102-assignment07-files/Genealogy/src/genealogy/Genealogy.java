package genealogy;
import acm.program.*;
import utilities.*;

public class Genealogy extends ConsoleProgram {
    

    
    public void run() {
        println("Washington's Ancestors Ordered Backwards by Generation: ");
        queueOrderPrint(genealogy);
        println();
        println("Washington's Ancestors Ordered Backwards by Birth Year: ");
        priorityQueueOrderPrint(genealogy);
    }

    public static void main(String[] args) {
        new Genealogy().start();
    }
    
}
