package Pattern.FactoryMethod;

public class InstructionRusFactory implements InstructionFactory{

    @Override
    public Instruction createInstruction() {
        return new InstructionImplRus();
    }
}
