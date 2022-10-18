package br.com.cod3r.facade.facade;

import br.com.cod3r.facade.model.Card;
import br.com.cod3r.facade.model.Register;
import br.com.cod3r.facade.services.CardService;
import br.com.cod3r.facade.services.PaymentService;
import br.com.cod3r.facade.services.RegisterService;
import br.com.cod3r.facade.services.ReportService;
import br.com.cod3r.facade.services.SecurityService;
import java.util.List;

public class CallCenterFacade {

    private CardService cardService;
    private RegisterService registerService;
    private ReportService reportService;
    private PaymentService paymentService;
    private SecurityService securityService;

    public CallCenterFacade() {
        this.cardService = new CardService();
        this.registerService = new RegisterService();
        this.reportService = new ReportService(registerService);
        this.paymentService = new PaymentService(registerService);
        this.securityService = new SecurityService(cardService, registerService);
    }

    public Card getCardByUser(Long l) {
        return this.cardService.getCardByUser(l);
    }

    public void getSumary(Card card) {
        this.reportService.getSumary(card);
    }

    public void getPaymentInfoByCard(Card card) {
        this.paymentService.getPaymentInfoByCard(card);
    }

    public void cancelLastRegister(Card card) {
        final List<Register> registers = this.registerService.getRegistersByCard(card);
        registerService.removeByIndex(card, registers.size() - 1);
        final List<Register> pendingRegisters = this.securityService.blockCard(card);
        final Card newCard = this.cardService.createNewCard(123456L, 33445566L);
        this.registerService.addCardRegisters(newCard, pendingRegisters);
        this.reportService.getSumary(newCard);
    }
}
