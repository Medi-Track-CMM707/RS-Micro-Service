// package com.meditrack.reservation;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class ReservationApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(ReservationApplication.class, args);
// 	}

// }
package com.meditrack.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.meditrack.reservation"})
public class ReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
    }
}
