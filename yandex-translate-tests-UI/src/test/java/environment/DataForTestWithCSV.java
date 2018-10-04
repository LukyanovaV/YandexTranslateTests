package environment;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataForTestWithCSV {



    public static Collection<String[]> getTestData(String filename) throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;

        BufferedReader file = new BufferedReader(new FileReader(filename));

        while((record = file.readLine())!=null){
            String fields[] = record.split(",");
            records.add(fields);
        }

        file.close();
        return records;
    }

}
