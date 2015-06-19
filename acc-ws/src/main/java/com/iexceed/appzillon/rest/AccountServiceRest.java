package com.iexceed.appzillon.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.iexceed.appzillon.accountservice.AccountService;
import com.iexceed.appzillon.accountservice.ServiceController;
import com.iexceed.appzillon.jaxb.AccountCreationReq;
import com.iexceed.appzillon.jaxb.AccountCreationRes;
import com.iexceed.appzillon.jaxb.AccountMasterDeleteReq;
import com.iexceed.appzillon.jaxb.AccountMasterDeleteRes;
import com.iexceed.appzillon.jaxb.AccountMasterQueryRes;
import com.iexceed.appzillon.utils.LoggerUtils;
import javax.ws.rs.POST;

@Path("AccountService")
public class AccountServiceRest {

    public static Logger log = LoggerUtils.getLogger();

    public AccountServiceRest() {
    }

    @Path("AccountCreate")
    @POST
    @Consumes({
        MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({
        MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public AccountCreationRes accountCreation(AccountCreationReq accCreatereq) {
        log.debug("Entered Rest Service");
        AccountService accountService = (AccountService) ServiceController
                .getInstance().getService("AccountService");
        log.debug("Account Service Injected::" + accountService);
        return accountService.saveAccount(accCreatereq);
    }

    @Path("AccountQuery")
    @GET
      @Consumes({
        MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({
        MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public AccountMasterQueryRes accountQuery(
            @QueryParam("accounNO") String accountNO) {
        log.debug("Entered Rest Service");
        AccountService accountService = (AccountService) ServiceController
                .getInstance().getService("AccountService");
        log.debug("Account Service Injected::" + accountService);
        return accountService.queryAccount(accountNO);
    }

    @Path("AccountDelete")
    @POST
      @Consumes({
        MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({
        MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public AccountMasterDeleteRes accountDelete(AccountMasterDeleteReq deleteReq) {
        log.debug("Entered Rest Service");
        AccountService accountService = (AccountService) ServiceController
                .getInstance().getService("AccountService");
        log.debug("Account Service Injected::" + accountService);
        return accountService.deleteAccount(deleteReq);
    }
}
