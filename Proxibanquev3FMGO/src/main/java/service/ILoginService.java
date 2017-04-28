package service;

import metier.Conseiller;

public interface ILoginService {
	public Conseiller verificationLogin(String login, String pwd);
}
