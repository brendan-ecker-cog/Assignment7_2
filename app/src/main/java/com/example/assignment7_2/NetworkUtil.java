package com.example.assignment7_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.BreakIterator;

public class NetworkUtil {
    private static final String TAG = "NetworkUtil";

    static String getSource(String url){
        URL url1 = null;
        try {
            url1 = new URL("https://" + url);

        BufferedReader in = new BufferedReader(new InputStreamReader(url1.openStream()));
        String input;
        StringBuffer stringBuffer = new StringBuffer();
        while ((input = in.readLine()) != null)
        {
            stringBuffer.append(input);
        }
            in.close();
            String htmlData = stringBuffer.toString();
            return htmlData;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Not Found";
    }
}

/*
* private static final String TAG = NetworkUtil.class.getSimpleName();
    // Base URL for Books API.
    private static final String BOOK_BASE_URL =  "https://www.googleapis.com/books/v1/volumes?";
    // Parameter for the search string.
    private static final String QUERY_PARAM = "q";
    // Parameter that limits search results.
    private static final String MAX_RESULTS = "maxResults";
    // Parameter to filter by print type.
    private static final String PRINT_TYPE = "printType";


static String getBookInfo(String query){
    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String bookString = null;
    Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
            .appendQueryParameter(QUERY_PARAM, query)
            .appendQueryParameter(MAX_RESULTS,"3")
            .appendQueryParameter(PRINT_TYPE, "books")
            .build();
    try {
        URL reqURL = new URL(builtURI.toString());
        urlConnection = (HttpURLConnection) reqURL.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            builder.append(line);
            builder.append("\n");
        }
        if(builder.length() == 0){
            return null;
        }

        bookString = builder.toString();
    } catch (IOException e) {
        e.printStackTrace();
    }

    finally {
        if(urlConnection != null){
            urlConnection.disconnect();
        }
        if(reader != null){
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    Log.i(TAG, bookString);
    return bookString;
}
*
* */