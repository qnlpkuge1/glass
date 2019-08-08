package com.goosun.glass.service;

import org.junit.Test;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PersistentTokenServiceTest extends BaseServiceTest {


    @Resource(name = "persistentTokenService")
    PersistentTokenRepository persistentTokenService;

    //@Test
    public void testCreateNewToken() {
        PersistentRememberMeToken token = mockupPersistentRememberMeToken();
        persistentTokenService.createNewToken(token);

        PersistentRememberMeToken savedToken = persistentTokenService.getTokenForSeries(token.getSeries());
        assertNotNull(savedToken);
        assertEquals(token.getUsername(), savedToken.getUsername());
        assertEquals(token.getSeries(), savedToken.getSeries());
        assertEquals(token.getTokenValue(), savedToken.getTokenValue());
        assertThat(token.getDate()).isInSameMinuteAs(savedToken.getDate());
    }

    //@Test
    public void testUpdateToken() {
        PersistentRememberMeToken token = mockupPersistentRememberMeToken();
        persistentTokenService.createNewToken(token);
        PersistentRememberMeToken savedToken = persistentTokenService.getTokenForSeries(token.getSeries());
        assertNotNull(savedToken);

        String fastTokenValue = "new-fast-token-value";
        Date fastLastUsed = new Date();

        persistentTokenService.updateToken(savedToken.getSeries(), fastTokenValue, fastLastUsed);
        PersistentRememberMeToken updatedToken = persistentTokenService.getTokenForSeries(token.getSeries());
        assertNotNull(updatedToken);

        assertEquals(token.getUsername(), updatedToken.getUsername());
        assertEquals(token.getSeries(), updatedToken.getSeries());
        assertEquals(fastTokenValue, updatedToken.getTokenValue());
        assertThat(fastLastUsed).isInSameMinuteAs(updatedToken.getDate());

    }

   // @Test
    public void testRemoveUserTokens(){
        PersistentRememberMeToken token = mockupPersistentRememberMeToken();
        persistentTokenService.createNewToken(token);

        PersistentRememberMeToken savedToken = persistentTokenService.getTokenForSeries(token.getSeries());
        assertNotNull(savedToken);

        persistentTokenService.removeUserTokens(token.getUsername());
        PersistentRememberMeToken deletedToken = persistentTokenService.getTokenForSeries(token.getSeries());
        assertNull(deletedToken);

    }


    private PersistentRememberMeToken mockupPersistentRememberMeToken() {
        return new PersistentRememberMeToken("test", "drools", "a97a1986ffd633f19591511d0a1db025", new Date());
    }
}
