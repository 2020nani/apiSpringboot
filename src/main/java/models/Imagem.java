package models;

import java.awt.image.BufferedImage;

import javax.persistence.*;


public class Imagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
    
	private BufferedImage profile;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BufferedImage getProfile() {
		return profile;
	}

	public void setProfile(BufferedImage profile) {
		this.profile = profile;
	}

	
    
	
   
   
}
