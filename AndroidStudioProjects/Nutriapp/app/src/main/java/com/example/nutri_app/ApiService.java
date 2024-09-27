package com.example.nutri_app;

import java.util.List;

public interface ApiService {
    @GET("students")
    Call<List<Student>> getStudents();

    @POST("students")
    Call<Student> createStudent(@Body Student student);

    @GET("students/{id}")
    Call<Student> getStudent(@Path("id") int id);

    @PUT("students/{id}")
    Call<Student> updateStudent(@Path("id") int id, @Body Student student);

    @DELETE("students/{id}")
    Call<Void> deleteStudent(@Path("id") int id);
}