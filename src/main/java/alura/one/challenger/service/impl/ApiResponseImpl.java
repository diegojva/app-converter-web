package alura.one.challenger.service.impl;

import alura.one.challenger.model.ApiResponse;
import alura.one.challenger.repo.IApiResponseRepo;
import alura.one.challenger.service.IApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiResponseImpl implements IApiResponse {

    @Autowired
    private IApiResponseRepo apiResponseRepo;

    @Override
    public ApiResponse save(ApiResponse apiResponse) {
        return apiResponseRepo.save(apiResponse);
    }

    @Override
    public List<ApiResponse> findAll() {
        return apiResponseRepo.findAll();
    }

    @Override
    public ApiResponse findById(Long id) {
       return apiResponseRepo.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public ApiResponse update(ApiResponse apiResponse, Long id) {
        ApiResponse apiResponseFound = findById(id);
        if (apiResponseFound != null) {
            apiResponseFound.setDate(apiResponse.getDate());
            apiResponseFound.setInfo(apiResponse.getInfo());
            apiResponseFound.setResult(apiResponse.getResult());
            apiResponseFound.setSuccess(apiResponse.isSuccess());
            apiResponseFound.setQuery(apiResponse.getQuery());
        }else {
            return null;
        }

        return apiResponseRepo.save(apiResponse);
    }

    @Override
    public void delete(Long id) {
        ApiResponse apiResponseFound = findById(id);
        if (apiResponseFound == null) return;
        apiResponseRepo.deleteById(Math.toIntExact(id));
    }
}
