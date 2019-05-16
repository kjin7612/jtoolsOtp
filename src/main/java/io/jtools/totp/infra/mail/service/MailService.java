package io.jtools.totp.infra.mail.service;

import java.util.List;

import io.jtools.totp.infra.mail.domain.MailMessage;

public interface MailService {

	/**
	 * Send {@link MailMessage}
	 * 
	 * @param mailMessage
	 */
	void send(MailMessage mailMessage);
	
	/**
	 * Send {@link MailMessage} list
	 * @param mailMessages
	 */
	void send(List<MailMessage> mailMessages);
}
