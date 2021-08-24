package wixis360;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootCrudApplication {

	private static final Logger log = LoggerFactory.getLogger(BootCrudApplication.class);

	public static void main(String args[]) {
		SpringApplication.run(BootCrudApplication.class, args);
	}

//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@Override
//	public void run(String... args) throws Exception {
//		log.info("Creating Tables");
//
//		jdbcTemplate.execute("DROP TABLE employee IF EXISTS");
//		jdbcTemplate.execute("CREATE TABLE employee(" +
//				"id VARCHAR(10)) , name VARCHAR(50), contact INT , address VARCHAR(100) ");
//
//
//
//	}
}
