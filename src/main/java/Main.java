import org.apache.commons.io.IOUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }



    public static void main(String[] args) throws Exception{
        Parser parser = new Parser();
        String output = parser.countOccurrence();
        System.out.println(output);

    }
}
