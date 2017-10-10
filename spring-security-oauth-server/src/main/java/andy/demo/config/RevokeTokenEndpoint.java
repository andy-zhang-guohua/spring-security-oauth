package andy.demo.config;

import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@FrameworkEndpoint
public class RevokeTokenEndpoint {

    @Resource(name = "tokenServices")
    ConsumerTokenServices tokenServices;

    /**
     * token回收功能，注意这里的 HTTP Method 是 DELETE
     *
     * @param request
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/oauth/token")
    @ResponseBody
    public void revokeToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.contains("Bearer")) {
            String tokenId = authorization.substring("Bearer".length() + 1);
            tokenServices.revokeToken(tokenId);
        }
    }

}