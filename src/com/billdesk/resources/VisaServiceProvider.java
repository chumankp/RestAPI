package com.billdesk.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

@Path("/visa")
public class VisaServiceProvider implements BillDeskProvider {

	@Override
	public StreamingOutput pay(InputStream inputStream) {
		return new StreamingOutput() {
			@Override
			public void write(OutputStream output) throws IOException, WebApplicationException {
				StringBuilder builder = new StringBuilder();
				builder.append("<visa-card><tnx-id>123</tnx-id><status>conf</status></visa-card>");
				output.write(builder.toString().getBytes());
				output.close();
			}
		};
	}

}
