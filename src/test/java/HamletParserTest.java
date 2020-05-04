import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {

        Assert.assertFalse(hamletParser.replaceHamlet().contains("Hamlet"));
    }

    @Test
    public void testChangeHoratioToTariq() {

        Assert.assertFalse(hamletParser.replaceHoratio().contains("Horatio"));
    }

    @Test
    public void testFindHoratio() {

        Assert.assertTrue(hamletText.contains("Horatio"));
    }

    @Test
    public void testFindHamlet() {

        Assert.assertTrue(hamletText.contains("Hamlet"));
    }

    @Test
    public void testFindFile() throws FileNotFoundException {
        hamletParser.findHamlet();
    }
}