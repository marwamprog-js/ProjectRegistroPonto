/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.registro.util;

import br.com.registro.view.RegistroPonto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 *
 * @author user_mw
 */
public class HoraUtil implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Calendar now = Calendar.getInstance();
        RegistroPonto.jLabelHora.setText(String.format("%1$tH : %1$tM : %1$tS", now));
    }

}