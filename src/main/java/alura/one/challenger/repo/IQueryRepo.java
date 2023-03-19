package alura.one.challenger.repo;

import alura.one.challenger.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQueryRepo extends JpaRepository<Info, Integer> {
}
