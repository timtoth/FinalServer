package edu.neumont.csc380.hello.service;

public class VideoNotFoundException extends Exception{

	public VideoNotFoundException()
	{
		super();
	}
	
	public VideoNotFoundException(String message)
	{
		super(message);
	}
	
	public VideoNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public VideoNotFoundException(Throwable cause)
	{
		super(cause);
	}

}
