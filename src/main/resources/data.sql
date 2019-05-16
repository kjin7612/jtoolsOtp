USE K2IS;

--INSERT INTO GAUTH (username, password, otp_secret_key) VALUES ('', '7dbc3273-5955-4cd4-9ef2-db19ab6c0483', '');
-- 비밀번호는 PasswordEncoderTest 클래스를 이용해서 생성한 것을 저장
-- otp-secret-key 는 UserServiceTest 통합테스트를 통해서 발송된 QR 코드의 secret 을 입력



--insert into user(username, password, otp_secret_key) values('username', 'password', 'otp-secret-key');
-- 비밀번호는 PasswordEncoderTest 클래스를 이용해서 생성한 것을 저장
-- otp-secret-key 는 UserServiceTest 통합테스트를 통해서 발송된 QR 코드의 secret 을 입력