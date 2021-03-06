package com.techknowera.erc.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Component
public class ContractService {

	private static final Logger log = LoggerFactory.getLogger(ContractService.class);

	public String getVersion() throws Exception {

		Web3j web3j = Web3j.build(new HttpService("https://rinkeby.infura.io/d6CwyxLdbs96EotcCpiX"));

		log.info("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion());

		return web3j.web3ClientVersion().send().getWeb3ClientVersion();

	}
	
	
	public String createWallet() throws Exception {
		
		File folder = new File("C:\\Users\\santo\\git\\erc20-rest-api\\src\\main\\resources\\wallets");
		String fileName = WalletUtils.generateNewWalletFile("September*09", folder, true);
		log.info("wallet file created");
		
		return  fileName;
		
	}

}
