package com.bootcamp.bank.operaciones.infrastructure.repository;

import com.bootcamp.bank.operaciones.infrastructure.repository.dao.OperacionCtaDao;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OperacionesCuentaRepository extends ReactiveMongoRepository<OperacionCtaDao,String> {
    @Query("{'idCliente':?0}")
    Flux<OperacionCtaDao> findByIdCliente(String idCliente);

    @Query("{'numeroCuenta':?0}")
    Flux<OperacionCtaDao> findByNumeroCuenta(String numeroCuenta);

    Flux<OperacionCtaDao> findByNumeroCuentaAndTipoOperacion(String numeroCuenta,String tipoOperacion);
}
