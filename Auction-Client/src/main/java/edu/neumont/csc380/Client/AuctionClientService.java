package edu.neumont.csc380.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import models.Auction;
import models.Bid;
import models.Item;
import edu.neumont.csc380.Interfaces.AuctionService;

import org.apache.cxf.jaxrs.provider.json.*;

public class AuctionClientService
{
	private final AuctionService proxy;
	private JSONProvider<Object> jsonProvider;
	public AuctionClientService()
	{
		jsonProvider = new JSONProvider<Object>();
		jsonProvider.setIgnoreNamespaces(true);
		proxy = JAXRSClientFactory.create("http://localhost:7076/hellorest-server/rest", AuctionService.class, Arrays.asList(jsonProvider), true);
	}

	public Item createAuction(Item item)
	{
		Response resp = proxy.createAuction(item);
		Item itemCreated = null;
		if(resp.getStatus()==200)
		{
			itemCreated = resp.readEntity(Item.class);
		}
		return itemCreated;
	}

	public List<Item> getAllAuctions()
	{
		Response resp = proxy.getAllAuctions();
		List<Item> items = null;
		if(resp.getStatus()==200)
		{
			items = resp.readEntity(ArrayList.class);
		}
		return items;
	}

	public Response getAuction(int id)
	{
		Response resp = proxy.getAuction(id);
		Item itemRetrieved = null;
		if(resp.getStatus()==200)
		{
			itemRetrieved = resp.readEntity(Item.class);
		}
		return null;
	}

	public void deleteBid(Bid bid)
	{
		Response r = proxy.deleteBid(bid);
	}

	public Item updateItem(Item item)
	{
		return proxy.updateItem(item).readEntity(Item.class);
	}

	public Bid placeBid(int id)
	{
		return proxy.placeBid(id).readEntity(Bid.class);
	}

}
