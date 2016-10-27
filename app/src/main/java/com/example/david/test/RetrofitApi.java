package com.example.david.test;

import java.util.Date;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by David on 16/9/7.
 */
public interface RetrofitApi {
    @GET("repos/{owner}/{repo}/contributors")
    Call<ResponseBody> contributorsBySimpleGetCall(@Path("owner") String owner, @Path("repo") String repo);


    /**
     * @param projectCode
     * @param groupsCode
     * @param deviceCode
     * @param faultName
     * @param deptCode
     * @param faultDate
     * @param remark
     * @param status
     *
     * @return
     * @Part MultipartBody.Part file
     */
    // @Headers({"Content-Type: multipart/form-data","boundary:--ZnGpDtePMx0KrHh_G0X99Yef9r8JZsRJSXC","Accept: application/json", "Connection: Keep-Alive"})//需要添加头
    //此endpoint 调试通过。
    @Multipart
    @POST("deviceFault/editDeviceFault")
    Call<ResponseBody> postAsk(@Part("projectCode") RequestBody projectCode,
                               @Part("groupsCode") RequestBody groupsCode,
                               @Part("deviceCode") RequestBody deviceCode,
                               @Part("faultName") RequestBody faultName,
                               @Part("deptCode") RequestBody deptCode,
                               @Part("faultDate") RequestBody faultDate,
                               @Part("remark") RequestBody remark,
                               @Part("status") RequestBody status,
                               @Part MultipartBody.Part file
                               //@Part("file\"; filename=\"file1\"") RequestBody imgs
    );


//    @Multipart  //此endpoint 程序崩溃。
//    //@Headers({"Content-Type: multipart/form-data", "boundary:--ZnGpDtePMx0KrHh_G0X99Yef9r8JZsRJSXC", "Accept: application/json", "Connection: Keep-Alive"})//需要添加头
//    @POST("deviceFault/editDeviceFault")
//    Call<ResponseBody> postAsk(@Query("projectCode") String projectCode,
//                               @Query("groupsCode") String groupsCode,
//                               @Query("deviceCode") String deviceCode,
//                               @Query("faultName") String faultName,
//                               @Query("deptCode") String deptCode,
//                               @Query("faultDate") String faultDate,
//                               @Query("remark") String remark,
//                               @Query("status") String status);

    //此endpoint 调试失败。
//    @Multipart
//    //@Headers({"Content-Type: multipart/form-data", "boundary:--ZnGpDtePMx0KrHh_G0X99Yef9r8JZsRJSXC", "Accept: application/json", "Connection: Keep-Alive"})//需要添加头
//    @POST("deviceFault/editDeviceFault")
//    Call<ResponseBody> postAsk(@Part("projectCode") String projectCode,
//                               @Part("groupsCode") String groupsCode,
//                               @Part("deviceCode") String deviceCode,
//                               @Part("faultName") String faultName,
//                               @Part("deptCode") String deptCode,
//                               @Part("faultDate") String faultDate,
//                               @Part("remark") String remark,
//                               @Part("status") String status);


//    @Multipart  //此endpoint 调试失败。
//    //@Headers({"Content-Type: multipart/form-data", "boundary:--ZnGpDtePMx0KrHh_G0X99Yef9r8JZsRJSXC", "Accept: application/json", "Connection: Keep-Alive"})//需要添加头
//    @POST("deviceFault/editDeviceFault")
//    Call<ResponseBody> postAsk(@Field("projectCode") String projectCode,
//                               @Field("groupsCode") String groupsCode,
//                               @Field("deviceCode") String deviceCode,
//                               @Field("faultName") String faultName,
//                               @Field("deptCode") String deptCode,
//                               @Field("faultDate") String faultDate,
//                               @Field("remark") String remark,
//                               @Field("status") String status);


    //此endpoint 调试失败。
//    @FormUrlEncoded
//    //@Headers({"Content-Type: multipart/form-data", "boundary:--ZnGpDtePMx0KrHh_G0X99Yef9r8JZsRJSXC", "Accept: application/json", "Connection: Keep-Alive"})//需要添加头
//    @POST("deviceFault/editDeviceFault")
//    Call<ResponseBody> postAsk(@Field("projectCode") String projectCode,
//                               @Field("groupsCode") String groupsCode,
//                               @Field("deviceCode") String deviceCode,
//                               @Field("faultName") String faultName,
//                               @Field("deptCode") String deptCode,
//                               @Field("faultDate") String faultDate,
//                               @Field("remark") String remark,
//                               @Field("status") String status);

    //此point程序崩溃。
//    @FormUrlEncoded
//    //@Headers({"Content-Type: multipart/form-data", "boundary:--ZnGpDtePMx0KrHh_G0X99Yef9r8JZsRJSXC", "Accept: application/json", "Connection: Keep-Alive"})//需要添加头
//    @POST("deviceFault/editDeviceFault")
//    Call<ResponseBody> postAsk(@Query("projectCode") String projectCode,
//                               @Query("groupsCode") String groupsCode,
//                               @Query("deviceCode") String deviceCode,
//                               @Query("faultName") String faultName,
//                               @Query("deptCode") String deptCode,
//                               @Query("faultDate") String faultDate,
//                               @Query("remark") String remark,
//                               @Query("status") String status);


}
