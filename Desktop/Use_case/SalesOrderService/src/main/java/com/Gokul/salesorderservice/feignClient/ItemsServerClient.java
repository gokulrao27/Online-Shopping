package com.Gokul.salesorderservice.feignClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Gokul.salesorderservice.dto.ItemResponseModel;

import feign.FeignException;
import feign.auth.BasicAuthRequestInterceptor;

@FeignClient(name = "items-ws", fallbackFactory = ItemsFallbackFactory.class, configuration = ItemsServerClientConfiguration.class)
public interface ItemsServerClient {

	@GetMapping("/items/{name}")
	public ItemResponseModel getItemByName(@PathVariable String name);
}

@Configuration
class ItemsServerClientConfiguration {
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("guest", "guest");
	}
}

@Component
class ItemsFallbackFactory implements FallbackFactory<ItemsServerClient> {

	@Override
	public ItemsServerClient create(Throwable cause) {
		// TODO Auto-generated method stub
		return new ItemsServiceClientFallback(cause);
	}

}

class ItemsServiceClientFallback implements ItemsServerClient {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private final Throwable cause;

	public ItemsServiceClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public ItemResponseModel getItemByName(String itemName) {
		// TODO Auto-generated method stub

		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			logger.error("404 error took place when getItemByName was called with userId: " + itemName
					+ ". Error message: " + cause.getLocalizedMessage());
		} else {
			logger.error("Other error took place: " + cause.getLocalizedMessage());
		}

		return null;
	}

}