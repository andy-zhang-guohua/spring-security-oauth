package andy.demo.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cross-Origin Resource Sharing 跨域资源共享 ,它允许浏览器向跨源服务器，发出XMLHttpRequest请求，从而克服了AJAX只能同源使用的限制
 * Spring MVC通过CORS协议解决跨域问题
 *
 * 浏览器是如何支持 CORS协议的 : 当JS代码发起 AJAX 请求时，浏览器会自动判断这是否是一个跨域请求，如果是，先发送一个OPTIONS请求询问
 * 是否可以跨域访问该资源,这个过程称之为"预检",然后浏览器才发送真正JS程序设定的请求；如果不是，浏览器会直接发送JS程序设定的请求。
 *
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletResponse response = (HttpServletResponse) res;
    response.setHeader("Access-Control-Allow-Origin", "*");//允许AJAX请求的来源
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");//允许的外域请求
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type"); // 允许的跨域请求头部
        response.setHeader("Access-Control-Max-Age", "3600");// 单位：秒，3600 表示１小时
        //response.setHeader("Access-Control-Allow-Credentials","true"); // 允许 cookies
        if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }
}