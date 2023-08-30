package com.example.rabbitmqconsumer.repository;

import com.example.rabbitmqconsumer.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
}
