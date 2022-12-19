package com.example.webscannerhoneypot;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;

@RestController
public class WebScannerHoneypotController implements WebMvcConfigurer {
    private static final String REPEATED_MESSAGE = "Not found\n";
    private static final long MESSAGE_INTERVAL_MILLIS = 5000;


    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.initialize();

        configurer.setTaskExecutor(executor);
        configurer.setDefaultTimeout(-1);
    }

    @GetMapping("/**")
    public StreamingResponseBody handleAnyGet() {
        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream out) throws IOException {
                while (true) {
                    out.write(REPEATED_MESSAGE.getBytes());
                    out.flush();
                    try {
                        Thread.sleep(MESSAGE_INTERVAL_MILLIS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}
