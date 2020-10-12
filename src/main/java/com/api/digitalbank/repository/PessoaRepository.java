package com.api.digitalbank.repository;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.digitalbank.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long > {
	//validar email
	public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
	
	/*//validar data
	public static int calculaIdade(String nascimento) {

		// Data de hoje.
		GregorianCalendar hoje = new GregorianCalendar();
		int diah = hoje.get(Calendar.DAY_OF_MONTH);
		int mesh = hoje.get(Calendar.MONTH) + 1;
		int anoh = hoje.get(Calendar.YEAR);

		// Data do nascimento.
		int dian = Integer.valueOf(nascimento.substring(0,2));
		int mesn = Integer.valueOf(nascimento.substring(3,5));
		int anon = Integer.valueOf(nascimento.substring(6,10));

		// Idade.
		int idade;

		if (mesn < mesh || (mesn == mesh && dian <= diah))
		idade = anoh - anon;
		else
		idade = (anoh - anon)-1;

		return (idade);
		}*/

	Optional<Pessoa> findByCpf(String cpf);
	
	Optional<Pessoa> findByEmail(String email);

}
