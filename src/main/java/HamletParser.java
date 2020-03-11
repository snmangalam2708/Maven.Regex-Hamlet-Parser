import com.sun.xml.internal.rngom.binary.PatternBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private Pattern pattern;
    private Matcher matcher;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String replaceHamlet () {

        String regex = "Hamlet";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(hamletData);
        String newHamlet  = matcher.replaceAll(("Leon"));
        return newHamlet;

    }

    public String replaceHoratio () {
        String regex = "Horatio";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(hamletData);
        String newHamlet  =matcher.replaceAll(("Tariq"));
        return newHamlet;
    }

    public void findHamlet () throws FileNotFoundException {
        System.out.println(hamletData);
    }

    public String getHamletData(){

        return hamletData;
    }

}