package io.jtools.totp.dpAccountUserdepts.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import io.jtools.totp.dpAccountUserdepts.domain.DpAccoutUserdepts;

public interface DpAccoutUserdeptsRepository extends JpaRepository<DpAccoutUserdepts, Integer> {
	@Modifying
	@Transactional
	@Query(value = "UPDATE DpAccoutUserdepts x "
			+ "SET "
			+ " x.mailpassword = ?1 "
			+ "WHERE x.userid = ?2")
	public void updatePassword(String password, int userid);

}
