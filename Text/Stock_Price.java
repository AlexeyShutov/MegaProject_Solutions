package Text;

/**
 * Program: Get Current Stock Price
 * Programmer: Harsha Kuchampudi
 * Date: May 18, 2015
 *
 * Description: A program which can go out and check
 * the current value of stocks for a list of symbols
 * entered by the user.
 */

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Stock_Price {

    public static void main(String []args) throws IOException {

        // Scanner Creation
        Scanner input = new Scanner(System.in);

        // User Interaction Dialogue
        System.out.print("Please Enter the Stock Tag You Wish to Get the Current Prices For (e.g. AAPL): ");
        String userChoice = input.next();

        // Get Stock Data
        String[] returnedData = getStockData(userChoice);

        // Output Data:
        System.out.println("Stock Tag: " + returnedData[0]);
        System.out.println("Asking Price: " + returnedData[1]);
        System.out.println("Bidding Price: " + returnedData[2]);

    }

    public static String[] getStockData(String stockLabel) throws IOException {

        // URL Generation
        String urlString = "http://finance.yahoo.com/d/quotes.csv?s=" + stockLabel.toUpperCase() + "&f=sab";

        // URL Creation
        URL url = new URL(urlString);

        // Reading Returned Data
        Scanner fileReader = new Scanner(url.openStream());
        String stockData = fileReader.nextLine();

        // Split Data into Components
        String[] stockDataList = stockData.split(",");

        // Return Data Array
        return stockDataList;

    }

}
