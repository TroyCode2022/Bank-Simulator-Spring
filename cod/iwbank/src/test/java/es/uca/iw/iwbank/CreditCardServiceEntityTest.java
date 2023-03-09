package es.uca.iw.iwbank;
import es.uca.iw.iwbank.controllers.CardTransaction;
import es.uca.iw.iwbank.data.entity.BankAccount;
import es.uca.iw.iwbank.data.entity.CreditCard;
import es.uca.iw.iwbank.data.repository.BankAccountRepository;
import es.uca.iw.iwbank.data.repository.CreditCardRepository;
import es.uca.iw.iwbank.data.service.BankAccountService;
import es.uca.iw.iwbank.data.service.CreditCardService;

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


@RunWith(MockitoJUnitRunner.class)
public class CreditCardServiceEntityTest {

    @Mock
    private CreditCardRepository creditCardRepository;

    @Mock
    private BankAccountService bankAccountService;

    @Mock
    private BankAccountRepository bankAccountRepository;

    @InjectMocks
    private CreditCardService creditCardService;

    private CreditCard card1;
    private  CreditCard card2;
    private  CreditCard card3;

    private CardTransaction cardTransaction;
    private  BankAccount bankAccount;
    private  BankAccount bankAccount2;
    private  List<CreditCard> lc = new ArrayList<>();
    private  List<BankAccount> lb = new ArrayList<>();

    private  String ntarjeta = "111111111";

    @Before
    public void createCreditCard(){
        bankAccount = new BankAccount("IBANPRUEBA123123", new BigDecimal(100));
        bankAccount2 = new BankAccount("IBANPRUEBA222222", new BigDecimal(200));
        lb.add(bankAccount);
        lb.add(bankAccount2);
        card1 = new CreditCard("111111111", new BigDecimal(900), 10, 26,"123", bankAccount, "VISA");
        card2 = new CreditCard("222222222", new BigDecimal(900), 11, 17,"123", bankAccount, "MASTERCARD ");
        card3 = new CreditCard("333333333", new BigDecimal(900), 7, 25,"123", bankAccount2, "MASTERCARD ");
        lc.add(card1);
        lc.add(card2);
        lc.add(card3);

        when(creditCardRepository.findAll()).thenReturn(lc);
    }

    @Test
    public void CreditCardServiceEntityTest(){

        Assert.assertEquals(3,creditCardService.findAllCreditCard().size());

        // Fecha expiracion
        Assert.assertEquals(true, creditCardService.checkExpire(card1)); //checkExpire devuelve true si la tarjeta no ha expirado o false si ha expirado
        Assert.assertEquals(false, creditCardService.checkExpire(card2));

        // Comprobar que la tarjeta esta activa y no ha expirado
        Assert.assertEquals(true, creditCardService.checkExpireAndActive(card1));
        card1.setActive(false);
        Assert.assertEquals(false, creditCardService.checkExpireAndActive(card1));
        card1.setActive(true);

        // Obtener tarjetas asociadas a cuentas
        Assert.assertEquals(3, creditCardService.getCardsByAccounts(lb).size());

        // Crear nueva tarjeta Conectandonos a una API externa para generar el numero
        String ntarjetaGenerado = creditCardService.CreateNewCard("VISA", bankAccount);
        Assert.assertEquals(16, ntarjetaGenerado.length());




    }


}
