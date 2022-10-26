
import Pattern.FactoryMethod.InstructionEngFactory;
import Pattern.FactoryMethod.InstructionFactory;
import Pattern.FactoryMethod.InstructionRusFactory;
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

        // return actual instruction depending system language
        switch (Locale.getDefault().getLanguage()) {

            case "ru": {
                InstructionFactory instructionFactory = new InstructionRusFactory();
                instructionFactory.createInstruction().getInstruction();
                break;
            }
            case "eng": {
                InstructionFactory instructionFactory = new InstructionEngFactory();
                instructionFactory.createInstruction().getInstruction();
                break;
            }
        }
    }

}