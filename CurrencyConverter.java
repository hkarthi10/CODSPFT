import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {

public static double getExchangeRate(String baseCurrency, String targetCurrency) {
    try {
        String apiUrl = "https://api.frankfurter.app/latest?amount=1&from=" + baseCurrency + "&to=" + targetCurrency;
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder responseContent = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            responseContent.append(line);
        }
        reader.close();

        JSONObject jsonObject = new JSONObject(responseContent.toString());
        double rate = jsonObject.getJSONObject("rates").getDouble(targetCurrency);
        return rate;

    } catch (Exception e) {
        System.out.println("Error fetching exchange rate: " + e.getMessage());
        return -1;
    }
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Currency Converter ===");

        System.out.print("Enter base currency (e.g. USD, INR, EUR): ");
        String base = sc.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g. USD, INR, EUR): ");
        String target = sc.nextLine().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        double rate = getExchangeRate(base, target);

        if (rate != -1) {
            double convertedAmount = amount * rate;
            System.out.printf("\n%.2f %s = %.2f %s\n", amount, base, convertedAmount, target);
        } else {
            System.out.println("Conversion failed due to API issue.");
        }

        sc.close();
    }
}

//compiling command: javac -cp ".;json-20230227.jar" CurrencyConverter.java
//run : java -cp ".;json-20230227.jar" CurrencyConverter