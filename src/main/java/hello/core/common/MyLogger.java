package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

@Scope(value = "request")
public class MyLogger {
  private String uuid;
  private String requestUrl;

  public MyLogger(String requestUrl) {
    this.requestUrl = requestUrl;
  }

  public void log(String message) {
    System.out.println("[" + uuid + "]" + "[" + requestUrl + "]" + message);
  }

  @PostConstruct
  public void init() {
    uuid = UUID.randomUUID().toString();
    System.out.println("[" + uuid + "] request scope bean create : " + this);
  }

  @PreDestroy
  public void close() {
    System.out.println("[" + uuid + "] request scope bean create : " + this);
  }
}
