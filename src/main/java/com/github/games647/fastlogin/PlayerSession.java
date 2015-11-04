package com.github.games647.fastlogin;

/**
 * Represents a client connecting to the server.
 *
 * This session is invalid if the player disconnects or the login was successful
 */
public class PlayerSession {

    private final String username;
    private final String serverId;
    private final byte[] verifyToken;
    private boolean verified;

    public PlayerSession(String username, String serverId, byte[] verifyToken) {
        this.username = username;
        this.serverId = serverId;
        this.verifyToken = verifyToken;
    }

    /**
     * Gets the random generated server id. This makes sure the request
     * sent from the client is just for this server.
     *
     * See this for details
     * http://www.sk89q.com/2011/09/minecraft-name-spoofing-exploit/
     *
     * @return random generated server id
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * Gets the verify token the server sent to the client.
     *
     * @return the verify token from the server
     */
    public byte[] getVerifyToken() {
        return verifyToken;
    }

    /**
     * Gets the username the player sent to the server
     *
     * @return the client sent username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets whether the player has a premium (paid account) account
     * and valid session
     *
     * @param verified whether the player has valid session
     */
    public synchronized void setVerified(boolean verified) {
        this.verified = verified;
    }

    /**
     * Get whether the player has a premium (paid account) account
     * and valid session
     *
     * @return whether the player has a valid session
     */
    public synchronized boolean isVerified() {
        return verified;
    }
}
