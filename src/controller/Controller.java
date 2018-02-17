package controller;

import atmException.ATMException;
import atm.ATM;
import printer.View;


public class Controller {

    private final ATM caixa = new ATM();
    private final View view = new View();
    private boolean isLOGADO;

    public void options() {
        view.showOptions();
    }

    public void logar() {
        view.askForAccount();
        try {
            this.isLOGADO = caixa.logar(view.getInputValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void executarOpcao(int opcao) {
        if (this.isLOGADO) {
            try {
                view.printOption(opcao);
                caixa.executeOption(opcao);
            } catch (ATMException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
