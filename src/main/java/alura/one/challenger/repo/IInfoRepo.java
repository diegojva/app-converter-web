package alura.one.challenger.repo;

import alura.one.challenger.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInfoRepo extends JpaRepository<Info, Integer> {
}
