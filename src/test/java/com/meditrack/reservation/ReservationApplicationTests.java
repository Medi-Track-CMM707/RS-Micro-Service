package com.meditrack.reservation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
class ReservationApplicationTests {

	@Test
	void testDatabaseConnection() {
		assertDoesNotThrow(() -> {
			// Ensure datasource is autowired and usable
			DataSource dataSource = applicationContext.getBean(DataSource.class);
			try (Connection connection = dataSource.getConnection()) {
				assertNotNull(connection);
			}
		});
	}
}
