/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciamentobancario2;

/**
 *
 * @author nelso
 */
import java.text.DecimalFormat;


public class ContaBancaria {
    private double saldo;
    private DecimalFormat decimalFormat;

    public ContaBancaria() {
        saldo = 0.0;
        decimalFormat = new DecimalFormat("#0.00");
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public String getSaldoFormatado() {
        return decimalFormat.format(saldo);
    }
}
