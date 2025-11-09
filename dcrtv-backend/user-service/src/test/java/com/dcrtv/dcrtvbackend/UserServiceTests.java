package com.dcrtv.dcrtvbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTests {

    @Autowired
    private DiscoveryClient discoveryClient;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * 测试服务发现功能
     * 通过DiscoveryClient获取当前已发现的服务数量并输出到控制台
     */
    @Test
    void serviceUrl() {
        System.out.println("发现的服务数量: " + discoveryClient.getServices().size());
    }

    /**
     * 测试/hello端点是否返回正确的响应
     * 验证端点是否可访问且返回期望的欢迎消息
     */
    @Test
    void testHelloEndpoint() {
        String url = "http://localhost:" + port + "/api/hello";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Hello, World!");
    }

    /**
     * 测试状态端点是否正常工作
     * 验证服务状态端点返回正确的HTTP状态码和响应内容
     */
    @Test
    void testStatusEndpoint() {
        String url = "http://localhost:" + port + "/api/status";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Service is running");
    }
}