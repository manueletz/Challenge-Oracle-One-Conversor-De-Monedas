package apis;

import java.io.*;
import okhttp3.*;

public class GetApi {
  public static void main(String []args) throws IOException{
    OkHttpClient client = new OkHttpClient().newBuilder().build();

    Request request = new Request.Builder()
      .url("https://api.apilayer.com/currency_data/change?start_date={start_date}&end_date={end_date}")
      .addHeader("apikey", "T5lxIUvLY5jAjIlw9ZbFD68UFLtpzuDi")
      .method("GET", null)
      .build();
    Response response = client.newCall(request).execute();
    System.out.println(response.body().string());
  }
}