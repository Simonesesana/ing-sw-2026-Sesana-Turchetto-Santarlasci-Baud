package model;

import model.Deck.Cards.BuildingCard;
import model.Deck.Cards.TribeCards.TribeCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tribe {

    // Attributes
    private final String name;
    private int food;
    private int prestigePoints;

    // Cards in hand
    private final List<TribeCard> hand;

    // Acquired buildings
    private final List<BuildingCard> buildings;

    // Constructor
    public Tribe(String name, int startingFood) {
        this.name = name;
        this.food = startingFood;
        this.prestigePoints = 0;
        this.hand = new ArrayList<>();
        this.buildings = new ArrayList<>();
    }

    // Food management
    public void addFood(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Food amount must be non-negative");
        }
        this.food += amount;
    }

    public boolean spendFood(int amount) {
        if (this.food < amount) {
            return false;
        }
        this.food -= amount;
        return true;
    }

    // Prestige management
    public void addPrestigePoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Prestige points to add must be non-negative");
        }
        this.prestigePoints += points;
    }

    public void removePrestigePoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Prestige points to remove must be non-negative");
        }
        this.prestigePoints = Math.max(0, this.prestigePoints - points);
    }

    // Hand management
    public void addCardToHand(TribeCard card) {
        hand.add(card);
    }

    public boolean removeCardFromHand(TribeCard card) {
        return hand.remove(card);
    }

    // Building management
    public void addBuilding(BuildingCard building) {
        buildings.add(building);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getFood() {
        return food;
    }

    public int getPrestigePoints() {
        return prestigePoints;
    }

    public List<TribeCard> getHand() {
        return Collections.unmodifiableList(hand);
    }

    public List<BuildingCard> getBuildings() {
        return Collections.unmodifiableList(buildings);
    }

}
