package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author vinni
 */
public class PropertiesHandler {

    /**
     * Método responsável por capturar os dados do dbconnection.properties.
     *
     * @return retorna um ArrayList com os dados do arquivo
     * dbconnection.properties.
     */
    public ArrayList<String> getParamsDBConnectionProperties() {

        try {

            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\Resources\\dbconnection.properties");

            properties.load(fis);

            ArrayList<String> result = new ArrayList<>();

            result.add(properties.getProperty("url"));
            result.add(properties.getProperty("usuario"));
            result.add(properties.getProperty("senha"));

            return result;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
