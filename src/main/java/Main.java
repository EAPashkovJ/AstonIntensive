
import Pattern.FactoryMethod.Instruction;
import Pattern.FactoryMethod.InstructionDistributor;
import Pattern.FactoryMethod.InstructionFactory;
import Pattern.Proxy.ProxyTimeParse;
import Pattern.Proxy.TimeParse;

import java.util.Locale;


public class Main {
    public static void main(String[] args) {


        // return current date and time
        TimeParse timeParse = new ProxyTimeParse();
        String str = timeParse.parseElement();
        System.out.println(str);

        //Try for change Locale
        //Locale.setDefault(new Locale("eng", "GB"));

        InstructionDistributor inst = new InstructionDistributor();
        System.out.println(inst.getNecessaryInstruction());


    }
}