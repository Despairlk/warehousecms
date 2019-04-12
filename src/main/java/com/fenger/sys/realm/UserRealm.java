package com.fenger.sys.realm;

import com.fenger.sys.domain.User;
import com.fenger.sys.service.UserService;
import com.fenger.sys.utils.ActivityUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    /**
     * 授权
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        ActivityUser activityUser = (ActivityUser) principal.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> permissions = activityUser.getPermissions();
        List<String> roles = activityUser.getRoles();
        if(permissions!=null&&permissions.size()>0){
        info.addStringPermissions(permissions);
        }
        if(roles!=null&&roles.size()>0){
        info.addRoles(roles);
        }
        return info;
    }



    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String  loginname = (String) authenticationToken.getPrincipal();
        char[] pwd = (char[]) authenticationToken.getCredentials();
        String password = new String(pwd);
        User user = userService.selectByLoginname(loginname);
        ActivityUser activityUser = new ActivityUser();
        if(null!=user) {
            activityUser.setUser(user);
            //做密码匹配
            ByteSource credentialsSalt= ByteSource.Util.bytes(user.getSalt());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activityUser, user.getPwd(),credentialsSalt, getName());
            return info;
        }else {
            return null;
        }

    }
}
