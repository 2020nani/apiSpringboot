package com.api.digitalbank.repository;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
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
	//validar cpf

	    public static boolean ValidaCPF(String CPF) {
	        
	        if (CPF.equals("00000000000") ||
	            CPF.equals("11111111111") ||
	            CPF.equals("22222222222") || CPF.equals("33333333333") ||
	            CPF.equals("44444444444") || CPF.equals("55555555555") ||
	            CPF.equals("66666666666") || CPF.equals("77777777777") ||
	            CPF.equals("88888888888") || CPF.equals("99999999999") ||
	            (CPF.length() != 11))
	            return(false);

	        char dig10, dig11;
	        int sm, i, r, num, peso;

	        
	        try {
	        
	            sm = 0;
	            peso = 10;
	            for (i=0; i<9; i++) {
	        
	            num = (int)(CPF.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                dig10 = '0';
	            else dig10 = (char)(r + 48); 
	            
	            sm = 0;
	            peso = 11;
	            for(i=0; i<10; i++) {
	            num = (int)(CPF.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                 dig11 = '0';
	            else dig11 = (char)(r + 48);

	            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
	                 return(true);
	            else return(false);
	                } catch (InputMismatchException erro) {
	                return(false);
	            }
	        }

	        public static String imprimeCPF(String CPF) {
	            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
	            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
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
