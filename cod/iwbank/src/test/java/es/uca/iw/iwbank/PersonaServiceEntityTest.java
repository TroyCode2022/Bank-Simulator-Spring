package es.uca.iw.iwbank;

import es.uca.iw.iwbank.data.entity.BankAccount;
import es.uca.iw.iwbank.data.entity.Persona;
import es.uca.iw.iwbank.data.entity.Rol;
import es.uca.iw.iwbank.data.repository.PersonaRepository;
import es.uca.iw.iwbank.data.service.PersonaService;
;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.junit.Before;

import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class PersonaServiceEntityTest {
    @Mock
    private PersonaRepository personaRepository;
    @InjectMocks
    private PersonaService personaService;
    private  Persona persona1;
    private  Persona persona2;
    private  BankAccount bankAccount;
    private  List<BankAccount> lb = new ArrayList<>();


    // Inicializacion de datos
    @Before
    public void createPersonas(){
        bankAccount = new BankAccount("IBANPRUEBA123123", new BigDecimal(100));
        lb.add(bankAccount);
        persona1 = new Persona("000000F", "apellido1", "nombre1", new Rol("USER"),  "email1@uca.es", "password1");

        persona1.setAccount(bankAccount);
        persona2 = new Persona("111111G", "apellido2", "nombre2", new Rol("ADMIN"),  "email2@uca.es", "password2");

        List<Persona> personas = new ArrayList<>();
        personas.add(persona1);
        personas.add(persona2);
        when(personaRepository.findAll()).thenReturn(personas);
        when(personaRepository.findByNombre("nombre1")).thenReturn(Optional.ofNullable(persona1));
    }

    @Test
    public void PersonaServiceEntityTest(){

        if(personaService.findPersonaByName("nombre1").isPresent())
            Assert.assertEquals("nombre1", personaService.findPersonaByName("nombre1").get().getNombre() );

        Assert.assertEquals(1, personaService.getActiveUsers().size() ); // Busa solo los activos y que sean de ROL "USER"
        Assert.assertEquals(1, personaService.getExistsAccounts(persona1).size());
        personaService.DesvinculaClienteCuentas(persona1, lb );  //Desvincular persona de cuenta
        Assert.assertEquals(0, persona1.getAccounts().size());

    }

}
