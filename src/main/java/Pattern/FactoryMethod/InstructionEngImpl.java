package Pattern.FactoryMethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class InstructionEngImpl implements Instruction{
    @Override
    public void getInstruction() {
        Reader reader;
        try {
            reader = new FileReader(

                    "Instructions/instruction_eng.txt");

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
