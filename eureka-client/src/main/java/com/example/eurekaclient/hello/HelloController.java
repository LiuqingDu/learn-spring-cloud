package com.example.eurekaclient.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping("/{applicationName}")
  public List<ServiceInstance> hello(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}

}
