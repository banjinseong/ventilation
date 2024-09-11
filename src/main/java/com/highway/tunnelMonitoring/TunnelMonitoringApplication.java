package com.highway.tunnelMonitoring;

//import com.highway.tunnelMonitoring.socket.SocketServer;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.highway.tunnelMonitoring.mapper.power")
@MapperScan("com.highway.tunnelMonitoring.mapper.ventilation")
public class TunnelMonitoringApplication {






	public static void main(String[] args) {
		SpringApplication.run(TunnelMonitoringApplication.class, args);
	}

//	private final SocketServer socketServer;

//
//	@Override
//	public void run(String... args) {
//		socketServer.startServer();
//
//		// 애플리케이션 종료 시 소켓 서버를 종료합니다.
//		Runtime.getRuntime().addShutdownHook(new Thread(socketServer::stopServer));
//	}
}
