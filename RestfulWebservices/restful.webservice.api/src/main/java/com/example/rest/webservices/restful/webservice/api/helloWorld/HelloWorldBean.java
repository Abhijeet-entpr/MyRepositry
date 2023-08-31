package com.example.rest.webservices.restful.webservice.api.helloWorld;

public class HelloWorldBean {
	
		private String messageGreet; 
		

		public HelloWorldBean(String messageGreet) {
			super();
			this.messageGreet = messageGreet;
		}

		@Override
		public String toString() {
			return "HelloWorldBean [message=" + messageGreet + "]";
		}

		public String getMessageGreet() {
			return messageGreet;
		}

		public void setMessageGreet(String messageGreet) {
			this.messageGreet = messageGreet;
		}
		
}
