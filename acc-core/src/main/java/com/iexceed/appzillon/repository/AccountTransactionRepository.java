package com.iexceed.appzillon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iexceed.appzillon.entity.TbTransactionMaster;
@Repository
public interface AccountTransactionRepository extends CrudRepository<TbTransactionMaster, String> {

}
