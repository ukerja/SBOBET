package net.simplifiedlearning.volleymysqlexample;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface DaftarAPI {
    @FormUrlEncoded
    @POST("/RetrofitExample/insert4.php")
    public void insertRegis(
            @Field("name") String name,
            @Field("bank") String bank,
            @Field("account_number") String account_number,
            @Field("phone_number") String phone_number,

            Callback<Response> callback);
}
