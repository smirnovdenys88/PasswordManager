package com.project.password.manager.secure.jwt.dto;

public class UserDto {

    private int id;
    private String username;
    private String email;
    private String password;
    private String activationCode;
    private boolean autoplay = true;
    private boolean autoplayMuted = false;

    private String phoneNumber;
    private Long countryId;
    private Long languageId;

    private boolean systemNotification;
    private boolean videoNotification;
    private boolean userNotification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public boolean isSystemNotification() {
        return systemNotification;
    }

    public void setSystemNotification(boolean systemNotification) {
        this.systemNotification = systemNotification;
    }

    public boolean isVideoNotification() {
        return videoNotification;
    }

    public void setVideoNotification(boolean videoNotification) {
        this.videoNotification = videoNotification;
    }

    public boolean isUserNotification() {
        return userNotification;
    }

    public void setUserNotification(boolean userNotification) {
        this.userNotification = userNotification;
    }

    public boolean getAutoplay() {
        return autoplay;
    }

    public void setAutoplay(boolean autoplay) {
        this.autoplay = autoplay;
    }

    public boolean getAutoplayMuted() {
        return autoplayMuted;
    }

    public void setAutoplayMuted(boolean autoplayMuted) {
        this.autoplayMuted = autoplayMuted;
    }
}
