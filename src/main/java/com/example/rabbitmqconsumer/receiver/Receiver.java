package com.example.rabbitmqconsumer.receiver;

import java.util.concurrent.CountDownLatch;

import com.example.rabbitmqconsumer.entity.Colaborador;
import com.example.rabbitmqconsumer.repository.ColaboradorRepository;
import com.example.rabbitmqconsumer.util.SenhaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(Integer message) {
        System.out.println("Received <" + message + ">");

        Colaborador colaborador = colaboradorRepository.findById(message).get();

        colaborador.setScore(SenhaUtil.calculaComplexidade(colaborador.getSenha()));
        colaborador.setSenha(SenhaUtil.encryptPassword(colaborador.getSenha()));

        colaboradorRepository.save(colaborador);

        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
