package io.jtools.totp.userAuth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jtools.totp.userAuth.domain.UserAuth;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

}
