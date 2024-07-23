package com.highway.ventilation;

import com.highway.ventilation.service.CommunicationFrameService;
import com.highway.ventilation.socket.SocketServer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@RequiredArgsConstructor
@EnableScheduling
public class VentilationApplication implements CommandLineRunner {



	private final SocketServer socketServer;


	public static void main(String[] args) {
		SpringApplication.run(VentilationApplication.class, args);
	}




	@Override
	public void run(String... args) {
		socketServer.startServer();

		// 애플리케이션 종료 시 소켓 서버를 종료합니다.
		Runtime.getRuntime().addShutdownHook(new Thread(socketServer::stopServer));
	}
}
