package Exchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CurrencyRate {
    double rate;
    String mOrigen, mFinal;

    public CurrencyRate(String mOrigen, String mFinal) {
        this.mOrigen = mOrigen;
        this.mFinal = mFinal;
    }

    public String getmOrigen() {
        return mOrigen;
    }

    public void setmOrigen(String mOrigen) {
        this.mOrigen = mOrigen;
    }

    public String getmFinal() {
        return mFinal;
    }

    public void setmFinal(String mFinal) {
        this.mFinal = mFinal;
    }
    
    public double rate(String mOrigen, String mFinal) throws MalformedURLException, IOException {
        URL url = new URL("https://free.currconv.com/api/v7/convert?q=" + mOrigen + "_" + mFinal + "&compact=ultra&apiKey=68af9a7d365674ae2230");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(":")+1, line.indexOf("}"));
            rate = Double.parseDouble(line1);
            return rate;
        }
    }
}
