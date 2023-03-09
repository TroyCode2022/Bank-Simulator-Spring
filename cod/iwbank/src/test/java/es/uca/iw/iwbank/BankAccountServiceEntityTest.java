package es.uca.iw.iwbank;

import es.uca.iw.iwbank.data.entity.BankAccount;
import es.uca.iw.iwbank.data.entity.CreditCard;
import es.uca.iw.iwbank.data.entity.Persona;
import es.uca.iw.iwbank.data.entity.Rol;
import es.uca.iw.iwbank.data.repository.BankAccountRepository;
import es.uca.iw.iwbank.data.service.BankAccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountServiceEntityTest {

    @InjectMocks
    private BankAccountService bankAccountService;

    @Mock
    private BankAccountRepository bankAccountRepository;

    private BankAccount bankAccount1;
    private  BankAccount bankAccount2;
    private CreditCard card1;
    private Persona persona1;

    private  List<BankAccount> lb = new ArrayList<>();



    @Before
    public void createCreditCard(){
        bankAccount1 = new BankAccount("IBANPRUEBA123123", new BigDecimal(100));
        bankAccount2 = new BankAccount("IBANPRUEBA222222", new BigDecimal(200));
        card1 = new CreditCard("111111111", new BigDecimal(900), 10, 26,"123", bankAccount1, "VISA");
        persona1 = new Persona("000000F", "apellido1", "nombre1", new Rol("USER"),  "email1@uca.es", "password1");
        List<CreditCard> cards = new ArrayList<>();
        List<Persona> personas = new ArrayList<>();
        bankAccount1.setPersonas(personas);
        bankAccount1.setCards(cards);
        lb.add(bankAccount1);
        lb.add(bankAccount2);
        Optional<BankAccount> obank = Optional.of(bankAccount1);

        when(bankAccountRepository.findAll()).thenReturn(lb);
        when(bankAccountRepository.findByIBAN("IBANPRUEBA123123")).thenReturn(obank);

    }

    @Test
    public void BankAccountServiceEntityTest(){

        // Buscar cuentas
        Assert.assertEquals(2,bankAccountService.findAllBankAccount().size());
        Assert.assertEquals("IBANPRUEBA123123",bankAccountService.findBankAccountByIBAN("IBANPRUEBA123123").get().getIBAN());

        // Desactivar cuenta
        bankAccountService.turnOffAccount(bankAccount2);
        Assert.assertEquals(1, bankAccountService.getActiveAccounts().size());
        bankAccountService.turnOnAccount(bankAccount2);
        bankAccountService.turnOffAccount(bankAccount1);
        Assert.assertEquals(1, bankAccountService.getActiveAccounts().size());
        bankAccountService.turnOnAccount(bankAccount1);

        // Quitar y añadir saldo
        BigDecimal cantidadrestar = new BigDecimal(50);
        BigDecimal saldofinal = new BigDecimal(101);
        bankAccountService.substractMoney(new BigDecimal(50), bankAccount1); //Saldo en 50€
        Assert.assertEquals(cantidadrestar, bankAccount1.getSaldo());
        bankAccountService.addMoney(new BigDecimal(51), bankAccount1); //Saldo en 101€
        Assert.assertEquals(saldofinal, bankAccount1.getSaldo());

        //Añadir tarjeta de credito
        Assert.assertEquals(0, bankAccount1.getCards().size());
        bankAccountService.setCreditCard(card1, bankAccount1);
        Assert.assertEquals(1, bankAccount1.getCards().size());
        Assert.assertEquals("111111111", bankAccount1.getCards().get(0).getNtarjeta());

        //Añadir/Desvincular Persona
        Assert.assertEquals(0, bankAccount1.getPersonas().size());
        bankAccountService.addPersonatoAccount(persona1, bankAccount1);
        Assert.assertEquals(1, bankAccount1.getPersonas().size());
        bankAccountService.deletePersonaFromAccount(persona1, bankAccount1);
        Assert.assertEquals(0, bankAccount1.getPersonas().size());

    }
}
