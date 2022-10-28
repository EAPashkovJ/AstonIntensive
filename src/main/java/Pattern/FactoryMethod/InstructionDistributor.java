package Pattern.FactoryMethod;

import java.util.Locale;

public class InstructionDistributor {
    private static String path;

    public String getNecessaryInstruction() {
        switch (Locale.getDefault().getLanguage()) {

            case "ru": {

                path = "Instructions/instruction_rus.txt";
                InstructionFactory instructionFactory = new InstructionRusFactory();

                return instructionFactory.createInstruction().getInstruction(path);
            }
            case "eng": {
                path = "Instructions/instruction_eng.txt";
                InstructionFactory instructionFactory = new InstructionEngFactory();
                return instructionFactory.createInstruction().getInstruction(path);
            }
            default:
                return "Not matches";
        }
    }
}
