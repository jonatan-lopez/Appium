package helpers;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {


    public String getRandomAlphaNumString(int numDigits)
    {
        String ID;
        ID = RandomStringUtils.random(numDigits, true, true);
        System.out.println("ID is "+ ID);
        return ID;

    }
}
