package es.uca.iw.iwbank;

import es.uca.iw.iwbank.data.entity.Persona;
import es.uca.iw.iwbank.data.entity.Rol;
import es.uca.iw.iwbank.data.service.FinancialMovementService;
import es.uca.iw.iwbank.data.service.MailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MailServiceTest {

    @InjectMocks
    private MailService mailService;

    private Persona persona;

    @Before
    public void createPersona(){
        persona = new Persona("000000F", "apellido1", "nombre1", new Rol("USER"),  "joseportroyal237@gmail.com", "password1");
    }

    @Test
    public void MailServiceTest(){

        // Enviar contraseña nueva al cliente
        mailService.SendPasswordToClient("joseportroyal237@gmail.com", "ESTE PASWWORD ES UNA PRUEBA");

        // Enviar un correo de confirmacion de solicitud al cliente y al empleado con el motivo de solicitud
        mailService.SendMailToClient("Prueba de solicitud", "+34999999", "joseportroyal237@gmail.com", "esto es una prueba", persona);
    }

}
