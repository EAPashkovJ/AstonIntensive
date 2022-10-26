package Pattern.FactoryMethod;


import java.io.*;

public class InstructionImplRus implements Instruction {

    @Override
    public void getInstruction() {


        Reader reader;
        try {
            reader = new FileReader(

                    "Instructions/instruction_rus.txt");

            BufferedReader buffReader =
                    new BufferedReader(reader);

            while (buffReader.ready()) {
                System.out.println(
                        buffReader.readLine());
            }
            reader.close();
            buffReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
