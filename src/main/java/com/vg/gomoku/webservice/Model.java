
package com.vg.gomoku.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for model complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="model"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lastMoveX" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="lastMoveY" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="gameStarted" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="movePlayerNowNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "model", propOrder = {
    "lastMoveX",
    "lastMoveY",
    "gameStarted",
    "movePlayerNowNumber"
})
public class Model {

    protected int lastMoveX;
    protected int lastMoveY;
    protected boolean gameStarted;
    protected int movePlayerNowNumber;

    /**
     * Gets the value of the lastMoveX property.
     * 
     */
    public int getLastMoveX() {
        return lastMoveX;
    }

    /**
     * Sets the value of the lastMoveX property.
     * 
     */
    public void setLastMoveX(int value) {
        this.lastMoveX = value;
    }

    /**
     * Gets the value of the lastMoveY property.
     * 
     */
    public int getLastMoveY() {
        return lastMoveY;
    }

    /**
     * Sets the value of the lastMoveY property.
     * 
     */
    public void setLastMoveY(int value) {
        this.lastMoveY = value;
    }

    /**
     * Gets the value of the gameStarted property.
     * 
     */
    public boolean isGameStarted() {
        return gameStarted;
    }

    /**
     * Sets the value of the gameStarted property.
     * 
     */
    public void setGameStarted(boolean value) {
        this.gameStarted = value;
    }

    /**
     * Gets the value of the movePlayerNowNumber property.
     * 
     */
    public int getMovePlayerNowNumber() {
        return movePlayerNowNumber;
    }

    /**
     * Sets the value of the movePlayerNowNumber property.
     * 
     */
    public void setMovePlayerNowNumber(int value) {
        this.movePlayerNowNumber = value;
    }

}
