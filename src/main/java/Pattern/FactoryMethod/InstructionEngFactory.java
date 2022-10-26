package Pattern.FactoryMethod;

public class InstructionEngFactory implements InstructionFactory{
    @Override
    public Instruction createInstruction() {
        return new InstructionEngImpl();
    }
}
