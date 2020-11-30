package net.simplifiedlearning.volleymysqlexample;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface WithdrawAPI {
    @FormUrlEncoded
    @POST("/RetrofitExample/insert2.php")
    public void insertWithdraw(

            @Field("iduser") String iduser,
            @Field("nominal") String nominal,

            Callback<Response> callback);
}
