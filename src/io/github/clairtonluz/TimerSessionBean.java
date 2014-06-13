package io.github.clairtonluz;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Singleton
@Startup
public class TimerSessionBean {

	@Resource
	TimerService timerService;

	private static final Logger logger = Logger
			.getLogger("timersession.ejb.TimerSessionBean");

	@Timeout
	public void programmaticTimeout(Timer timer) {
		logger.info("Programmatic timeout occurred.");
	}

	/**
	 * Esse metodo é executado a cada 1 minuto de cada hora
	 */
	@Schedule(minute = "*/1", hour = "*", persistent = false)
	public void automaticTimeout() {
		logger.info("Entrou no agendamento ");
	}

	/**
	 * Executado o método todo sábado a meia noite.
	 */
	@Schedule(dayOfWeek = "Sun", hour = "0")
	public void sabado() {
		logger.info("Domingo meia noite");
	}

	/**
	 * Executado o método de segunda a sexta.
	 */
	@Schedule(dayOfWeek = "Mon, Tue, Wed, Thu, Fri", hour = "0")
	public void semana() {
		logger.info("Segunda a Sexta meia noite");
	}

	/**
	 * Executado o método de segunda a sexta.
	 */
	@Schedule(dayOfWeek = "Mon - Fri", hour = "0")
	public void semana2() {
		logger.info("Segunda a Sexta meia noite");
	}
	
	/**
	 * Executado o método de segunda a sexta.
	 */
	@Schedule(dayOfMonth="Last")
	public void ultimoDiaDoMes() {
		logger.info("Ultimo dia do mês");
	}

}