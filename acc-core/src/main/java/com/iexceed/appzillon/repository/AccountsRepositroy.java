package com.iexceed.appzillon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iexceed.appzillon.entity.TbAccountMaster;
@Repository
public interface AccountsRepositroy extends
		CrudRepository<TbAccountMaster, String> {

}
