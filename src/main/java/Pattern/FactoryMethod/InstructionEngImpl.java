package Pattern.FactoryMethod;


public class InstructionEngImpl implements Instruction {

    public String getInstruction(String path) {
        return readInstruction(path);
    }
}