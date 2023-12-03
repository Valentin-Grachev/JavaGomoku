
package com.vg.gomoku.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for clientAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="clientAction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="player" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="moveX" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="moveY" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clientAction", propOrder = {
    "player",
    "moveX",
    "moveY"
})
public class ClientAction {

    protected int player;
    protected int moveX;
    protected int moveY;

    /**
     * Gets the value of the player property.
     * 
     */
    public int getPlayer() {
        return player;
    }

    /**
     * Sets the value of the player property.
     * 
     */
    public void setPlayer(int value) {
        this.player = value;
    }

    /**
     * Gets the value of the moveX property.
     * 
     */
    public int getMoveX() {
        return moveX;
    }

    /**
     * Sets the value of the moveX property.
     * 
     */
    public void setMoveX(int value) {
        this.moveX = value;
    }

    /**
     * Gets the value of the moveY property.
     * 
     */
    public int getMoveY() {
        return moveY;
    }

    /**
     * Sets the value of the moveY property.
     * 
     */
    public void setMoveY(int value) {
        this.moveY = value;
    }

}
