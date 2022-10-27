package PatternTest.FactoryMethodTest;

import Pattern.FactoryMethod.Instruction;
import Pattern.FactoryMethod.InstructionDistributor;
import Pattern.FactoryMethod.InstructionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;


public class InstructionEngImplTest implements Instruction {


    // Contain text: 'test'
    String expectPath = "Instructions/instruction_test.txt";

    @Override
    public String getInstruction(String path) {
        return readInstruction(path);
    }

    @Override
    public String readInstruction(String path) {
        return Instruction.super.readInstruction(path);
    }


    @Test
    public void returnedInstructionAreNotSame() {
        // create two same instructions
        InstructionDistributor instructionDistributor = new InstructionDistributor();
        InstructionDistributor instructionDistributor1 = new InstructionDistributor();
        // declare 1st
        instructionDistributor1.getNecessaryInstruction();
        // change localization
        Locale.setDefault(new Locale("eng", "GB"));
        // declare 2nd
        instructionDistributor.getNecessaryInstruction();
        // compare
        Assertions.assertNotEquals(instructionDistributor1, instructionDistributor);

    }
    @Test
    public void instructionReadCorrect(){
        String str = readInstruction(expectPath);
        Assertions.assertEquals("test", str);
    }
}
