package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

import static common.ConstantMessages.DEFAULT_REPORT_SEPARATOR;
import static common.ConstantMessages.PLAYER_REPORT_INFO;

public abstract class BasePlayer implements Player {
    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.cardRepository = cardRepository;
        this.setUsername(username);
        this.setHealth(health);
        this.setDead(false);
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < 0) {
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
        }

        this.health = healthPoints;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }
        this.username = username;
    }

    private void setDead(boolean dead) {
        this.isDead = dead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < 0) {
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }
        this.health -= damagePoints;

        if (this.health <= 0) {
            this.health = 0;
            this.isDead = true;
        }
    }

    @Override
    public String toString() {
        String message = String.format(PLAYER_REPORT_INFO, this.getUsername(), this.getHealth(),
                this.getCardRepository().getCount());

        StringBuilder sb = new StringBuilder();
        sb.append(message).append(System.lineSeparator());

        this.getCardRepository()
                .getCards()
                .forEach(c -> sb.append(c.toString())
                        .append(System.lineSeparator()));

        sb.append(DEFAULT_REPORT_SEPARATOR);

        return sb.toString().trim();
    }
}
