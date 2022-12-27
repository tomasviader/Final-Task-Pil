package repository;

import model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    @Transactional
    @Modifying
    @Query("update Zone z set z.name = ?1")
    int updateNameBy(@Nullable String name);
}
