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
            @Field("nama") String nama,
            @Field("bank") String bank,
            @Field("norek") String norek,
            @Field("nohp") String nohp,

            Callback<Response> callback);
}
