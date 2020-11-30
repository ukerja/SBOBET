package net.simplifiedlearning.volleymysqlexample;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/RetrofitExample/insert3.php")
    public void insertUser(

            @Field("iduser") String iduser,
            @Field("nominal") String nominal,

            Callback<Response> callback);
}
