package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Functions {
    
    public String converterData(String dataNascimento) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            Date data = formato.parse(dataNascimento);

            formato.applyPattern("yyyy-MM-dd");

            return formato.format(data);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
