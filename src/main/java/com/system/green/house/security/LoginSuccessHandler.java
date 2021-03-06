package com.system.green.house.security;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler  {
	
	@Transactional
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		SessionFlashMapManager sessionFlashMapManager = new SessionFlashMapManager();
		FlashMap flashMap = new FlashMap();
		flashMap.put("success", "Bienvenid@ " + authentication.getName());
		sessionFlashMapManager.saveOutputFlashMap(flashMap, request, response);
		if(authentication !=  null) {
			logger.info("El usuario " + authentication.getName() 
			+ " ha iniciado sesión con éxito " + Calendar.getInstance().get(Calendar.SHORT_FORMAT));
		}		
		super.onAuthenticationSuccess(request, response, authentication);
	}	
	
}
