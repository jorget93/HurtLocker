import org.apache.commons.io.IOUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    String[] list = {"(m..k)","(m..k;price:3\\.23)","(m..k;price:1\\.23)", "(b...d)","(b...d;price:1\\.23)",
            "(c.....s)", "\"(c.....s;price:2\\.25)", "(a....s)","(a....s;price:0\\.25)", "(:;)"};
    Integer[] counts = {0,0,0,0,0,0,0,0,0,0};

    public String countOccurrence() throws Exception {
        String newString = "";
        Integer j = 1;
        for(int i = 0; i < list.length; i++) {
            Pattern pattern = Pattern.compile(list[i], Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(readRawDataToString());
            boolean foundMatch = matcher.find();
            while (matcher.find()) {
                j += 1;
            }
            counts[i] = j;
            j = 1;
        }
        newString = "Name:    milk    seen: " + counts[0] + " times\n";
        newString += "_____________    _____________\n";
        newString += "_____________    _____________\n";
        newString += "Price:   3.23    seen: " + counts[1] + " times\n";
        newString += "_____________    _____________\n";
        newString += "Price:   1.23    seen: " + counts[2] + " times\n\n";
        newString += "Name:   bread    seen: " + counts[3] + " times\n";
        newString += "_____________    _____________\n";
        newString += "_____________    _____________\n";
        newString += "Price:   1.23    seen: " + counts[4] + " times\n\n";
        newString += "Name: cookies    seen: " + counts[5] + " times\n";
        newString += "_____________    _____________\n";
        newString += "_____________    _____________\n";
        newString += "Price:   2.25    seen: " + counts[6] + " times\n\n";
        newString += "Name:  apples    seen: " + counts[7] + " times\n";
        newString += "_____________    _____________\n";
        newString += "_____________    _____________\n";
        newString += "Price:   0.25    seen: " + counts[8] + " times\n\n";
        newString += "Errors           seen: " + counts[9] + " times";

        return newString;
    }

    public static void main(String[] args) throws Exception{

        String output = (new Main()).countOccurrence();
        System.out.println(output);

    }
}
