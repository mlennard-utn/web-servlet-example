package service;

import modelo.Registration;
import servicio.RegistrationService;

public class RegistrationServiceTest {
	public static void main(String[] args) {
		Registration r = new Registration();
		RegistrationService service = new RegistrationService();
		
		System.out.println("Should be false: " + service.hasNotEmptyFields(r));
		
		r.setEmail("");
		r.setFirstName("");
		r.setLastName("");

		System.out.println("Should be false: " + service.hasNotEmptyFields(r));

		r.setEmail(" ");
		r.setFirstName(" ");
		r.setLastName(" ");

		System.out.println("Should be false: " + service.hasNotEmptyFields(r));

		r.setEmail("alal@al.com");
		r.setFirstName("");
		r.setLastName("");

		System.out.println("Should be false: " + service.hasNotEmptyFields(r));

		r.setEmail("alal@al.com");
		r.setFirstName("pololo");
		r.setLastName("papa");

		System.out.println("Should be true: " + service.hasNotEmptyFields(r));
		
	}
}
