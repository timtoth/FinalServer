package edu.neumont.csc380.service;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import models.Auction;
import models.Bid;
import models.Item;

@Service("AuctionService")
public class AuctionServiceImpl implements AuctionService {

	Auction auctionDataLayer = new Auction();
	public Response createAuction(Item item) {
		boolean success = auctionDataLayer.addAuction(item);
		if(success)
			return Response.status(Response.Status.CONFLICT).build();
		return Response.status(Response.Status.CREATED).build();
	}

	public Response getAllAuctions() {
		List<Item> items = auctionDataLayer.getAllAuctions();
		return Response.ok(items, MediaType.APPLICATION_JSON).build();
	}

	public Response getAuction(int id) {
		Item auction = auctionDataLayer.getItemById(id);
		if(auction == null)
			return Response.status(Response.Status.NOT_FOUND).build();
		return Response.ok(auction, MediaType.APPLICATION_JSON).build();
	}

	public Response deleteBid(int id ,Bid bid) {
		if(auctionDataLayer.removeBid(id, bid))
			return Response.status(Response.Status.NOT_FOUND).build();
		return Response.status(204).build();
	}

	public Response updateItem(int id,Item item) {
		if(auctionDataLayer.updateItem(item, id))
			return Response.notModified().build();
		return Response.ok().build();
	}

	public Response placeBid(int id, Bid bid) {
		if(auctionDataLayer.addBid(id, bid))
			return Response.notModified().build();
		return Response.ok();
	}

}
