package com.goosun.glass.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements Serializable, UserDetails{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String username;
	
	private String password;
	
	private String mobile;
	
	private String title;
	
	private String tags;
	
	private String type;
	
	private int point;
	
	private int coin;
	
	private String smallAvatar;
	
	private String mediumAvatar;
	
	private String largeAvatar;
	
	private boolean setup;
	
	private String roles;
	
	private boolean locked;
	
	private long loginTime;
	
	private String loginIp;
	
	private String loginSessionId;
	
	private String createdIp;
	
	private Date createdTime;
	

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public String getSmallAvatar() {
		return smallAvatar;
	}
	public void setSmallAvatar(String smallAvatar) {
		this.smallAvatar = smallAvatar;
	}
	public String getMediumAvatar() {
		return mediumAvatar;
	}
	public void setMediumAvatar(String mediumAvatar) {
		this.mediumAvatar = mediumAvatar;
	}
	public String getLargeAvatar() {
		return largeAvatar;
	}
	public void setLargeAvatar(String largeAvatar) {
		this.largeAvatar = largeAvatar;
	}
	public boolean isSetup() {
		return setup;
	}
	public void setSetup(boolean setup) {
		this.setup = setup;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getLoginSessionId() {
		return loginSessionId;
	}
	public void setLoginSessionId(String loginSessionId) {
		this.loginSessionId = loginSessionId;
	}
	public String getCreatedIp() {
		return createdIp;
	}
	public void setCreatedIp(String createdIp) {
		this.createdIp = createdIp;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
		return authorities;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public String getUsername() {
		return this.username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return !this.locked;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
