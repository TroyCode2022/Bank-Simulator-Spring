package es.uca.iw.iwbank;

import es.uca.iw.iwbank.data.entity.*;
import es.uca.iw.iwbank.data.repository.BankAccountRepository;
import es.uca.iw.iwbank.data.repository.FinancialMovementRepository;
import es.uca.iw.iwbank.data.service.BankAccountService;
import es.uca.iw.iwbank.data.service.FinancialMovementService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FinancialMovementServiceEntityTest {

    @InjectMocks
    private FinancialMovementService financialMovementService;
    @Mock
    private FinancialMovementRepository financialMovementRepository;

    @Mock
    private BankAccountService bankAccountService;

    private  FinancialMovement financialMovement1;
    private  FinancialMovement financialMovement2;
    private BankAccount bankAccount1;
    private  BankAccount bankAccount2;
    private List<FinancialMovement> lf = new ArrayList<>();



    @Before
    public void createCreditCard(){
        bankAccount1 = new BankAccount("IBANPRUEBA123123", new BigDecimal(500));
        bankAccount2 = new BankAccount("IBANPRUEBA222222", new BigDecimal(600));
        financialMovement1 = new FinancialMovement(new BigDecimal(100), "Gasto1", "ACCEPTED",  "WITHDRAWAL", "CARD",
                new Date(), bankAccount1, bankAccount2);
        financialMovement2 = new FinancialMovement(new BigDecimal(50), "Ingreso2", "ACCEPTED",  "DEPOSIT", "CARD",
                new Date(), bankAccount2, bankAccount1);

        lf.add(financialMovement1);
        lf.add(financialMovement2);
        List<FinancialMovement> lmovingreso = new ArrayList<>();
        lmovingreso.add(financialMovement2);

        when(financialMovementRepository.findAll()).thenReturn(lf);
        when(financialMovementRepository.findByTransactiontypeAndDestino("DEPOSIT", bankAccount1)).thenReturn(lmovingreso);
        when(bankAccountService.findBankAccountByIBAN("IBANPRUEBA123123")).thenReturn(Optional.of(bankAccount1));
        when(bankAccountService.findBankAccountByIBAN("IBANPRUEBA222222")).thenReturn(Optional.of(bankAccount2));
        when(bankAccountService.findBankAccountByIBAN("default")).thenReturn(Optional.of(bankAccount1));


    }

    @Test
    public void FinancialMovementServiceEntityTest(){

        // Buscar cuentas / Movimientos
        Assert.assertEquals(2, financialMovementService.findAll().size());
        Assert.assertEquals("Ingreso2", financialMovementService.MovimientosIngreso(bankAccount1).get(0).getConcept());

        // Realizar transferencia Externa, Cuentas locales
        Assert.assertEquals(true,  financialMovementService.ExternalTransfer("Prueba envio", new BigDecimal(100), "IBANPRUEBA123123", "IBANXXXXXX"));
        Assert.assertEquals(true,  financialMovementService.LocalTransfer("Prueba envio2", new BigDecimal(100), "IBANPRUEBA123123", "IBANPRUEBA222222"));

    }
}
