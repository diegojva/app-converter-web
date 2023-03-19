package alura.one.challenger.repo;

import alura.one.challenger.model.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApiResponseRepo extends JpaRepository<ApiResponse, Integer> {

}
