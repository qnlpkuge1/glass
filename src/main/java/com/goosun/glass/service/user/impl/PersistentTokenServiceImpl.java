package com.goosun.glass.service.user.impl;

import com.goosun.glass.dao.user.PersistentTokenDao;
import com.goosun.glass.domain.PersistentLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service("persistentTokenService")
public class PersistentTokenServiceImpl implements PersistentTokenRepository {

    @Autowired
    private PersistentTokenDao persistentTokenDao;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        PersistentLogin logins = new PersistentLogin(token.getSeries(),token.getUsername(),token.getTokenValue(),token.getDate());
        persistentTokenDao.add(logins);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        PersistentLogin persistentLogin = new PersistentLogin(series,"",tokenValue,lastUsed);
        persistentTokenDao.update(persistentLogin);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        PersistentLogin logins = persistentTokenDao.getBySeries(seriesId);

        if (logins != null) {
            return new PersistentRememberMeToken(logins.getUsername(),
                    logins.getSeries(), logins.getToken(), logins.getLastUsed());
        }
        return null;
    }

    @Override
    public void removeUserTokens(String username) {
        persistentTokenDao.remove(username);
    }
}
