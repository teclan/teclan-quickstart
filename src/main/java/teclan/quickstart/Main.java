package teclan.quickstart;

import java.io.Console;
import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Main {
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


	public static void main(String[] args) {

		File file = new File("config/application.conf");

		Config root = ConfigFactory.parseFile(file);
		Config config = root.getConfig("config");
		String ip = config.getString("es.ip");
		int port = config.getInt("es.port");

		LOGGER.info("ip={}, port={}", ip, port);

		Console cs = System.console();

		if (cs == null) {
			return;
		}
		System.out.println("\n\n按任意键退出....");

		while (cs.readLine() != null) {
			System.exit(0);
		}

	}

}
