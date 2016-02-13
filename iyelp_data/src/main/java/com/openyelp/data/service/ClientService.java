package com.openyelp.data.service;

import java.util.List;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.Client;


@RestFul(api=ClientService.class,value="ClientService")
public interface ClientService {
	public Pagination getPage(int pageNo, int pageSize);

	public Client findById(String string);

	public Client save(Client bean);

	public Client update(Client bean);

	public Client deleteById(Integer id);
	
	public Client[] deleteByIds(Integer[] ids);
	
    List<Client> findAll();

    Client findByClientId(String clientId);
    Client findByClientSecret(String clientSecret);
}