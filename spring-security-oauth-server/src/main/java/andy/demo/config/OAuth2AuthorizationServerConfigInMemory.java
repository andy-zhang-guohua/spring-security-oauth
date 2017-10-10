package andy.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;

import java.util.Arrays;

//@Configuration
//@PropertySource({ "classpath:persistence.properties" })
//@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfigInMemory extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private Environment env;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory().withClient("sampleClientId").authorizedGrantTypes("implicit")
                .scopes("read", "write", "foo", "bar").autoApprove(false).accessTokenValiditySeconds(3600)

                .and().withClient("fooClientIdPassword").secret("secret")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("foo", "read", "write")
                .accessTokenValiditySeconds(3600) // 1 hour
                .refreshTokenValiditySeconds(2592000) // 30 days

                .and().withClient("barClientIdPassword").secret("secret")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("bar", "read", "write")
                .accessTokenValiditySeconds(3600) // 1 hour
                .refreshTokenValiditySeconds(2592000) // 30 days
        ;
    }

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer()));
        endpoints.tokenEnhancer(tokenEnhancerChain).authenticationManager(authenticationManager);
    }


    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }
}
