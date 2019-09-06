package servicio;

import modelo.Registration;

public class RegistrationService {

	public boolean isValidRegistration(Registration reg) {

		String firstLetterEmail = Character.toString(reg.getEmail().charAt(0));
		String firstLetterName = Character.toString(reg.getFirstName().charAt(0));

		// Validacion de nombre y apellido
		if (firstLetterEmail.equalsIgnoreCase(firstLetterName)) {
			return reg.getEmail().toLowerCase().contains(reg.getLastName().toLowerCase());
		} else {
			return false;
		}

	}

	public boolean isValidRegistration2(Registration reg) {
		return reg.getEmail().endsWith("gmail.com") || reg.getEmail().endsWith("hotmail.com")
				|| reg.getEmail().endsWith("yahoo.com");

	}

	public boolean hasNotEmptyFields(Registration registration) {

		// Opcion 1
		if (registration.getEmail() != null && registration.getFirstName() != null
				&& registration.getLastName() != null) {
			return !(registration.getEmail().trim().isEmpty() || registration.getFirstName().trim().isEmpty()
					|| registration.getLastName().trim().isEmpty());
		}

		return false;

	}

}
