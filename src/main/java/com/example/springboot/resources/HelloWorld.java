package com.example.springboot.resources;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/")
	public String index() {
		List<String> hostAddresses = new ArrayList<>();
		try {
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			while (networkInterfaces.hasMoreElements()) {
				var interfaces = networkInterfaces.nextElement();
				Enumeration<InetAddress> internetAddress = interfaces.getInetAddresses();
				while (internetAddress.hasMoreElements()) {
					InetAddress inetAddress = internetAddress.nextElement();
					hostAddresses.add(inetAddress.getHostAddress());
				}
			}
		} catch (Exception ex) {
			return ex.getMessage();
		}

		StringBuilder htmlString = new StringBuilder();
		htmlString.append("<h1>hello world</h1>");
		if (!hostAddresses.isEmpty()) {
			htmlString.append("<h2>Hello from these host addresses</h2>");
			htmlString.append("<ul>");
			for (String hostAddress : hostAddresses) {
				htmlString.append("    <li>").append(hostAddress).append("</li>");
			}
			htmlString.append("</ul>");
		}
		
		return htmlString.toString();
	}
    
}
