package alura.one.challenger.service;

import alura.one.challenger.model.ApiResponse;

import java.util.List;

public interface IApiResponse {

    ApiResponse save(ApiResponse apiResponse);

    List<ApiResponse> findAll();

    ApiResponse findById(Long id);

    ApiResponse update(ApiResponse apiResponse, Long id);

    void delete(Long id);
}
