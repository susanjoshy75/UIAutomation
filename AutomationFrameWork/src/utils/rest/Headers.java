package utils.rest;

import org.apache.http.Header;

public class Headers {

	public Header[] headers; //response.getAllHeaders();

    public String getHeader(String name) {
        for (Header header : headers) {
            if (header.getName().equals(name)) {
                return header.getValue();
            }
        }
        return null;
    }

    public String getContentType() {
        return getHeader("Content-Type");
    }

    public String getContentLength()
    {
        return getHeader("Content-length") ;
    }

    public String getServer() { 
    	return getHeader("Server");
    	}

    public String getAccept()
    {
        return getHeader("Accept-Ranges");
    }

    public String getLastModified()
    {
        return getHeader("Last-Modified");
    }

    public String getDate()
    {
        return getHeader("Date");
    }
}
