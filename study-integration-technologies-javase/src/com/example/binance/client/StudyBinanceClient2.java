package com.example.binance.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Rest over http
// 1) Http: Request/Response --> Pull
// 2) Http/2 -> SSE (Server Sent Event) -> Push Notification -> Text (json), cannot stream
public class StudyBinanceClient2 {
	private static final String BINANCE_REST_API = "https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";
	private final static AtomicInteger counter = new AtomicInteger();
	public static void main(String[] args) throws IOException, InterruptedException {
		var httpClient = HttpClient.newBuilder().build();
		var request = HttpRequest.newBuilder().uri(URI.create(BINANCE_REST_API)).build();
		var start = System.currentTimeMillis();
		for (var i=0;i<10;++i) {
			httpClient.sendAsync(request,BodyHandlers.ofString()).thenAcceptAsync( response -> {
				System.err.println(response.body());
				if(counter.incrementAndGet() == 10) {
					var stop = System.currentTimeMillis();
					System.out.println("%d ms".formatted(stop-start));					
				}
			});
			//TimeUnit.MILLISECONDS.sleep(1);
		}
		TimeUnit.SECONDS.sleep(3);
	}

}
