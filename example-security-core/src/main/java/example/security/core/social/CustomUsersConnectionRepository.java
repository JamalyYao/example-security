package example.security.core.social;

import example.security.thirdservice.services.SecurityService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CustomUsersConnectionRepository implements UsersConnectionRepository {

    @Autowired
    private SecurityService securityService;

    private ConnectionFactoryLocator connectionFactoryLocator;//连接工厂定位器

    private TextEncryptor textEncryptor;

    private ConnectionSignUp connectionSignUp;

    public CustomUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator, TextEncryptor textEncryptor) {
        this.connectionFactoryLocator = connectionFactoryLocator;
        this.textEncryptor = textEncryptor;
    }

    @Override
    public List<String> findUserIdsWithConnection(Connection<?> connection) {

        ConnectionKey key = connection.getKey();
//        List<String> localUserIds = this.jdbcTemplate.queryForList("select userId from " + this.tablePrefix + "UserConnection where providerId = ? and providerUserId = ?", String.class, new Object[]{key.getProviderId(), key.getProviderUserId()});
        List<String> localUserIds = securityService.getLocalUserIds(key.getProviderId(), key.getProviderUserId());
        if (localUserIds.size() == 0 && this.connectionSignUp != null) {
            String newUserId = this.connectionSignUp.execute(connection);
            if (newUserId != null) {
                this.createConnectionRepository(newUserId).addConnection(connection);
                return Arrays.asList(newUserId);
            }
        }

        return localUserIds;
    }

    @Override
    public Set<String> findUserIdsConnectedTo(String providerId, Set<String> providerUserIds) {

//        MapSqlParameterSource parameters = new MapSqlParameterSource();
//        parameters.addValue("providerId", providerId);
//        parameters.addValue("providerUserIds", providerUserIds);

        Set<String> localUserIds = securityService.queryLocalUserIds(providerId,providerUserIds);
        return localUserIds;

//        final Set<String> localUserIds = new HashSet<String>();
//        return new NamedParameterJdbcTemplate(jdbcTemplate).query("select userId from " + tablePrefix + "UserConnection where providerId = :providerId and providerUserId in (:providerUserIds)", parameters,
//                new ResultSetExtractor<Set<String>>() {
//                    public Set<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
//                        while (rs.next()) {
//                            localUserIds.add(rs.getString("userId"));
//                        }
//                        return localUserIds;
//                    }
//                });
    }

    @Override
    public ConnectionRepository createConnectionRepository(String userId) {

        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        return new CustomConnectionRepository(userId,connectionFactoryLocator, textEncryptor);
    }
}
