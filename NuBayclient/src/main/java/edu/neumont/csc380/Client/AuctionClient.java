package edu.neumont.csc380.Client;

import edu.neumont.csc380.AuctionInterfaces.IAuction;
import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
import edu.neumont.csc380.auth.client.AuthClientImpl;

public class AuctionClient {
	
	public static void main(String[] args)
	{
		AuthClientImpl ai = new AuthClientImpl();
		try
		{
			ai.createUser("tim", "isnotgay", AuthorityLevel.Admin);
			ai.authenticateUser("tim", "isnotgay");
			ai.deleteUser("tim");
			ai.createUser("adam", "pimpdaddyflex", AuthorityLevel.User);
			ai.updateUser("adam", "cthulu", "pimpdaddyflex", AuthorityLevel.Admin);
		}
		catch(Exception e)
		{
			
		}
	}

}