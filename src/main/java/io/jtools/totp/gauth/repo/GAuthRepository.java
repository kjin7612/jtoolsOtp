package io.jtools.totp.gauth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import io.jtools.totp.gauth.domain.GAuth;

public interface GAuthRepository extends JpaRepository<GAuth, Long> {
	GAuth findByEmail(String email);
	
	@Query("SELECT x.id FROM GAuth x where x.email = ?")
	Long userSelctEmailForAuth(String email);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM GAuth x where x.email = ?")
	void deleteUserbyEmail(String email);

}
