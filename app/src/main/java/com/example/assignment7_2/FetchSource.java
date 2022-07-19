package com.example.assignment7_2;

import android.os.AsyncTask;
import android.widget.TextView;


public class FetchSource extends AsyncTask<String, Void, String> {
    private TextView mURL;
    private TextView mSource;

    public FetchSource(TextView url, TextView source){
        mURL = url;
        mSource = source;
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtil.getSource(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mSource.setText(s);
    }
}

/*
* public class FetchBook extends AsyncTask<String, Void, String>{
    private TextView mTitleText;
    private TextView mAuthorText;

    public FetchBook(TextView title, TextView author){
        mTitleText = title;
        mAuthorText = author;
    }


    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtil.getBookInfo(strings[0]);
    }

    //Do nothing no progress updates
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        int i =0;
        String title = null;
        String author = null;
        try{
            JSONObject jsonObject = new JSONObject(s);
            JSONArray items = jsonObject.getJSONArray("items");
            while(i < items.length() && (author == null && title == null)){
                title = null;
                author = null;
                JSONObject book = items.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                try{
                    title = volumeInfo.getString("title");
                    author = volumeInfo.getString("authors");
                }catch (Exception e){
                    mTitleText.setText(R.string.no_results);
                    mAuthorText.setText("");
                    e.printStackTrace();
                }
                i++;
            }

            if(title != null && author !=null){
                mTitleText.setText(title);
                mAuthorText.setText(author);
            } else{
                mTitleText.setText(R.string.no_results);
                mAuthorText.setText("");
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        super.onPostExecute(s);
    }
}
* */